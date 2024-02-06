package classesdaos;

import java.util.List;

import classes.Enseignant;

public interface GenericDAO<T> {
    void save(T entity);
    void remove(T entity);
    void update(T entity);
    T findById(int id);
    List<T> findAll();
	List<Enseignant> getAllEnseignants();
	Enseignant findEnseignant(int enseignantID);
}
