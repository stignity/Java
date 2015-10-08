package main;

import java.sql.SQLException;

public class Program {
	
	public static void main(String[] args) {
		try {
			
			DBHandlerBokliste dbhandler = new DBHandlerBokliste(args[0], args[1]);
			
			//System.out.println(dbhandler.updateTittel("Love Story", "Love kake"));
			//System.out.println(dbhandler.updateForfatter("Vog Magnus", "VogM") + " row(s) affected!");
			//System.out.println(dbhandler.deleteForfatter("Valmirrr Memeti") + " row(s) affected!");
			//System.out.println(dbhandler.deleteTittel("tittel") + " row(s) affected!");
			//System.out.println(dbhandler.insertRow("isbn", "forfatter", "tittel") + " row(s) affected!");
			
			dbhandler.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
