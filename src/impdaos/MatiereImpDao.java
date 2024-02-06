package impdaos;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Matiere;
import classesdaos.MatiereDAO;
import mummypackage.dbcnx;

public class MatiereImpDao implements MatiereDAO {
    
    Connection con = dbcnx.maConnexion();
    String sql;
    Statement st = null;
    
    @Override
    public void save(Matiere matiere) {
        sql = "INSERT INTO Matiere (MatiereID, Name, FiliereID) VALUES ('" + matiere.getMatiereID() + "', '" + matiere.getName() + "', '" + matiere.getFiliereID() + "')";
        try {
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Matiere inserted correctly!");
            } else {
                System.out.println("Error in insertion!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void remove(Matiere matiere) {
        try {
            sql = "DELETE FROM Matiere WHERE MatiereID = '" + matiere.getMatiereID() + "'";
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Matiere removed correctly!");
            } else {
                System.out.println("Error in deletion!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void update(Matiere matiere) {
        try {
            sql = "UPDATE Matiere SET Name = '" + matiere.getName() + "', FiliereID = '" + matiere.getFiliereID() + "' WHERE MatiereID = '" + matiere.getMatiereID() + "'";
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Matiere updated correctly!");
            } else {
                System.out.println("Error in update!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public Matiere findMatiere(int matiereID) {
        try {
            sql = "SELECT * FROM Matiere WHERE MatiereID = '" + matiereID + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Matiere with ID '" + matiereID + "' is found in the DB");
                Matiere newMatiere = new Matiere(rs.getInt("MatiereID"), rs.getString("Name"), rs.getInt("FiliereID"));
                return newMatiere;
            } else {
                System.out.println("Matiere with ID '" + matiereID + "' not found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Matiere> getAllMatieres() {
        try {
            sql = "SELECT * FROM Matiere";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Matiere> listMatieres = new ArrayList<>();
            while (rs.next()) {
                listMatieres.add(new Matiere(rs.getInt("MatiereID"), rs.getString("Name"), rs.getInt("FiliereID")));
            }
            return listMatieres;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public int getNbMauvaise(int matiereID) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}

