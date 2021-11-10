package mvc.controller;

import java.util.List;

public interface Controller<T> {
        List<T> getBeans();
        T getBeanById(int id);
        boolean addBean();
        boolean addBean(T bean);
        boolean updateBean(int id);
        boolean updateBean(int id, T bean);
        boolean deleteBean(int id);
}
