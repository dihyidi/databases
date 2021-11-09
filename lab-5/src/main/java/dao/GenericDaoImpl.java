package dao;

import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private final Class<T> currentClass;

    protected GenericDaoImpl(Class<T> currentClass) {
        this.currentClass = currentClass;
    }

    @Override
    public List<T> getEntities() {
        List<T> items = new ArrayList<>();

        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            items = session.createQuery("from " + currentClass.getName()).getResultList();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    @Override
    public T getEntityById(int id) {
        T item = null;

        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            item = session.get(currentClass, id);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public boolean addEntity(T entity) {
        boolean isSuccess = true;

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            isSuccess = false;
            System.out.println(e.getMessage());
        }

        return isSuccess;
    }

    @Override
    public boolean updateEntity(int id, T entity) {
        boolean isSuccess = true;

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            isSuccess = false;
            System.out.println(e.getMessage());
        }

        return isSuccess;
    }

    @Override
    public boolean deleteEntity(int id) {
        boolean isSuccess = true;

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            T entity = session.get(currentClass, id);
            if (entity != null) {
                session.delete(entity);
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            isSuccess = false;
            System.out.println(e.getMessage());
    }

        return isSuccess;
    }
}
