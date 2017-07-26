package security;

import java.lang.RuntimeException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//local
import token.Token;

/*
 * Login Manager class.
 */
public final class LoginManager {

	private final String globalSalt = "123456789"; //TODO should NOT be hardcoded
	
	public static Token authenticate(String username, String password) {
		if (!validateUsername(username)) {
			return new Token("",-1,-1);
		}
		if (!validatePassword(password)) {
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

	private static boolean validatePassword(String password) throws RuntimeException{
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
