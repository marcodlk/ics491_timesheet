package security;

import java.lang.RuntimeException;
import java.lang.Exception;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.math.*;
//local
import token.Token;
import database.DB2JavaInterface;

/*
 * Login Manager class.
 */
public final class LoginManager {

	//private final String globalSalt = "123456789"; //TODO should NOT be hardcoded
	//private static DB2JavaInterface database; 

	
	public static Token authenticate(String username, String password) {
		if (!validateUsername(username)) {
			return new Token("",-1,-1);
		}
		if (!validatePassword(username, password)) {
			return new Token("",-1,-1);
		}

		/* --pseudocode
		globalSalt = getGlobalSalt() 
		userSalt = DatabaseManager.request(users,username,userSalt)
		passHash = getHash(password + globalSalt + UserSalt);
		
		row = DatabaseManager.request(users,username,passHash);
		if (row.isEmpty()) {
			return -1;
		} else {
			Token token = new Token(username, row.id, row.privilegeLevel);
			return token;
		}
		*/

		String[] authTuple = verifyCredentials(username,password);
		if (authTuple == null) {
			return new Token("",-1,-1);
		}
		
		return new Token(username,
										 Integer.parseInt(authTuple[0]),
										 Integer.parseInt(authTuple[1]));
	}

	private static String[] verifyCredentials(String username, String password) {
		DB2JavaInterface usersDatabase = new DB2JavaInterface(System.getProperty("user.dir")+"/../resources/database/users.csv");
		//DB2JavaInterface database = new DB2JavaInterface("/home/codosa/ICS491/ics491_timesheet-dev/resources/database/users.csv");
		//DB2JavaInterface usersDatabase = new DB2JavaInterface("/Users/Marco/Documents/School/17/Summer/ICS491/timesheet/resources/database/users.csv");
		if(!usersDatabase.exists(1,username)) {
			return null;
		}

		//storedHash is the password from the database			
		String storedHash = usersDatabase.searchForPassword(1, username);
		String inputHash = "";
		
		// this converts string using MD5 hash
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(password.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			inputHash = number.toString(16);
		} catch (Exception nSA ) {}
		// if hashes are equal, we have successful authentication
		//System.out.println("stored: " + storedHash + " input: " + inputHash);
		if (!inputHash.equals(storedHash)) {
			return null;
		}
		String[] authTuple = new String[2];
		authTuple[0] = usersDatabase.getColumnForRowMatching(0,1,username);
		authTuple[1] = usersDatabase.getColumnForRowMatching(3,1,username);

		return authTuple;
	}

	private static boolean validateUsername(String username) {
		/* requirements:
			 - minimum length = 1 
			 - maximum length = 15
			 - cannot contain spaces
		 */
		if (username.length() < 1) {
			return false;
		} 
		if (username.length() > 15) {
			return false;
		}
		if (containsSpaceCharacters(username)) {
			return false;
		}
		return true;	
	}

	private static boolean validatePassword(String username, String password) throws RuntimeException {
		/* requirements:
			 - minimum length = 8 
			 - maximum length = 30
			 - at least one special character
		   - at least one digit
		 */
		if (password.length() < 8) {
			return false;
		} 
		if (password.length() > 30) {
			return false;
		}
		if (countSpecialCharactersIn(password) <= 0) {
			return false;
		}
		if (countDigitsIn(password) <= 0) {
			return false;
		}
		return true;
	}

	private static int countOccurrences(String string, String regex) {
		if (string == null || string.isEmpty()) {
			throw new RuntimeException("countOccurrences: Unable to evaluate empty string");
		}
		Pattern pattern = Pattern.compile(regex);	
		Matcher matcher = pattern.matcher(string);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		assert (count <= string.length());

		return count;
	}
	
	private static int countSpecialCharactersIn(String string) {
		return countOccurrences(string, "[^A-Za-z0-9]");	
	}
	
	private static int countDigitsIn(String string) {
		return countOccurrences(string, "[0-9]");	
	}

	private static boolean containsSpaceCharacters(String string) {
		int numberOfSpaces = string.length() - string.replaceAll(" ","").length();
		if (numberOfSpaces > 0) {
			return true;
		} else {
			return false;
		}
	}

} // LoginManager
