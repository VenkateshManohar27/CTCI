package com.ven.ctci.chapter1;

public class URLify {
	
	public static char[] replaceChars(char[] str, int truelength) {
		int spaceCount = 0;
		//Count spaces with in the actual string excluding the buffer spaces
		for (int i = 0; i < truelength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		int index = truelength+ spaceCount*2;
		for (int i = truelength -1; i >=0; i--) {
			if(str[i] == ' ') {
				str[index-1] = '0';
				str[index-2] = '2';
				str[index-3] = '%';
				index-=3;
			}else {
				str[index-1] = str[i];
				index--;
			}
		}
		
		return str;
	}

	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		System.out.println(replaceChars(str.toCharArray(), 13));
	}
}
