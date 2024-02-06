package classesdaos;

import java.util.List;

import classes.Filiere;
import classes.Matiere;


public interface FiliereDAO {
    
    void save(Filiere filiere);
    void remove(Filiere filiere);
    void update(Filiere filiere);
    Filiere findFiliere(int filiereID);
    List<Filiere> getAllFilieres();
    List<Matiere> getMatiere();
    int getNbEtudiant(int filiereID);
    
}