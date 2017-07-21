package token;

/*
 * Token class.
 */
public class Token {

	/* variables */
  private String username;
  private int id;
	private int privilegeLevel;

	/* constructor */
	public Token(String username, int id, int privilegeLevel) {
		this.username = username;
		this.id = id;
		this.privilegeLevel = privilegeLevel;
	}

	/* accessor methods */
	public String getUsername() {
		return username;
	}
	public int getId() {
		return id;
	}
	public int getPrivilegeLevel() {
		return privilegeLevel;
	}

} // Token
