package ui;

//local
import token.Token;
//java
import java.util.Scanner;
import java.util.NoSuchElementException;


/*
 * UserInterface class
 */
public class UserInterface implements Runnable {

	/* variables */
	private Token token;

	/* constructor */
	public UserInterface(Token loginToken) {
		this.token = loginToken;
	}

	/* methods */
	public void displayMainMenu() {
		// TODO: display only functions respective to token.privilegeLevel
	}

	private void displayGreetingSign() {
		System.out.println("");
		System.out.println("xxxxxx xx xx   xx xxxxxx xxxxxx xx  xx xxxxxx xxxxxx xxxxxx");
		System.out.println("  xx   xx xxx xxx xxxx   xxx    xxxxxx xxxx   xxxx     xx  ");
		System.out.println("  xx   xx xxxxxxx xx       xxx	xx  xx xx     xx       xx  ");
		System.out.println("  xx   xx xx x xx xxxxxx xxxxxx xx  xx xxxxxx xxxxxx   xx  ");
		System.out.println("");
	}

	private void displayGreetingMessage() {
		System.out.println("");
		System.out.println("+----------------------------------------------------------");
		System.out.println("| Welcome! You are logged in as " + token.getUsername());
		System.out.println("+----------------------------------------------------------");
		System.out.println("| You are an " + ((token.getPrivilegeLevel() == 1) ? "admin" : "employee"));
		System.out.println("+----------------------------------------------------------");
		System.out.println("");
	}

	private void displayPunchClockMenu() {
		System.out.println("Here you can check-in and check-out !");
	}

	private void displayAdminOptions() {
		System.out.println("+---+------------------------------------------------------");
		System.out.println("|	    ADMINISTRATOR MENU                                   ");
		System.out.println("+---+------------------------------------------------------");
		System.out.println("|     Select one of the following options:                 ");
		System.out.println("+---+------------------------------------------------------");
		System.out.println("| 1 | Record Management                                    ");
		System.out.println("+---+------------------------------------------------------");
		System.out.println("| 2 | Timesheet Information                                ");
		System.out.println("+---+------------------------------------------------------");
		System.out.println("| 0 | Quit                                                 ");
		System.out.println("+---+------------------------------------------------------");
	}

	private void displayEmployeeOptions() {
		System.out.println("+---+------------------------------------------------------");
		System.out.println("|	    EMPLOYEE MENU                                        ");
		System.out.println("+---+------------------------------------------------------");
		System.out.println("|     Select one of the following options:                 ");
		System.out.println("+---+------------------------------------------------------");
		System.out.println("| 1 | Punch Clock                                          ");
		System.out.println("+---+------------------------------------------------------");
		System.out.println("| 2 | Timesheet Information                                ");
		System.out.println("+---+------------------------------------------------------");
		System.out.println("| 0 | Quit                                                 ");
		System.out.println("+---+------------------------------------------------------");
	}

	private void displayInfoMenu(int mode) {
		System.out.print("Here you can request timesheet info");
		if (mode == 0) {
			System.out.print("... but ONLY about yourself");
		}
		else if (mode == 1) {
			System.out.print("... about EVERYONE");
		}
		System.out.println(" !");
	}

	private void displayRecordsMenu() {
		System.out.println("Here you can manage records !");
	}

	public void runAsAdmin() {
		//display
		displayAdminOptions();

		//set up
		Scanner reader = new Scanner(System.in);
		String buffer;
  	boolean running = true;

		//run
  	while (running) {
    	System.out.print("> ");
    	try {
      	buffer = reader.nextLine();
    	} catch (NoSuchElementException e) {
      	System.out.println("");
      	break;
    	}
    	buffer = buffer.trim();
			
			switch (buffer) { // TODO: avoid using string... more vulnerable?
				case "1":
					displayRecordsMenu();
					break;
				case "2":
					displayInfoMenu(1);
					break;
				case "0": //quit
					running = false;
					break;
				default:
					System.out.println("Unrecognized command");
			}
		}
	}

	public void runAsEmployee() {
		//display
		displayEmployeeOptions();

		//setup
		Scanner reader = new Scanner(System.in);
		String buffer;
  	boolean running = true;

		//run
  	while (running) {
    	System.out.print("> ");
    	try {
      	buffer = reader.nextLine();
    	} catch (NoSuchElementException e) {
      	System.out.println("");
      	break;
    	}
    	buffer = buffer.trim();
			
			switch (buffer) { // TODO: avoid using string... more vulnerable?
				case "1":
					displayPunchClockMenu();
					break;
				case "2":
					displayInfoMenu(0);
					break;
				case "0": //quit
					running = false;
					break;
				default:
					System.out.println("Unrecognized command");
			}
		}
	}

	public void run () {
		//display
		displayGreetingSign();
		displayGreetingMessage();

		//run in mode respective to privilege level
		if (token.getPrivilegeLevel() == 1) {
			runAsAdmin();
		}
		else if (token.getPrivilegeLevel() == 0) {
			runAsEmployee();
		}
		else {
			System.err.println("Timesheet: Unrecognized privilege level");
		}
	}
}