# ics491_timesheet

#### clone the git repo, then use the following commands to compile and run the code:
```
cd src/
chmod +x compile.sh
chmod +x run.sh
./compile.sh
./run.sh
```
## July 23, 2017 Report: 
Completed: 
- [x] Established a design map based on the DFD of Threat Model 
- [x] Developed code that established a skeleton the user interface 
- [x] Established a preliminary directory structure for further code development 
- [x] Created sample database directory and files 

Pending: 
- [ ] UserInterface - Validate user input to ensure they are restricted to available options
- [ ] Implement record management handler class
- [ ] Implement database handler class
- [ ] Implement punch clock class
- [ ] Implement login/authentication system
- [ ] Enable Java Security Manager ?
- [ ] ~~Integrate web server functionality~~ **_backlogged_** , *we may be unable to integrate web server functionality due to time constraints*

What each team member worked on: 
- **Marco**, @marcodlk - set up the repo, wrote all code in the repo at the moment, aside from database related code; discussed login/authentication system and database handling implementation with Collon 
- **Collon**, @codosa - established database queries to be used; added database related code; researched login/authentication system ideas and relayed them to Marco; discussed important issues in the secure design of database handling implementation 

## July 30, 2017 Report: 
Completed: 
- [x] UserInterface - Validate user input to ensure they are restricted to available options
- [x] Implement login/authentication system
- [x] Implement database handler class

Pending: 
- [ ] Implement record management handler class
- [ ] Implement punch clock class
- [ ] Enable Java Security Manager ?

Revisions:
- We will not have time to set up a DB2 database so are settling for implementing around a local csv database. We realize that this is a huge security risk and would never do this for the actual final product. However, due to time constraints and limited workforce, we want to focus on getting the functionality running and ensuring that privilege boundaries are enforced correctly in our application.

What each team member worked on: 
- **Marco**, @marcodlk - further developed the user interface; performed preliminary implementation of database handler, although some of the database handler's functionality was later decided to be split among other classes - may become deprecated; implemented password and username validation; attempted to fuzz test the program (difficult against Java); discussed state of project and revision requirements
- **Collon**, @codosa - implemented the verification of password input through hash comparison; refactored database interface functions to be used by login manager; researched dynamic analysis tool; discussed state of project and revision requirements

#### Repo:
https://github.com/marcodlk/ics491_timesheet
