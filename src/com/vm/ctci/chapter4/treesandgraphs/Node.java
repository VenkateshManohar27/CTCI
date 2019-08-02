package com.vm.ctci.chapter4.treesandgraphs;

public class Node {
	
		public int data;
		public Node left, right, parent;

		public Node() {
			super();
		}

		public Node(int value) {
			this.data = value;
		}
		
		public Node(int value, Node parent) {
			this.data = value;
			this.parent = parent;
		}

}
