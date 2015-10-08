 package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sql.ConnectToDB;

public class DBHandlerBokliste {
	
	private ConnectToDB db;
	private Connection con;
	
	private String tableName = "bokliste";
	
	private PreparedStatement prepstmtUpdateTittel;
	private PreparedStatement prepstmtUpdateForfatter;
	private PreparedStatement prepstmtDeleteForfatter;
	private PreparedStatement prepstmtDeleteTittel;
	private PreparedStatement prepstmtInsertRow;
	//private PreparedStatement prepstmtGetTable;
	//private PreparedStatement prepstmtGetRow;
	
	private Statement stmt;
	private ResultSet rs;
	
	public DBHandlerBokliste(String username, String password) throws SQLException {
		db = new ConnectToDB("mysql.nith.no", "test", username, password);
		con = db.getConnection();
	}

	public int updateTittel(String nyTittel, String tittel) throws SQLException {
		prepstmtUpdateTittel = con.prepareStatement(
				"UPDATE " + tableName + " " +
				"SET tittel = ? " +
				"WHERE tittel = ?");
		
		prepstmtUpdateTittel.setString(1, nyTittel);
		prepstmtUpdateTittel.setString(2, tittel);
		
		if(prepstmtUpdateTittel != null) {
			int rowsAffected = prepstmtUpdateTittel.executeUpdate();
			return rowsAffected;
		}
		else {
			return 0;
		}
		
	}
	
	public int updateForfatter(String nyForfatter, String forfatter) throws SQLException {
		prepstmtUpdateForfatter = con.prepareStatement(
				"UPDATE " + tableName + " " + 
				"SET forfatter = ? " +
				"WHERE forfatter = ?");
		
		prepstmtUpdateForfatter.setString(1, nyForfatter);
		prepstmtUpdateForfatter.setString(2, forfatter);
		
		if(prepstmtUpdateForfatter != null) {
			int rowsAffected = prepstmtUpdateForfatter.executeUpdate();
			return rowsAffected;
		}
		else {
			return 0;
		}
	}
	
	public int deleteForfatter(String forfatter) throws SQLException {
		prepstmtDeleteForfatter = con.prepareStatement(
				"DELETE FROM " + tableName + " " +
				"WHERE forfatter = ?");
		
		prepstmtDeleteForfatter.setString(1, forfatter);
		
		if(prepstmtDeleteForfatter != null) {
			int rowsAffected = prepstmtDeleteForfatter.executeUpdate();
			return rowsAffected;
		}
		else {
			return 0; 
		}
		
	}
	
	public int deleteTittel(String tittel) throws SQLException {
		prepstmtDeleteTittel = con.prepareStatement(
				"DELETE FROM " + tableName + " " +
				"WHERE tittel = ?");
		
		prepstmtDeleteForfatter.setString(1, tittel);
		
		if(prepstmtDeleteForfatter != null) {
			int rowsAffected = prepstmtDeleteTittel.executeUpdate();
			return rowsAffected;
		}
		else {
			return 0;
		}
	}
	
	public int insertRow(String isbn, String forfatter, String tittel) throws SQLException {
		prepstmtInsertRow = con.prepareStatement(
				"INSERT INTO " + tableName + " " +
				"VALUES(?, ?, ?)");
		
		prepstmtInsertRow.setString(1, isbn);
		prepstmtInsertRow.setString(2, forfatter);
		prepstmtInsertRow.setString(3, tittel);
		
		if(prepstmtInsertRow != null) {
			int rowsAffected = prepstmtInsertRow.executeUpdate();
			return rowsAffected;
		}
		else {
			return 0;
		}
	}

	//Need to make this pretty!!! It's very ugly :(
	public ArrayList<String> getTable() throws SQLException {
		
		ArrayList<String> table = new ArrayList<String>();
		
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM " + tableName);
		
		while(rs.next()) {
			table.add(rs.getString("isbn"));
			table.add(rs.getString("forfatter"));
			table.add(rs.getString("tittel"));
			table.add("\n");
		}
		
		return table;
		
	}

	public String getRow(String forfatter, String tittel) throws SQLException {
		stmt = con.createStatement();
		rs = stmt.executeQuery(
				"SELECT " + forfatter + ", " + tittel + "FROM " + tableName);
		
		String result = "";
		
		while(rs.next()) {
			result = rs.getString("isbn") + " " + rs.getString("forfatter");
		}
		
		return result;
		
	}
	
	public void close() throws SQLException {
		db.close();
	}

}
