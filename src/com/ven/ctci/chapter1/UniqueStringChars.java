package com.ven.ctci.chapter1;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique
 * characters.What if you cant use any data structure
 * 
 * @author Venkatesh Manohar
 *
 */
public class UniqueStringChars {

	/**
	 * Handle only ASCII characters
	 * 
	 * @param str
	 * @return
	 */
	private boolean isUnique(String str) {
		if (str.length() > 128)
			return false;

		boolean[] charSet = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}

	private boolean isUniqueBitVectorApproach(String str) {
		int checker = 0;

		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= 1<<val;
		}

		return true;
	}

	private static void handleResult(boolean result) {
		if (result) {
			System.out.println("String has unique characters");
		} else {
			System.out.println("String has duplicate characters");
		}

	}

	public static void main(String[] args) {
		UniqueStringChars usc = new UniqueStringChars();
		boolean result = usc.isUnique("abcdefghia");
		handleResult(result);
		result = usc.isUnique("abcdefghijklmnop");
		handleResult(result);

		result = usc.isUniqueBitVectorApproach("abcdefghia");
		handleResult(result);
		result = usc.isUnique("abcdefghijklmnop");
		handleResult(result);

	}

}
