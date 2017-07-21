package ui;
import token.Token;

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

	private void displaySessionMenu() {
		System.out.println("Here you can check-in and check-out !");
	}

	private void displayInfoMenu() {
		System.out.println("Here you can request timesheet info !");
	}

	private void displayRecordsMenu() {
		System.out.println("Here you can manage records !");
	}

	public void run () {
		displaySessionMenu();
		displayInfoMenu();
		displayRecordsMenu();
	}
}
