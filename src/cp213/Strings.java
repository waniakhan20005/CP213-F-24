package cp213;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {
	String cleanString = "";
	String reverse = "";
	boolean palindrome = false;

	if (string != null && !string.isEmpty()) {
	    for (int i = 0; i < string.length(); i++) {
		char c = string.charAt(i);
		if (Character.isLetter(c)) {
		    cleanString += Character.toLowerCase(c);
		}
	    }

	}
	for (int i = cleanString.length() - 1; i >= 0; i--) {
	    reverse += cleanString.charAt(i);
	}

	// Checks if their equal
	if (cleanString.equals(reverse)) {
	    palindrome = true;
	}
	return palindrome;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {

	boolean valid = true;
	if (name == null || name.isEmpty()) {
	    valid = false;
	} else if (name.equals("_")) {
	    valid = false;
	} else {
	    char firstCharacter = name.charAt(0);
	    if (!Character.isLetter(firstCharacter) && firstCharacter != '_') {
		valid = false;
	    } else {
		for (int i = 1; i < name.length(); i++) {
		    char c = name.charAt(i);
		    if (!Character.isLetter(c) && !Character.isDigit(c) && c != '_') {
			valid = false;
			break;
		    }
		}
	    }
	}

	return valid;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {

	String lowercase = word.toLowerCase();
	String pigLatinWord;
	String vowels = "aeiou";
	if (vowels.indexOf(lowercase.charAt(0)) != -1) {
	    pigLatinWord = word + "way";

	} else {
	    int vowelIndex = 0;
	    while (vowelIndex < lowercase.length() && vowels.indexOf(lowercase.charAt(vowelIndex)) == -1) {
		vowelIndex++;
	    }
	    if (vowelIndex == lowercase.length()) {
		pigLatinWord = lowercase + "ay";

	    } else {
		String leadingConsonants = lowercase.substring(0, vowelIndex);
		String restOfWord = lowercase.substring(vowelIndex);
		pigLatinWord = restOfWord + leadingConsonants + "ay";
	    }
	}
	if (Character.isUpperCase(word.charAt(0))) {
	    pigLatinWord = Character.toUpperCase(pigLatinWord.charAt(0)) + pigLatinWord.substring(1);
	}

	return pigLatinWord;
    }

}
