package mummypackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import classes.Enseignant;
import classes.Etudiant;
import classes.Filiere;
import classes.Matiere;
import classes.Note;
import impdaos.EnseignantImpDao;
import impdaos.EtudiantImpDao;
import impdaos.FiliereImpDao;
import impdaos.MatiereImpDao;
import impdaos.NoteImpDao;

public class Show {

	public static void main(String[] args) {
//		EnseignantImpDao enseignantImpDao = new EnseignantImpDao();
//
//        // Test save method
//        Enseignant enseignant1 = new Enseignant(116, "Dr Moussa");
//        Enseignant enseignant2 = new Enseignant(117, " futur dr Melika");
//        enseignantImpDao.save(enseignant1);
//        enseignantImpDao.save(enseignant2);
//        System.out.println("Enseignant saved: " + enseignant1.getName());
//
////        // Test update method
////        enseignant1.setName("Dr Moussa Demba Ba");
////        enseignantImpDao.update(enseignant1);
////        System.out.println("Enseignant updated: " + enseignant1.getName());
//
//        // Test findEnseignant method
//        Enseignant foundEnseignant = enseignantImpDao.findEnseignant(112);
//        if (foundEnseignant != null) {
//            System.out.println("Found Enseignant: " + foundEnseignant.getName());
//        } else {
//            System.out.println("Enseignant not found.");
//        }
//
//        // Test getAllEnseignants method
//        List<Enseignant> allEnseignants = enseignantImpDao.getAllEnseignants();
//        System.out.println("All Enseignants:");
//        for (Enseignant enseignant : allEnseignants) {
//            System.out.println(enseignant.getEnseignantID() + ": " + enseignant.getName());
//        }
//
//        // Test remove method
//        enseignantImpDao.remove(enseignant2);
//        System.out.println("Enseignant removed: " + enseignant2.getName());
        
		///################################## Filiere ###################################//
    
//	FiliereImpDao filiereImpDao = new FiliereImpDao();
//
//    // Test save method
//    Filiere filiere1 = new Filiere(7, "TC");
//    filiereImpDao.save(filiere1);
//    System.out.println("Filiere saved: " + filiere1.getName());
//
//    // Test update method
//    filiere1.setName("TCM");
//    filiereImpDao.update(filiere1);
//    System.out.println("Filiere updated: " + filiere1.getName());
//
//    // Test findFiliere method
//    Filiere foundFiliere = filiereImpDao.findFiliere(2);
//    if (foundFiliere != null) {
//        System.out.println("Found Filiere: " + foundFiliere.getName());
//    } else {
//        System.out.println("Filiere not found.");
//    }
//
//    
//    List<Filiere> allFilieres = filiereImpDao.getAllFilieres();
//    System.out.println("All Filieres:");
//    for (Filiere filiere : allFilieres) {
//        System.out.println(filiere.getFiliereID() + ": " + filiere.getName());
//    }
//
//     
//    int nbEtudiants = filiereImpDao.getNbEtudiant(332);
//    System.out.println("Number of students in Filiere " + filiere1.getName() + ": " + nbEtudiants);
//
//    // Test getMatiere method
//    List<Matiere> matieres = filiereImpDao.getMatiere(221);
//    System.out.println("List of matieres in Filiere " + filiere1.getName() + ":");
//    for (Matiere matiere : matieres) {
//        System.out.println(matiere.getMatiereID() + ": " + matiere.getName());
//    }
//
//    
//    filiereImpDao.remove(filiere1);
//    System.out.println("Filiere removed: " + filiere1.getName());
//
//		//##############################  Matiere  ############################################//
//	MatiereImpDao matiereImpDao = new MatiereImpDao();
//
//    
//    Matiere matiere1 = new Matiere(226, "arab", 2); 
//    matiereImpDao.save(matiere1);
//    System.out.println("Matiere saved: " + matiere1.getName());
// 
//    
//    matiere1.setName("Algo avance");
//    matiereImpDao.update(matiere1);
//    System.out.println("Matiere updated: " + matiere1.getName());
//
//    
//    Matiere foundMatiere = matiereImpDao.findMatiere(221);
//    if (foundMatiere != null) {
//        System.out.println("Found Matiere: " + foundMatiere.getName());
//    } else {
//        System.out.println("Matiere not found.");
//    }
//
//    List<Matiere> allMatieres = matiereImpDao.getAllMatieres();
//    System.out.println("All Matieres:");
//    for (Matiere matiere : allMatieres) {
//        System.out.println(matiere.getMatiereID() + ": " + matiere.getName() + " (FiliereID: " + matiere.getFiliereID() + ")");
//    
//
//
//    int nbMauvaiseNotes = matiereImpDao.getNbMauvaise(221);
//    System.out.println("Number of bad notes (<10) in Matiere " + matiere1.getName() + ": " + nbMauvaiseNotes);
//
//    
//    matiereImpDao.remove(matiere1);
//    System.out.println("Matiere removed: " + matiere1.getName());
//
//		//########################## Etudiants  ##########################//
     EtudiantImpDao etudiantImpDao = new EtudiantImpDao();


     Etudiant etudiant1 = new Etudiant(338, "ttttt", 500); 
     etudiantImpDao.save(etudiant1);
     
     System.out.println("Etudiant saved: " + etudiant1.getName());

     // Test update method
     etudiant1.setName("titi toto");
     etudiantImpDao.update(etudiant1);
     System.out.println("Etudiant updated: " + etudiant1.getName());

   
     Etudiant foundEtudiant = etudiantImpDao.findEtudiant(331);
     if (foundEtudiant != null) {
     System.out.println("Found Etudiant: " + foundEtudiant.getName());
     } else {
     System.out.println("Etudiant not found.");
     }


//     List<Etudiant> allEtudiants = etudiantImpDao.getAllEtudiants();
//     System.out.println("All Etudiants:");
//     for (Etudiant etudiant : allEtudiants) {
//     System.out.println(etudiant.getEtudiantID() + ": " + etudiant.getName() + " (FiliereID: " + etudiant.getFiliereID() + ")");
//     }

     // Test getNotesEtudiants method
//     List<Note> notes = etudiantImpDao.getNotesEtudiants(331);
//     MatiereImpDao matiereImpDao = new MatiereImpDao();
//
//     // Fetch all Matiere objects
//     List<Matiere> allMatieres = matiereImpDao.getAllMatieres();
//
//     // Iterate through the list and print each Matiere
//     for (Matiere matiere : allMatieres) {
//         // This will implicitly call the toString method of the Matiere class
//         System.out.println(matiere);
//     }
//     for (Note note : notes) {
//     System.out.println(note.getNoteID() + ": " + note.getValue() + ", MatiereID: " + note.getMatiereID() + ", EnseignantID: " + note.getEnseignantID());
//     }
//     MatiereImpDao matiereImpDao = new MatiereImpDao();
//     List<Note> notes = etudiantImpDao.getNotesEtudiants(331);
//     List<Matiere> allMatieres = matiereImpDao.getAllMatieres();
//     
//     
//     Map<Integer, String> matiereNames = new HashMap<>();
//     for (Matiere matiere : allMatieres) {
//         matiereNames.put(matiere.getMatiereID(), matiere.getName());
//     }
//
//     // Iterate through the notes and print details with Matiere names
//     for (Note note : notes) {
//         String matiereName = matiereNames.getOrDefault(note.getMatiereID(), "Unknown Matiere");
//         System.out.println("Note ID: " + note.getNoteID() + 
//                            ", Value: " + note.getValue() + 
//                            ", Matiere: " + matiereName + 
//                            ", EnseignantID: " + note.getEnseignantID());
//     }
//     
//   
//
//     etudiantImpDao.remove(etudiant1);
//     System.out.println("Etudiant removed: " + etudiant1.getName());
//
//		//################################### Note ########################################//
//        NoteImpDao noteImpDao = new NoteImpDao();
//
//        
//        Note note1 = new Note(441, new BigDecimal("15.5"), 332, 221, 111); 
//        noteImpDao.save(note1);
//        System.out.println("Note saved: " + note1.getValue());
//
//        // Test update method
//        note1.setValue(new BigDecimal("18.0"));
//        noteImpDao.update(note1);
//        System.out.println("Note updated: " + note1.getValue());
//
//        // Test findNote method
//        Note foundNote = noteImpDao.findNote(801);
//        if (foundNote != null) {
//        System.out.println("Found Note: " + foundNote.getValue());
//        } else {
//        System.out.println("Note not found.");
//        }
//
//        
//        List<Note> allNotes = noteImpDao.getAllNotes();
//        System.out.println("All Notes:");
//        for (Note note : allNotes) {
//        System.out.println("NoteID: " + note.getNoteID() + ", Value: " + note.getValue() + ", EtudiantID: " + note.getEtudiantID() + ", MatiereID: " + note.getMatiereID() + ", EnseignantID: " + note.getEnseignantID());
//        }
//
//     
//        noteImpDao.remove(note1);
//        System.out.println("Note removed: " + note1.getValue());
//
////        // Test getMinMaxNote method
//        
//
//        
//        List<Note> notesForMatiere = new ArrayList<>();
//        int matiereIDForTest = 221; // Example MatiereID
//
//        // Filter notes by MatiereID
//        for (Note note : allNotes) {
//            if (note.getMatiereID() == matiereIDForTest) {
//                notesForMatiere.add(note);
//            }
//        }
//        // Instance of NoteS class
//        NoteS noteS = new NoteS();
//
//        // Test getMinMaxNote method
//        noteS.getMinMaxNote(matiereIDForTest, notesForMatiere);
//    
//    }
}
}
	    
    
    

