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

	private final String globalSalt = "123456789"; //TODO should NOT be hardcoded
	private static DB2JavaInterface classListing; 


	
	
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

		return new Token(username,1,0);
	}

	private static boolean validateUsername(String username) {
		classListing = new DB2JavaInterface("/home/codosa/ICS491/ics491_timesheet-dev/resources/database/users.csv");
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
		//Verify the username exists in the database.
		if(classListing.searchForMatch(0,username)) {
			return true;
		}
		return false;	
	}

	private static boolean validatePassword(String username, String password) throws RuntimeException{
		
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
		/* this should be in its own functions for authenticating password */
		
		//dbPass is the password from the database			
		String dbPass = classListing.searchForPassword(0, username);
		String tempPass = "";
		
		// this converts string using MD5 hash
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(password.getBytes());
		BigInteger number = new BigInteger(1, messageDigest);
		String hashtext = number.toString(16);
		tempPass = hashtext;
		} catch (Exception nSA ) {}
		// if passwords match, we have authentication
		if ( tempPass.equals(dbPass) ) {
			return true;
		}
		/* end of authentication */
		return false;
	}

	private static int countOccurrences(String string, String regex) {
		if (string == null || string.isEmpty()) {
			throw new RuntimeException("countRegexOccurrencesIn: Unable to evaluate empty string");
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
