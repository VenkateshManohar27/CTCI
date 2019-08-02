package com.ven.ctci.chapter1;

public class OneAway {

	private static boolean oneEditReplace(String str1, String str2) {
		boolean foundDifference = false;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}

	private static boolean oneEditInsert(String str1, String str2) {
		int index1 = 0;
		int index2 = 0;
		while (index1 < str1.length() && index2 < str2.length()) {
			if (str1.charAt(index1) != str2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}

		return true;
	}

	private static void oneEditAway(String str1, String str2) {
		boolean result = false;
		if (str1.length() == str2.length()) {
			result = oneEditReplace(str1, str2);
		} else if (str1.length() + 1 == str2.length()) {
			result = oneEditInsert(str1, str2);
		} else if (str1.length() - 1 == str2.length()) {
			result = oneEditInsert(str2, str1);
		}
		if (result) {
			System.out.println(str1 + " and " + str2 + " is one edit away!!");
		} else {
			System.out.println(str1 + " and " + str2 + " is not one edit away!!");
		}
	}

	public static void main(String[] args) {
		oneEditAway("pale", "ple");
		oneEditAway("pales", "pale");
		oneEditAway("pale", "bale");
		oneEditAway("pale", "bake");
	}

}
