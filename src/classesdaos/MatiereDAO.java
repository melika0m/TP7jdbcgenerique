package classesdaos;


import java.util.*;

import classes.Matiere;

public interface MatiereDAO {
    
    void save(Matiere matiere);
    void remove(Matiere matiere);
    void update(Matiere matiere);
    Matiere findMatiere(int matiereID);
    List<Matiere> getAllMatieres();
    int getNbMauvaise(int matiereID);
    
}

