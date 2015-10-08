package main;

import java.sql.SQLException;

public class Program {
	
	public static void main(String[] args) {
		try {
			
			DBHandlerBokliste dbhandler = new DBHandlerBokliste(args[0], args[1]);
			
			System.out.println(dbhandler.updateTittel("Love Story", "Love kake"));
			//dbhandler.updateForfatter("Vog Magnus", "VogM");
			
			dbhandler.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
