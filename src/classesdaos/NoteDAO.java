package classesdaos;


import java.util.*;

import classes.Note;

public interface NoteDAO {
    
    void save(Note note);
    void remove(Note note);
    void update(Note note);
    Note findNote(int noteID);
    List<Note> getAllNotes();
    
}
