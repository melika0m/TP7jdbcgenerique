package impdaos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Note;
import classesdaos.NoteDAO;
import mummypackage.dbcnx;

public class NoteImpDao implements NoteDAO {
    
    Connection con = dbcnx.maConnexion();
    String sql;
    Statement st = null;
    
    @Override
    public void save(Note note) {
        sql = "INSERT INTO Notes (NoteID, Value, EtudiantID, MatiereID, EnseignantID) VALUES ('" + note.getNoteID() + "', '" + note.getValue() + "', '" + note.getEtudiantID() + "', '" + note.getMatiereID() + "', '" + note.getEnseignantID() + "')";
        try {
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Note inserted correctly!");
            } else {
                System.out.println("Error in insertion!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void remove(Note note) {
        try {
            sql = "DELETE FROM Notes WHERE NoteID = '" + note.getNoteID() + "'";
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Note removed correctly!");
            } else {
                System.out.println("Error in deletion!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void update(Note note) {
        try {
            sql = "UPDATE Notes SET Value = '" + note.getValue() + "', EtudiantID = '" + note.getEtudiantID() + "', MatiereID = '" + note.getMatiereID() + "', EnseignantID = '" + note.getEnseignantID() + "' WHERE NoteID = '" + note.getNoteID() + "'";
            st = con.createStatement();
            int nb = st.executeUpdate(sql);
            if (nb != 0) {
                System.out.println("Note updated correctly!");
            } else {
                System.out.println("Error in update!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public Note findNote(int noteID) {
        try {
            sql = "SELECT * FROM Notes WHERE NoteID = '" + noteID + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Note with ID '" + noteID + "' is found in the DB");
                Note newNote = new Note(rs.getInt("NoteID"), rs.getBigDecimal("Value"), rs.getInt("EtudiantID"), rs.getInt("MatiereID"), rs.getInt("EnseignantID"));
                return newNote;
            } else {
                System.out.println("Note with ID '" + noteID + "' not found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Note> getAllNotes() {
        try {
            sql = "SELECT * FROM Notes";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Note> listNotes = new ArrayList<>();
            while (rs.next()) {
                listNotes.add(new Note(rs.getInt("NoteID"), rs.getBigDecimal("Value"), rs.getInt("EtudiantID"), rs.getInt("MatiereID"), rs.getInt("EnseignantID")));
            }
            return listNotes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
