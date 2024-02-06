package mummypackage;

import java.util.List;

import classes.Note;

public class NoteS {
	

	    public void getMinMaxNote(int matiereID, List<Note> list_notes) {
	        // Assuming list_notes is already filtered by matiereID
	        Note minNote = null, maxNote = null;
	        for (Note note : list_notes) {
	            if (minNote == null || note.getValue().compareTo(minNote.getValue()) < 0) {
	                minNote = note;
	            }
	            if (maxNote == null || note.getValue().compareTo(maxNote.getValue()) > 0) {
	                maxNote = note;
	            }
	        }

	        if (minNote != null && maxNote != null) {
	            System.out.println("Min Note: " + minNote.getValue() + ", Student ID: " + minNote.getEtudiantID());
	            System.out.println("Max Note: " + maxNote.getValue() + ", Student ID: " + maxNote.getEtudiantID());
	        } else {
	            System.out.println("No notes available for Matiere ID: " + matiereID);
	        }
	    }
	}


