package classes;
import java.math.BigDecimal;

public class Note {
    
    private int noteID;
    private BigDecimal value;
    private int etudiantID;
    private int matiereID;
    private int enseignantID;
    
    
    Note() {}
    
   
    public Note(int noteID, BigDecimal value, int string, int string2, int string3) {
        this.noteID = noteID;
        this.value = value;
        this.etudiantID = string;
        this.matiereID = string2;
        this.enseignantID = string3;
    }
    
    
    public int getNoteID() { return noteID; }
    public BigDecimal getValue() { return value; }
    public int getEtudiantID() { return etudiantID; }
    public int getMatiereID() { return matiereID; }
    public int getEnseignantID() { return enseignantID; }
    
   
    public void setNoteID(int noteID) { this.noteID = noteID; }
    public void setValue(BigDecimal value) { this.value = value; }
    public void setEtudiantID(int etudiantID) { this.etudiantID = etudiantID; }
    public void setMatiereID(int matiereID) { this.matiereID = matiereID; }
    public void setEnseignantID(int enseignantID) { this.enseignantID = enseignantID; }
    
    
    @Override
    public String toString() {
        return "Note{" +
                "noteID=" + noteID +
                ", value=" + value +
                ", etudiantID=" + etudiantID +
                ", matiereID=" + matiereID +
                ", enseignantID=" + enseignantID +
                '}';
    }
}
