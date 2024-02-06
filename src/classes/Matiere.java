package classes;

public class Matiere {
    
    private int matiereID;
    private String name;
    private int filiereID; // Foreign key to Filiere
    
    
    Matiere() {}
    
    
    public Matiere(int matiereID, String name, int filiereID) {
        this.matiereID = matiereID;
        this.name = name;
        this.filiereID = filiereID;
    }
    
    
    public int getMatiereID() { return matiereID; }
    public String getName() { return name; }
    public int getFiliereID() { return filiereID; }
    
    
    public void setMatiereID(int matiereID) { this.matiereID = matiereID; }
    public void setName(String name) { this.name = name; }
    public void setFiliereID(int filiereID) { this.filiereID = filiereID; }
    
    
    @Override
    public String toString() {
        return "Matiere{" +
                "matiereID=" + matiereID +
                ", name='" + name + '\'' +
                ", filiereID=" + filiereID +
                '}';
    }
}

