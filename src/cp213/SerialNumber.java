package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {
	boolean verify = true;
	// your code here
	if (str.isEmpty()) {
	    verify = false;
	} else {
	    for (int i = 0; i < str.length(); i++) {
		if (!Character.isDigit(str.charAt(i))) {
		    verify = false;
		    break;
		}
	    }

	}

	return verify;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param serial_number The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String serial_number) {
	boolean valid = true;

	if (serial_number.length() != 11) {
	    valid = false;
	}
	if (valid) {

	    if (!Character.isUpperCase(serial_number.charAt(0)) || !Character.isUpperCase(serial_number.charAt(1))) {
		valid = false;
	    }
	    if (serial_number.charAt(2) != '/') {
		valid = false;
	    }
	    if (serial_number.charAt(7) != '-') {
		valid = false;
	    }
	    for (int i = 3; i < 7; i++) {
		if (!Character.isDigit(serial_number.charAt(i))) {
		    valid = false;
		    break;
		}
	    }
	    for (int i = 8; i < 11; i++) {
		if (!Character.isDigit(serial_number.charAt(i))) {
		    valid = false;
		    break;
		}
	    }

	}

	return valid;

    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns. Each line of fileIn contains
     * a (possibly valid) serial number.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

	while (fileIn.hasNextLine()) {
	    String serialNum = fileIn.nextLine().trim();
	    if (validSn(serialNum)) {
		goodSns.println(serialNum);
	    } else {
		badSns.println(serialNum);
	    }

	}

	return;
    }

}
