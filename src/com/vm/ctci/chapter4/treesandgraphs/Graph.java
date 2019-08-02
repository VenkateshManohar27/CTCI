package com.vm.ctci.chapter4.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

enum State {
	Unvisited, Visiting, Visited
}

public class Graph {

	Node[] nodes;

	public Graph(int size) {
		super();
		this.nodes = new Node[size];
	}

	public static class Node {
		String name;
		List<Node> children;
		State state;

		public Node(String name) {
			this.name = name;
		}

		public void addChild(Node n) {
			if (children == null) {
				children = new ArrayList<Node>();
			}
			children.add(n);
		}

		public List<Node> getNodes() {
			return children;
		}

		public boolean nodeHasChildren() {
			return children != null || children.size() > 0;
		}

	}
}
