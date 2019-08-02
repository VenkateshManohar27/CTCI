package com.vm.ctci.chapter2.Linkedlists;

public class Partition {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.appendToTail(3);
		list.appendToTail(5);
		list.appendToTail(8);
		list.appendToTail(5);
		list.appendToTail(10);
		list.appendToTail(2);
		list.appendToTail(1);
		print(list.head);
		Node head = partitionMyApproach(list.head, 5);
		print(head);
		
		/*head = partition(list.head, 5);
		print(head);*/
	}

	private static void print(Node head) {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
	}
	
	public static Node partitionMyApproach(Node node, int i) {
		Node head = null;
		Node tail = null;

		while (node != null) {
			if(node.data < i) {
				if(head == null) {
					head = node;
				}else {
					head.next = node;
				}
				
			}else {
				if(tail == null) {
					tail = node;
				}else {
					tail.next = node;
				}
			}
			node = node.next;
		}
		head.next = tail;
		return head;
	}

	public static Node partition(Node node, int i) {
		Node head = node;
		Node tail = node;

		while (node != null) {
			Node next = node.next;
			if (node.data < i) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			
			node = next;
		}
		tail.next = null;
		return head;
	}

}
