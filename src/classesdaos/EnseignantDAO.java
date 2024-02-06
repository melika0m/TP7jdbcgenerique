package classesdaos;

import java.util.*;

import classes.Enseignant;

public interface EnseignantDAO {
    
    void save(Enseignant enseignant);
    void remove(Enseignant enseignant);
    void update(Enseignant enseignant);
    Enseignant findEnseignant(int enseignantID);
    List<Enseignant> getAllEnseignants();
    
}
