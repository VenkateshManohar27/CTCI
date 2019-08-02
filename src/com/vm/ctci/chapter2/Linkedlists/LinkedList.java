package com.vm.ctci.chapter2.Linkedlists;

import java.util.HashSet;

class Node {
	int data;
	Node next;

	Node(int d) {
		this.data = d;
	}
}

class Index {
	int value = 0;
}

public class LinkedList {
	public Node head = null;

	public LinkedList() {

	}
	
	public void appendToTail(Node node) {
		Node n = head;
		if (head == null) {
			head = node;
			return;
		}
		while (n.next != null) {
			n = n.next;
		}
		n.next = node;
	}

	public void appendToTail(int data) {
		Node n = head;
		Node end = new Node(data);
		if (head == null) {
			head = end;
			return;
		}
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public Node delete(int d) {
		if (head == null) {
			return null;
		}
		Node n = head;
		if (n.data == d) {
			head = head.next;
			return head;
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}

	public void print() {
		if (head == null) {
			return;
		}
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println();
	}

	public void removeDuplicatesUsingBuffer() {
		HashSet<Integer> set = new HashSet<>();
		if (head == null) {
			return;
		}
		Node n = head;
		Node previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
				n = n.next;
				continue;
			}
			set.add(n.data);
			previous = n;
			n = n.next;
		}

	}

	public void removeDuplicates() {
		Node current = head;
		while (current != null) {
			Node inner = current;
			while (inner.next != null) {
				if (current.data == inner.next.data) {
					inner.next = inner.next.next;
				} else {
					inner = inner.next;
				}
			}

			current = current.next;
		}
	}

	public Node getMiddleNode() {
		if (head == null) {
			return null;
		}

		Node pointer = head;
		Node fastPointer = head;
		while (fastPointer.next != null && fastPointer.next.next != null) {
			pointer = pointer.next;
			fastPointer = fastPointer.next.next;
		}
		return pointer;
	}

	public boolean deleteMiddleNode(Node middle) {
		if (middle.next == null) {
			return false;
		}

		Node next = middle.next;
		middle.data = next.data;
		middle.next = next.next;

		return true;
	}

	public Node kthNodeToLastRecursive(int k) {
		
		return kthNodeToLast(head, k, new Index());
	}

	private Node kthNodeToLast(Node curr, int k, Index index) {
		if(curr == null) {
			
			return null;
		}
		Node node = kthNodeToLast(curr.next, k, index);
		index.value+=1;
		if(index.value == k+1) {
			return curr;
		}
		return node;
	}

	public Node kthNodeToLast(int k) {
		Node p1 = head;

		for (int i = 0; i < k; i++) {
			if (p1.next == null) {
				return null;
			}
			p1 = p1.next;
		}
		Node p2 = head;
		while (p1.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p2;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.delete(2);
		list.print();
		list.appendToTail(1);
		list.print();
		list.delete(1);
		list.print();
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
		list.print();
		list.delete(2);
		list.print();
		list.delete(1);
		list.print();
		list.delete(5);
		list.print();
		list.delete(3);
		list.delete(4);
		list.print();

		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(1);
		list.appendToTail(4);
		list.appendToTail(2);
		list.appendToTail(5);
		list.appendToTail(5);
		list.print();
		list.removeDuplicatesUsingBuffer();
		list.print();
		list.delete(1);
		list.delete(2);
		list.delete(3);
		list.delete(4);
		list.delete(5);

		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(1);
		list.appendToTail(4);
		list.appendToTail(2);
		list.appendToTail(5);
		list.appendToTail(5);
		list.print();
		list.removeDuplicates();
		list.print();
		list.appendToTail(6);
		list.appendToTail(7);
		list.appendToTail(8);
		list.appendToTail(9);
		list.appendToTail(10);
		list.print();

		Node temp = list.kthNodeToLast(3);
		System.out.println("Kth node to last for value 3 is " + temp.data);
		temp = list.kthNodeToLastRecursive(3);
		System.out.println("Kth node to last for value 3 is " + temp.data);
		Node middle = list.getMiddleNode();
		list.deleteMiddleNode(middle);
		list.print();
		middle = list.getMiddleNode();
		list.deleteMiddleNode(middle);
		list.print();
	}
}
