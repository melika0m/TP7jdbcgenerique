package classesdaos;
import java.util.*;

import classes.Etudiant;

public interface EtudiantDAO {
    
    void save(Etudiant etudiant);
    void remove(Etudiant etudiant);
    void update(Etudiant etudiant);
    Etudiant findEtudiant(int etudiantID);
    List<Etudiant> getAllEtudiants();
    List<Etudiant> getNotesEtudiants();
    
}
