 package main;

import java.sql.*;

import sql.ConnectToDB;

public class DBHandlerBokliste {
	
	private ConnectToDB db;
	private Connection con;
	
	private String tableName = "bokliste";
	
	private PreparedStatement prepstmtUpdateTittel;
	private PreparedStatement prepstmtUpdateForfatter;
	private PreparedStatement prepstmtDeleteForfatter;
	private PreparedStatement prepstmtDeleteTittel;
	private PreparedStatement prepstmtInserRow;
	private PreparedStatement prepstmtGetTable;
	private PreparedStatement prepstmtGetRow;
	
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
	
	public void close() throws SQLException {
		db.close();
	}

}
