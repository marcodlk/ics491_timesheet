# It is possible to run Checkstyle directly from the JAR file using the -jar option. An example of run would be:

java -jar checkstyle-8.0-all.jar -c /sun_checks.xml MyClass.java
java -jar checkstyle-8.0-all.jar -c /google_checks.xml MyClass.java

# To run Checkstyle UI viewer for AST tree directly from the JAR file using the -jar option. An example of run would be (path to java file is optional):

java -cp checkstyle-8.0-all.jar com.puppycrawl.tools.checkstyle.gui.Main MyClass.java

# Taken from http://checkstyle.sourceforge.net/cmdline.html
