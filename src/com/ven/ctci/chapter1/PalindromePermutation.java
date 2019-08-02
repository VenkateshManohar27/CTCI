package com.ven.ctci.chapter1;

public class PalindromePermutation {

	public static void main(String[] args) {
		canFormPalindrome("venkatesh");
		canFormPalindrome("abccba");
		canFormPalindrome("radar");

	}

	private static void canFormPalindrome(String str) {
		int[] table = createCharFrequencyTable(str);
		boolean result = checkMaxOdd(table);
		if (result) {
			System.out.println("String \"" + str + "\" can form a palindrome");
		} else {
			System.out.println("String \"" + str + "\" can't form a palindrome");
		}
	}

	private static boolean checkMaxOdd(int[] table) {
		int oddCount = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] % 2 == 1) {
				oddCount++;
			}
		}
		if (oddCount > 1) {
			return false;
		}
		return true;
	}

	private static int[] createCharFrequencyTable(String str) {
		int[] charFrequencyTable = new int[26];
		for (char c : str.toCharArray()) {
			int index = getCharacterIndex(c);
			if (index == -1) {
				continue;
			}
			charFrequencyTable[index]++;
		}
		return charFrequencyTable;
	}

	private static int getCharacterIndex(char c) {
		if (c >= 'a' && c <= 'z') {
			return c - 'a';
		}
		return -1;
	}

}
