package com.ven.ctci.chapter1;

public class PalindromePermutationBitVector {

	public static void main(String[] args) {
		canFormPalindrome("venkatesh");
		canFormPalindrome("abccba");
		canFormPalindrome("radar");

	}

	private static void canFormPalindrome(String str) {
		int bitVector = createBitVector(str);

		boolean result = checkExactlyOneBitSet(bitVector);
		if (result) {
			System.out.println("String \"" + str + "\" can form a palindrome");
		} else {
			System.out.println("String \"" + str + "\" can't form a palindrome");
		}
	}

	private static int createBitVector(String str) {
		int bitVector = 0;
		for (char c : str.toCharArray()) {
			int index = getCharacterIndex(c);
			bitVector = toggleBits(bitVector, index);
		}
		return bitVector;
	}

	private static int toggleBits(int bitVector, int index) {
		int mask = 1 << index;
		if((bitVector & mask) ==0) {
			bitVector |= mask;
		}else {
			bitVector &= ~mask;
		}
		return bitVector;
	}

	private static boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}

	private static int getCharacterIndex(char c) {
		if (c >= 'a' && c <= 'z') {
			return c - 'a';
		}
		return -1;
	}

}
