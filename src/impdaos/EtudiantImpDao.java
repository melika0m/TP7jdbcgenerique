package impdaos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Etudiant;
import classes.Note;
import classesdaos.EtudiantDAO;
import mummypackage.dbcnx;

public class EtudiantImpDao implements EtudiantDAO {
    
    Connection con = dbcnx.maConnexion();
    String sql;
    Statement st = null;
    
    @Override
    public void save(Etudiant etudiant) {
        sql = "INSERT INTO Etudiant (EtudiantID, Name, FiliereID) VALUES ('" + etudiant.getEtudiantID() + "', '" + etudiant.getName() + "', '" + etudiant.getFiliereID() + "')";
        try {
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Etudiant inserted correctly!");
            } else {
                System.out.println("Error in insertion!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void remove(Etudiant etudiant) {
        try {
            sql = "DELETE FROM Etudiant WHERE EtudiantID = '" + etudiant.getEtudiantID() + "'";
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Etudiant removed correctly!");
            } else {
                System.out.println("Error in deletion!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void update(Etudiant etudiant) {
        try {
            sql = "UPDATE Etudiant SET Name = '" + etudiant.getName() + "', FiliereID = '" + etudiant.getFiliereID() + "' WHERE EtudiantID = '" + etudiant.getEtudiantID() + "'";
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Etudiant updated correctly!");
            } else {
                System.out.println("Error in update!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public Etudiant findEtudiant(int etudiantID) {
        try {
            sql = "SELECT * FROM Etudiant WHERE EtudiantID = '" + etudiantID + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Etudiant with ID '" + etudiantID + "' is found in the DB");
                Etudiant newEtudiant = new Etudiant(rs.getInt("EtudiantID"), rs.getString("Name"), rs.getInt("FiliereID"));
                return newEtudiant;
            } else {
                System.out.println("Etudiant with ID '" + etudiantID + "' not found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Etudiant> getAllEtudiants() {
        try {
            sql = "SELECT * FROM Etudiant";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Etudiant> listEtudiants = new ArrayList<>();
            while (rs.next()) {
                listEtudiants.add(new Etudiant(rs.getInt("EtudiantID"), rs.getString("Name"), rs.getInt("FiliereID")));
            }
            return listEtudiants;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Note> getNotesEtudiants(int etudiantID) {
        List<Note> notes = new ArrayList<>();
        try {
            sql = "SELECT * FROM Notes WHERE EtudiantID = '" + etudiantID + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                notes.add(new Note(rs.getInt("NoteID"), rs.getBigDecimal("Value"), rs.getInt("EtudiantID"), rs.getInt("MatiereID"), rs.getInt("EnseignantID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

	@Override
	public List<Etudiant> getNotesEtudiants() {
		return null;
	}
}
