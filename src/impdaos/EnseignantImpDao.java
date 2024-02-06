package impdaos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Enseignant;
import classesdaos.EnseignantDAO;
import mummypackage.dbcnx;

public class EnseignantImpDao implements EnseignantDAO {
    
    Connection con = dbcnx.maConnexion();
    String sql;
    Statement st = null;
    
    @Override
    public void save(Enseignant enseignant) {
        sql = "INSERT INTO Enseignant (EnseignantID, Name) VALUES ('" + enseignant.getEnseignantID() + "', '" + enseignant.getName() + "')";
        try {
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Enseignant inserted correctly!");
            } else {
                System.out.println("Error in insertion!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void remove(Enseignant enseignant) {
        try {
            sql = "DELETE FROM Enseignant WHERE EnseignantID = '" + enseignant.getEnseignantID() + "'";
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Enseignant removed correctly!");
            } else {
                System.out.println("Error in deletion!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void update(Enseignant enseignant) {
        try {
            sql = "UPDATE Enseignant SET Name = '" + enseignant.getName() + "' WHERE EnseignantID = '" + enseignant.getEnseignantID() + "'";
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Enseignant updated correctly!");
            } else {
                System.out.println("Error in update!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public Enseignant findEnseignant(int enseignantID) {
        try {
            sql = "SELECT * FROM Enseignant WHERE EnseignantID = '" + enseignantID + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Enseignant with ID '" + enseignantID + "' is found in the DB");
                Enseignant newEnseignant = new Enseignant(rs.getInt("EnseignantID"), rs.getString("Name"));
                return newEnseignant;
            } else {
                System.out.println("Enseignant with ID '" + enseignantID + "' not found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Enseignant> getAllEnseignants() {
        try {
            sql = "SELECT * FROM Enseignant";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Enseignant> listEnseignants = new ArrayList<>();
            while (rs.next()) {
                listEnseignants.add(new Enseignant(rs.getInt("EnseignantID"), rs.getString("Name")));
            }
            return listEnseignants;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

