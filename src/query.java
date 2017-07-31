import java.util.*;
public class query {
	public static void main(String[] args) {
        // dont need to time Timing timer = new Timing();
		final String queryTemp = "select user_ID, record_Number, name, sex, hourly_Wage, ssn from Records where ";
		DB2JavaInterface classListing = new DB2JavaInterface("/home/codosa/ICS491/ics491_timesheet-dev/resources/database/records.csv");
		Scanner keyboard = new Scanner(System.in);
		int menuChoice;
		int[] column = new int[7];
		String[] value = new String[7];
		String searchTerm = "";
		int searchChoice = -1;
		int searchLevel = 0;
		String[] searchTerms = new String[7];
		do {
			System.out.println("Please choose a query to preform:\n"
					+ "1. Search For Class\n" + "2. Exit\n"); 
			menuChoice = keyboard.nextInt();
			switch (menuChoice) {
			case 1:
				while(searchChoice != 0){
				System.out.println("What would you like to search by?\n"
						+ "1. User ID\n" + "2. Record Number\n"
						+ "3. Name\n" + "4. Sex\n" + "5. Hourly Wage\n"
						+ "6. SSN\n");
				searchChoice = keyboard.nextInt();
				if (searchChoice == 0)
					break;
				switch (searchChoice) {
				case 1:
					column[searchLevel] = 0;
					searchTerms[searchLevel] = "user_ID";
					break;
				case 2:
					column[searchLevel] = 1;
					searchTerms[searchLevel] = "record_Number";
					break;
				case 3:
					column[searchLevel] = 2;
					searchTerms[searchLevel] = "name";
					break;
				case 4:
					column[searchLevel] = 3;
					searchTerms[searchLevel] = "sex";
					break;
				case 5:
					column[searchLevel] = 4;
					searchTerms[searchLevel] = "hourly_Wage";
					break;
				case 6:
					column[searchLevel] = 5;
					searchTerms[searchLevel] = "ssn";
					break;
				}
				System.out.print("Now please enter your search term, only exact results will return results: ");
				Scanner kb = new Scanner(System.in);
			    value[searchLevel] = kb.nextLine();
			    searchLevel++;
			    System.out.print("You may now choose to enter another search term for a more advanced search. Or enter 0 to continue.");
				}
				switch(searchLevel){
				case 1:
					System.out.println("These are the results of the following DB2 Query: \n"
							+ queryTemp + searchTerms[0] + " = '" + value[0] + "'");
					//timer.start();
					classListing.searchForMatch(column[0], value[0]);
					//timer.stop();
		            // System.out.println( timer.print("Total load time") );
					break;
				case 2:
					System.out.println("These are the results of the following DB2 Query: \n"
							+ queryTemp + searchTerms[0] + " = '" + value[0] + "' , " + searchTerms[1] + " = '" + value[1] + "'");
					//timer.start();
					classListing.searchForMatch(column[0], column[1], value[0], value[1]);
					//timer.stop();
		           // System.out.println( timer.print("Total load time") );
					break;
				case 3:
					System.out.println("These are the results of the following DB2 Query: \n"
							+ queryTemp + searchTerms[0] + " = '" + value[0] + "' , " + searchTerms[1] + " = '" + value[1] + "' , " + searchTerms[2] + " = '" + value[2] + "'");
					//timer.start();
					classListing.searchForMatch(column[0], column[1], column[2], value[0], value[1], value[2]);
					//timer.stop();
		          //  System.out.println( timer.print("Total load time") );
					break;
				}
			case 2:
				System.out.println("Thank you for querying the database");
				return;
			}
		} while (menuChoice != 2);
	}
}
