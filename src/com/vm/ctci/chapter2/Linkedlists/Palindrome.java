package com.vm.ctci.chapter2.Linkedlists;

import java.util.Stack;

public class Palindrome {

	public boolean isPalindromeUsingReverse(Node node) {
		if (node == null) {
			return false;
		}
		Node reversed = reverseAndClone(node);
		return isEqual(node, reversed);
	}

	private boolean isEqual(Node node, Node reversed) {
		while (node != null && reversed != null) {
			if (node.data != reversed.data) {
				return false;
			}
			node = node.next;
			reversed = reversed.next;
		}
		return node == null && reversed == null;
	}

	private Node reverseAndClone(Node node) {
		Node head = null;
		while (node != null) {
			Node n = new Node(node.data);
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}

	public boolean isPalindromeUsingStack(Node node) {
		if (node == null) {
			return false;
		}
		Stack<Integer> st = new Stack<>();
		Node fastRunner = node;
		Node slowRunner = node;

		while (fastRunner != null && fastRunner.next != null) {
			st.push(slowRunner.data);
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}
		
		if(fastRunner != null) {
			slowRunner = slowRunner.next;
		}
		
		while(slowRunner != null) {
			if(slowRunner.data != st.pop()) {
				return false;
			}
			slowRunner = slowRunner.next;
		}

		return true;
	}

}
