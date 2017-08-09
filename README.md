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

## August 6, 2017 Report:
Completed: 
- [x] Implement punch clock function and user interface
- [x] Automate database handler to use current working directory of project
- [x] Add mock functionality and display MySQL statements to guide future development
- [x] Update database schema

Pending: 
- [ ] Connect punch clock to database
- [ ] Implement Timesheet Inspector/Information class and user interface
- [ ] Implement record manangement handler class
- [ ] Enable Java Security Manager ?
- [ ] **MySQL driver integration**
- [ ] **Web Server integration** 

What each team member worked on: 
- **Marco**, @marcodlk - further developed the user interface; implemented punch clock; performed dynamic analysis on the program; code review
- **Collon**, @codosa - determined necessary mysql statements and added them to user interface appropriately; implemented automation based on working directory; performed dynamic analysis on the program; code review

## Closing thoughts:
Due to time constraints of the brief summer session as well as a limited personnel of 2, we had to give up some key goals we set up for our program at the beginning of the project.
Moving forward, we would have proceeded to integrate a connection with a real database and hosted the program as a service on the web. This would have increased our attack surface exponentially but thanks to the lessons in ICS491, we are confident that we would have done a solid job securing our server application. 
For the time being, we focused on implementing a secure login mechanism. However, that also is not completed to our expectations. We were not able to finalize the discussion on how the salting and sensitive information would be distributed in the database/program in order to be efficiently secure.
A lot of our troubles with the database originated from miscommunication in the beginning weeks and was exarcebated by some team members' inability to get the mysql driver working in their own machine.
Given some extra time (or manpower), we are sure we would have resolved these issues and produced a timesheet web server program that allowed for administrators to upload and modify employee accounts, as well as have a powerful timesheet analysis tool to get information of interest on respective employees. Employees would have a simple punch clock application to use to record their sessions (with proper implementation to ensure the integrity of their session) and would be limited to viewing their own timesheet information.

#### Repo:
https://github.com/marcodlk/ics491_timesheet
#### Wiki:
https://github.com/marcodlk/ics491_timesheet/wiki
