package impdaos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Filiere;
import classes.Matiere;
import classesdaos.FiliereDAO;
import mummypackage.dbcnx;

public class FiliereImpDao implements FiliereDAO {
    
    Connection con = dbcnx.maConnexion();
    String sql;
    Statement st = null;
    
    @Override
    public void save(Filiere filiere) {
        sql = "INSERT INTO Filiere (FiliereID, Name) VALUES ('" + filiere.getFiliereID() + "', '" + filiere.getName() + "')";
        try {
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Filiere inserted correctly!");
            } else {
                System.out.println("Error in insertion!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void remove(Filiere filiere) {
        try {
            sql = "DELETE FROM Filiere WHERE FiliereID = '" + filiere.getFiliereID() + "'";
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Filiere removed correctly!");
            } else {
                System.out.println("Error in deletion!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void update(Filiere filiere) {
        try {
            sql = "UPDATE Filiere SET Name = '" + filiere.getName() + "' WHERE FiliereID = '" + filiere.getFiliereID() + "'";
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Filiere updated correctly!");
            } else {
                System.out.println("Error in update!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public Filiere findFiliere(int filiereID) {
        try {
            sql = "SELECT * FROM Filiere WHERE FiliereID = '" + filiereID + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Filiere with ID '" + filiereID + "' is found in the DB");
                Filiere newFiliere = new Filiere(rs.getInt(1), rs.getString(2));
                return newFiliere;
            } else {
                System.out.println("Filiere with ID '" + filiereID + "' not found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Filiere> getAllFilieres() {
        try {
            sql = "SELECT * FROM Filiere";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Filiere> listFilieres = new ArrayList<>();
            while (rs.next()) {
                listFilieres.add(new Filiere(rs.getInt("FiliereID"), rs.getString("Name")));
            }
            return listFilieres;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getNbEtudiant(int filiereID) {
        int count = 0;
        try {
            sql = "SELECT COUNT(*) AS count FROM Etudiant WHERE FiliereID = '" + filiereID + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Matiere> getMatiere(int filiereID) {
        List<Matiere> matieres = new ArrayList<>();
        try {
            sql = "SELECT * FROM Matiere WHERE FiliereID = '" + filiereID + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                matieres.add(new Matiere(rs.getInt("MatiereID"), rs.getString("Name"), rs.getInt("FiliereID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matieres;
    }

	@Override
	public List<Matiere> getMatiere() {
		// TODO Auto-generated method stub
		return null;
	}
}

