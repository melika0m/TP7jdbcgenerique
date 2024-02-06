package impdaos;

import classesdaos.GenericDAO;
import mummypackage.dbcnx;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Enseignant;

public class GenericImpDao<T> implements GenericDAO<T> {

    private final Class<T> type;

    public GenericImpDao(Class<T> type) {
        this.type = type;
    }

    // Returns the field considered as ID (e.g., field name ending with "ID")
    private Field getIdField(Field[] fields) {
        for (Field field : fields) {
            if (field.getName().endsWith("ID") || field.getName().equalsIgnoreCase("id")) {
                return field;
            }
        }
        return null;
    }

    @Override
    public void save(T entity) {
        String sql = constructInsertSql(entity);
        try (Connection con = dbcnx.maConnexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            setStatementParameters(pst, entity);
            int rowCount = pst.executeUpdate();
            System.out.println(rowCount > 0 ? "Entity inserted successfully!" : "Insertion failed!");
        } catch (SQLException | IllegalAccessException e) {
            System.out.println("Error in insertion: " + e.getMessage());
        }
    }

    @Override
    public void remove(T entity) {
        String sql = constructDeleteSql(entity);
        try (Connection con = dbcnx.maConnexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            Field idField = getIdField(entity.getClass().getDeclaredFields());
            idField.setAccessible(true);
            pst.setObject(1, idField.get(entity));
            int rowCount = pst.executeUpdate();
            System.out.println(rowCount > 0 ? "Entity removed successfully!" : "Removal failed!");
        } catch (SQLException | IllegalAccessException e) {
            System.out.println("Error in removal: " + e.getMessage());
        }
    }

    @Override
    public void update(T entity) {
        String sql = constructUpdateSql(entity);
        try (Connection con = dbcnx.maConnexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            setStatementParameters(pst, entity);
            Field idField = getIdField(entity.getClass().getDeclaredFields());
            idField.setAccessible(true);
            pst.setObject(entity.getClass().getDeclaredFields().length + 1, idField.get(entity));

            int rowCount = pst.executeUpdate();
            System.out.println(rowCount > 0 ? "Entity updated successfully!" : "Update failed!");
        } catch (SQLException | IllegalAccessException e) {
            System.out.println("Error in update: " + e.getMessage());
        }
    }

    // Other methods (findById, findAll) remain unchanged...

    // Utility methods for constructing SQL and setting parameters
    private String constructInsertSql(T entity) {
        Class<?> clazz = entity.getClass();
        String tableName = clazz.getSimpleName();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder values = new StringBuilder("VALUES (");
        for (Field field : fields) {
            sql.append(field.getName()).append(", ");
            values.append("?, ");
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 2) + ") ");
        values = new StringBuilder(values.substring(0, values.length() - 2) + ")");
        sql.append(values);
        return sql.toString();
    }

    private String constructDeleteSql(T entity) {
        Class<?> clazz = entity.getClass();
        Field idField = getIdField(clazz.getDeclaredFields());
        idField.setAccessible(true);
        return "DELETE FROM " + clazz.getSimpleName() + " WHERE " + idField.getName() + " = ?";
    }

    private String constructUpdateSql(T entity) {
        Class<?> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sql = new StringBuilder("UPDATE " + clazz.getSimpleName() + " SET ");

        for (Field field : fields) {
            sql.append(field.getName()).append(" = ?, ");
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 2));

        Field idField = getIdField(fields);
        idField.setAccessible(true);
        sql.append(" WHERE ").append(idField.getName()).append(" = ?");
        return sql.toString();
    }

    private void setStatementParameters(PreparedStatement pst, T entity) throws IllegalAccessException, SQLException {
        int index = 1;
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            pst.setObject(index++, field.get(entity));
        }
    }

	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Enseignant> getAllEnseignants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant findEnseignant(int enseignantID) {
		// TODO Auto-generated method stub
		return null;
	}
}
