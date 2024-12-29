package cp213;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class Cipher {
    // Constants
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();

    /**
     * Encipher a string using a shift cipher. Each letter is replaced by a letter
     * 'n' letters to the right of the original. Thus for example, all shift values
     * evenly divisible by 26 (the length of the English alphabet) replace a letter
     * with itself. Non-letters are left unchanged.
     *
     * @param s string to encipher
     * @param n the number of letters to shift
     * @return the enciphered string in all upper-case
     */
    public static String shift(final String s, final int n) {

	// your code here
	String result = "";
	int shift = n % 26;
	for (int i = 0; i < s.length(); i++) {
	    char index = s.charAt(i);
	    if (Character.isLetter(index)) {
		char upperChar = Character.toUpperCase(index);
		int currentIndex = ALPHA.indexOf(upperChar);
		int newIndex = (currentIndex + shift) % ALPHA_LENGTH;
		result += ALPHA.charAt(newIndex);

	    } else {
		result += index;
	    }
	}

	return result;
    }

    /**
     * Encipher a string using the letter positions in ciphertext. Each letter is
     * replaced by the letter in the same ordinal position in the ciphertext.
     * Non-letters are left unchanged. Ex:
     *
     * <pre>
    Alphabet:   ABCDEFGHIJKLMNOPQRSTUVWXYZ
    Ciphertext: AVIBROWNZCEFGHJKLMPQSTUXYD
     * </pre>
     *
     * A is replaced by A, B by V, C by I, D by B, E by R, and so on. Non-letters
     * are ignored.
     *
     * @param s          string to encipher
     * @param ciphertext ciphertext alphabet
     * @return the enciphered string in all upper-case
     */
    public static String substitute(final String s, final String ciphertext) {

	// your code here
	String result = "";
	if (ciphertext.length() == ALPHA_LENGTH) {
	    boolean validCiphertext = true;

	    for (int i = 0; i < ciphertext.length(); i++) {
		char currentChar = ciphertext.charAt(i);
		if (!Character.isLetter(currentChar)) {
		    validCiphertext = false;
		    break;
		}
		for (int j = i + 1; j < ciphertext.length(); j++) {
		    if (currentChar == ciphertext.charAt(j)) {
			validCiphertext = false;
			break;
		    }
		}

	    }
	    if (validCiphertext) {
		for (int i = 0; i < s.length(); i++) {
		    char c = s.charAt(i);

		    if (Character.isLetter(c)) {
			char upperChar = Character.toUpperCase(c);
			int currentIndex = ALPHA.indexOf(upperChar);
			result += ciphertext.charAt(currentIndex);

		    } else {
			result += c;
		    }

		}
	    }
	}

	return result;
    }

}
