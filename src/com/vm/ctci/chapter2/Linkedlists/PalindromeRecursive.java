package com.vm.ctci.chapter2.Linkedlists;

class Result {
	Node node;
	boolean res;
	
	public Result(Node node, boolean res) {
		super();
		this.node = node;
		this.res = res;
	}
}

public class PalindromeRecursive {
	public boolean isPalindrome(Node node) {
		if (node == null) {
			return false;
		}
		int length = length(node);
		Result p = isPalindromeRecursive(node, length);
		return p.res;
	}

	private Result isPalindromeRecursive(Node node, int length) {
		if (node == null || length <= 0) {
			return new Result(node, true);
		} else if (length == 1) {
			return new Result(node.next, true);
		}
		
		Result res = isPalindromeRecursive(node.next, length-2);
		
		if(!res.res || res.node==null ) {
			return res;
		}
		
		res.res =(res.node.data == node.data);
		
		res.node= res.node.next;

		return res;
	}

	private int length(Node node) {
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}

}
