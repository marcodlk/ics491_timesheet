package main;

import token.Token;
import ui.UserInterface;

/*
 * The Timesheet class with main function.
 */
public class Timesheet {

  public static void main(String[] args) {
    Token token = new Token("Admin",0,1);
    UserInterface ui = new UserInterface(token);
    ui.run();
  }
}
