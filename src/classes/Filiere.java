package classes;

public class Filiere {
	private int filiereID;
    private String name;
    
    // Default constructor
    Filiere() {}
    
    // Parameterized constructor
    public Filiere(int filiereID, String name) {
        this.filiereID = filiereID;
        this.name = name;
    }
    
    // Getters
    public int getFiliereID() { return filiereID; }
    public String getName() { return name; }
    
    // Setters
    public void setFiliereID(int filiereID) { this.filiereID = filiereID; }
    public void setName(String name) { this.name = name; }

}
