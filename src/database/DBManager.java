package database;

import java.util.*;

public class DBManager {

	/* class variables */
	private String DBRoot;
	DB2JavaInterface recordsKeeper; 
	DB2JavaInterface timesheetKeeper;
	DB2JavaInterface usersKeeper;
	
	/* constructors */
	public DBManager(String databaseDirectory) {
		DBRoot = databaseDirectory;
		recordsKeeper = new DB2JavaInterface(DBRoot + "/records.csv");
		timesheetKeeper = new DB2JavaInterface(DBRoot + "/timesheet.csv");
		usersKeeper = new DB2JavaInterface(DBRoot + "/users.csv");
	}

	public ArrayList<String> getRecordByID(int id) {
		ArrayList<String> row = new ArrayList<String>();
		//recordsKeeper.searchForMatch(0,Integer.toString(id));
		return row;
	}

	public ArrayList<String> getUserByID(int id) {
		ArrayList<String> row = new ArrayList<String>();
		//usersKeeper.searchForMatch(0,Integer.toString(id));
		return row;
	}

	public ArrayList<ArrayList<String>> getTimesheetByID(int id) {
		ArrayList<String> row = new ArrayList<String>();
		ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
		//timesheetKeeper.searchForMatch(0,Integer.toString(id));
		return rows;
	}

} // DBManager
