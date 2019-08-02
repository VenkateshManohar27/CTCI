package com.vm.ctci.chapter4.treesandgraphs;

import java.util.LinkedList;

import com.vm.ctci.chapter4.treesandgraphs.Graph.Node;

public class RouteBetweenNodes {

	public static boolean search(Graph g, Node start, Node end) {
		if(g == null || start == null || end == null) {
			return false;
		}
		if (start == end) {
			return true;
		}
		LinkedList<Node> q = new LinkedList<>();

		q.add(start);
		start.state = State.Visiting;
		while (!q.isEmpty()) {
			Node n = q.removeFirst();
			if (n != null) {
				for (Node node : n.getNodes()) {
					if (State.Visited == node.state) {
						continue;
					}
					if (node == end) {
						return true;
					}else {
						q.addLast(node);
						node.state = State.Visiting;
					}
				}
			}
			n.state = State.Visited;
		}

		return false;
	}

}
