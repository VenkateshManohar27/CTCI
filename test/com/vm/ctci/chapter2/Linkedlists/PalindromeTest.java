package com.vm.ctci.chapter2.Linkedlists;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.vm.ctci.chapter2.Linkedlists.LinkedList;
import com.vm.ctci.chapter2.Linkedlists.Node;
import com.vm.ctci.chapter2.Linkedlists.Palindrome;

public class PalindromeTest {
	
	private static Palindrome palindrome = new Palindrome();
	private static Node palindromeEvenLength1 =  null;
	private static Node palindromeEvenLength2 =  null;
	private static Node palindromeOddLength1 =  null;
	private static Node palindromeOddLength2 =  null;
	private static Node notPalindromeEvenLength1 =  null;
	private static Node notPalindromeOddLength2 =  null;
	
	@BeforeClass
	public static void setUp() {
		LinkedList list = new LinkedList();
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(2);
		list.appendToTail(1);
		palindromeEvenLength1 = list.head;
		
		LinkedList list1 = new LinkedList();
		list1.appendToTail(1);
		list1.appendToTail(2);
		list1.appendToTail(3);
		list1.appendToTail(3);
		list1.appendToTail(2);
		list1.appendToTail(1);
		palindromeEvenLength2 = list1.head;
		
		LinkedList list2 = new LinkedList();
		list2.appendToTail(1);
		list2.appendToTail(0);
		list2.appendToTail(1);
		palindromeOddLength1 = list2.head;
		
		LinkedList list3 = new LinkedList();
		list3.appendToTail(1);
		list3.appendToTail(2);
		list3.appendToTail(3);
		list3.appendToTail(2);
		list3.appendToTail(1);
		palindromeOddLength2 = list3.head;
		
		LinkedList list4 = new LinkedList();
		list4.appendToTail(1);
		list4.appendToTail(2);
		list4.appendToTail(2);
		list4.appendToTail(3);
		notPalindromeEvenLength1 = list4.head;
		
		LinkedList list5 = new LinkedList();
		list5.appendToTail(1);
		list5.appendToTail(1);
		list5.appendToTail(2);
		
		notPalindromeOddLength2 = list5.head;
		
	}
	
	@Test
	public void testEmpty() {
		boolean result = palindrome.isPalindromeUsingReverse(null);
		assertFalse(result);
	}

	@Test
	public void testPalindromeEvenLength1() {
		boolean result = palindrome.isPalindromeUsingReverse(palindromeEvenLength1);
		assertTrue(result);
	}
	
	@Test
	public void testPalindromeEvenLength2() {
		boolean result = palindrome.isPalindromeUsingReverse(palindromeEvenLength2);
		assertTrue(result);
	}
	
	@Test
	public void testPalindromeOddLength1() {
		boolean result = palindrome.isPalindromeUsingReverse(palindromeOddLength1);
		assertTrue(result);
	}
	
	@Test
	public void testPalindromeOddLength2() {
		boolean result = palindrome.isPalindromeUsingReverse(palindromeOddLength2);
		assertTrue(result);
	}
	
	@Test
	public void testNotPalindromeEvenLength1() {
		boolean result = palindrome.isPalindromeUsingReverse(notPalindromeEvenLength1);
		assertFalse(result);
	}
	
	
	@Test
	public void testNotPalindromeOddLength2() {
		boolean result = palindrome.isPalindromeUsingReverse(notPalindromeOddLength2);
		assertFalse(result);
	}
	
	
	@Test
	public void testPalindromeUsingStackEvenLength1() {
		boolean result = palindrome.isPalindromeUsingStack(palindromeEvenLength1);
		assertTrue(result);
	}
	
	@Test
	public void testPalindromeUsingStackEvenLength2() {
		boolean result = palindrome.isPalindromeUsingStack(palindromeEvenLength2);
		assertTrue(result);
	}
	
	@Test
	public void testPalindromeUsingStackOddLength1() {
		boolean result = palindrome.isPalindromeUsingStack(palindromeOddLength1);
		assertTrue(result);
	}
	
	@Test
	public void testPalindromeUsingStackOddLength2() {
		boolean result = palindrome.isPalindromeUsingStack(palindromeOddLength2);
		assertTrue(result);
	}
	
	@Test
	public void testNotPalindromeUsingStackEvenLength1() {
		boolean result = palindrome.isPalindromeUsingStack(notPalindromeEvenLength1);
		assertFalse(result);
	}
	
	
	@Test
	public void testNotPalindromeUsingStackOddLength2() {
		boolean result = palindrome.isPalindromeUsingStack(notPalindromeOddLength2);
		assertFalse(result);
	}
}
