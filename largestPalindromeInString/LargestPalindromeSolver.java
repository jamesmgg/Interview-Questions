package largestPalindromeInString;

import java.util.LinkedList;

public class LargestPalindromeSolver {

	public static String findLargestPalindrome(String str) {
		String largestPalindrome = "";
		for (int i = 0; i < str.length(); i++) {
			String palindrome = getLargestPalindromeAtIndex(str, i);
			if (palindrome.length() > largestPalindrome.length()) {
				largestPalindrome = palindrome;
			}
		}
		return largestPalindrome;
	}

	// Finds a palindrome starting at that index
	static String getLargestPalindromeAtIndex(String str, int index) {
		String palindrome = "";
		char c = str.charAt(index);
		for (int i = str.length() - 1; i > index; i--) {
			if (str.charAt(i) == c) {
				String possiblePalindrome = str.substring(index, i + 1);
				if (isPalindrome(possiblePalindrome)) {
					// If longer palindrome found, save it.
					if (possiblePalindrome.length() > palindrome.length()) {
						palindrome = possiblePalindrome;
					}
				}
			}
		}
		return palindrome;
	}

	public static boolean isPalindrome(String str) {
		LinkedList<String> stack = new LinkedList<String>();
		int middle = str.length() / 2;
		for (int i = 0; i < middle; i ++) {
			stack.push("" + str.charAt(i));
		}
		// If string is odd, skip middle character
		if (str.length() % 2 != 0) {
			middle++;
		}
		for (int i = middle; i < str.length(); i ++) {
			if (!stack.pop().equals("" + str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
