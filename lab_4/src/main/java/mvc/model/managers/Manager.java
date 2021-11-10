package mvc.model.managers;

import java.util.List;

public interface Manager<T> {
    List<T> getBeans();
    T getBeanById(int id);
    boolean addBean(T bean);
    boolean updateBean(int id, T bean);
    boolean deleteBean(int id);
}
