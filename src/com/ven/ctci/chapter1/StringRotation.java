package com.ven.ctci.chapter1;

public class StringRotation {
	
	public static boolean isRotated(String s1, String s2) {
		String temp = s1+s1;
		if(temp.contains(s2)) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println("String is rotated:"+isRotated(s1, s2));
		
		String s3 = "water";
		String s4 = "bottle";
		System.out.println("String is rotated:"+isRotated(s3, s4));
	}
}
