package database;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class DB2JavaInterface {
	private String loadedFileName;

	private FileReader myFileReader;
	private BufferedReader myBuffReader;
	private DataOutputStream myOutput;
	private DataInputStream myInput;
	private final String BINARYFILE = "data.bin";

	/**
	 * The character that is assumed to separate values in lines of files read
	 * by this class.
	 */
	private final String SEPARATOR = "\\,";
	private final char ENDOFROW = '\n';
	public DB2JavaInterface(String fileName) {
		loadedFileName = fileName;
		csvLoad(fileName);
	}
	/**
	 * load takes a fileName as an argument and reads in the CSV file at the
	 * given path. The data may not all fit in memory.
	 * 
	 * @param fileName
	 *            The name of the file to be loaded.
	 */
	public void csvLoad(String fileName) {

		loadedFileName = fileName;
		try {
			myFileReader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.err.println(loadedFileName + " was not found.");
		}
	}
	public void searchForMatch(int columnNumber, String value) {
		System.err.println("SEARCHING . . . " + value + " in column " + columnNumber);
		String rowValue; // stores the row string from the buffered readers
							// readLine()
		try {// loads the file to perform search
			myFileReader = new FileReader(this.loadedFileName);
		} catch (FileNotFoundException e) {
			System.err.println(loadedFileName + " was not found.");
		}
		myBuffReader = new BufferedReader(myFileReader);
		try {
			while ((rowValue = myBuffReader.readLine()) != null) {
				String[] row = rowValue.toString().split(SEPARATOR); // each
				// index
				// represents
				// a
				// column
				if (row[columnNumber].equals(value)) {
					rowValue = rowValue.replaceAll("\"","\\\"");
					System.out.println(rowValue);
					rowValue = "";
				} else {
					rowValue = "";
				}
				myBuffReader.readLine();
			}
		} catch (IOException e) {
			System.err.println("Try and catch this, jerk.");
		}
		try {
			myBuffReader.close();
		} catch (IOException e) {
			System.err.println("The file did not close properly.");
		}
	}

public void searchForMatch(int columnNumber, int columnNumber2, String value, String value2) {
	String rowValue; // stores the row string from the buffered readers
						// readLine()
	try {// loads the file to perform search
		myFileReader = new FileReader(this.loadedFileName);
	} catch (FileNotFoundException e) {
		System.err.println(loadedFileName + " was not found.");
	}
	myBuffReader = new BufferedReader(myFileReader);
	try {
		while ((rowValue = myBuffReader.readLine()) != null) {
			String[] row = rowValue.toString().split(SEPARATOR); // each
			// index
			// represents
			// a
			// column
			if (row[columnNumber].equals(value) && row[columnNumber2].equals(value2)) {
				rowValue = rowValue.replaceAll("\"","\\\"");
				System.out.println(rowValue);
				rowValue = "";
			} else {
				rowValue = "";
			}
			myBuffReader.readLine();
		}
	} catch (IOException e) {
		System.err.println("Try and catch this, jerk.");
	}
	try {
		myBuffReader.close();
	} catch (IOException e) {
		System.err.println("The file did not close properly.");
	}
}
public void searchForMatch(int columnNumber, int columnNumber2, int columnNumber3, String value, String value2, String value3) {
	String rowValue; // stores the row string from the buffered readers
						// readLine()
	try {// loads the file to perform search
		myFileReader = new FileReader(this.loadedFileName);
	} catch (FileNotFoundException e) {
		System.err.println(loadedFileName + " was not found.");
	}
	myBuffReader = new BufferedReader(myFileReader);
	try {
		while ((rowValue = myBuffReader.readLine()) != null) {
			String[] row = rowValue.toString().split(SEPARATOR); // each
			// index
			// represents
			// a
			// column
			if (row[columnNumber].equals(value) && row[columnNumber2].equals(value2) && row[columnNumber3].equals(value3)) {
				rowValue = rowValue.replaceAll("\"","\\\"");
				System.out.println(rowValue);
				rowValue = "";
			} else {
				rowValue = "";
			}
			myBuffReader.readLine();
		}
	} catch (IOException e) {
		System.err.println("Try and catch this, jerk.");
	}
	try {
		myBuffReader.close();
	} catch (IOException e) {
		System.err.println("The file did not close properly.");
	}
}
}
