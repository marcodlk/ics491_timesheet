# check source Java files

echo "CHECKING TIMESHEET.JAVA================================================="
java -jar checkstyle-8.0-all.jar -c /google_checks.xml ../src/main/Timesheet.java
echo "CHECKING TOKEN.JAVA====================================================="
java -jar checkstyle-8.0-all.jar -c /google_checks.xml ../src/token/Token.java
echo "CHECKING USERINTERFACE.JAVA============================================="
java -jar checkstyle-8.0-all.jar -c /google_checks.xml ../src/ui/UserInterface.java
