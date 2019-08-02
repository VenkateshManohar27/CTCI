package com.ven.ctci.chapter1;

public class StringCompression {

	private static String compress(String str) {
		StringBuilder compressedStr = new StringBuilder();
		int charCount = 0;
		for (int i = 0; i < str.length(); i++) {
			charCount++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedStr.append(str.charAt(i));
				compressedStr.append(charCount);
				charCount = 0;
			}
			if (compressedStr.length() > str.length()) {
				return str;
			}
		}
		return compressedStr.toString();
	}

	public static void main(String[] args) {
		System.out.println(compress("abdc"));
		System.out.println(compress("aabbbcccccaa"));
	}
}
