package classes;


public class Enseignant {
    
    private int enseignantID;
    private String name;
    
   
    Enseignant() {}
    
   
    public Enseignant(int enseignantID, String name) {
        this.enseignantID = enseignantID;
        this.name = name;
    }
    
    
    public int getEnseignantID() { return enseignantID; }
    public String getName() { return name; }
    
    
    public void setEnseignantID(int enseignantID) { this.enseignantID = enseignantID; }
    public void setName(String name) { this.name = name; }
    
    
    @Override
    public String toString() {
        return "Enseignant{" +
                "enseignantID=" + enseignantID +
                ", name='" + name + '\'' +
                '}';
    }
}

