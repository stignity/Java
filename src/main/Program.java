package main;

import java.sql.SQLException;

public class Program {
	
	public static void main(String[] args) {
		try {
			
			DBHandlerBokliste dbhandler = new DBHandlerBokliste(args[0], args[1]);
			
			//dbhandler.updateTittel("Love Story", "Love story");
			dbhandler.updateForfatter("Vog Magnus", "VogM");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
