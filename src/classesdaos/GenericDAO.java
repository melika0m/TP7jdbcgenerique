package classesdaos;


import java.util.List;

public interface GenericDAO<T> {
    void save(T entity);
    void update(T entity);
    T findById(int id);
    void delete(T entity);
    List<T> findAll();
}
