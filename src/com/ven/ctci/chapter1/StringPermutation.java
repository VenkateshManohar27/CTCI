package com.ven.ctci.chapter1;

public class StringPermutation {

	private static void handleResult(boolean result) {
		if (result) {
			System.out.println("Strings are permutation");
		} else {
			System.out.println("String are not permutation");
		}

	}

	private static boolean isPermutation(String s1, String s2) {
		int[] numOfChars = new int[256];
		// TODO Auto-generated method stub
		if (s1.length() != s2.length()) {
			return false;
		}

		for (int i = 0; i < s1.length(); i++) {
			numOfChars[s1.charAt(i)]++;
			numOfChars[s2.charAt(i)]--;
		}

		for (int i = 0; i < numOfChars.length; i++) {
			if (numOfChars[i] != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		boolean result = isPermutation("abcidefg", "gfedabhc");
		handleResult(result);
		
		result = isPermutation("abcdefg", "gfedabc");
		handleResult(result);
	}

}
