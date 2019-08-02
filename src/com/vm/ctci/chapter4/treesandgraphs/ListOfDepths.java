package com.vm.ctci.chapter4.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
	public static ArrayList<LinkedList<Node>> createListOfDepthsRecursive(Node root) {
		ArrayList<LinkedList<Node>> listOfDepths = new ArrayList<>();
		createListOfDepths(root, listOfDepths, 0);
		return listOfDepths;
	}

	private static void createListOfDepths(Node node, ArrayList<LinkedList<Node>> listOfDepths, int level) {
		if (node == null) {
			return;
		}
		LinkedList<Node> levelList = null;
		if (listOfDepths.size() == level) {
			levelList = new LinkedList<>();
			listOfDepths.add(levelList);
		} else {
			levelList = listOfDepths.get(level);

		}
		levelList.add(node);

		createListOfDepths(node.left, listOfDepths, level + 1);
		createListOfDepths(node.right, listOfDepths, level + 1);
	}

	public static ArrayList<LinkedList<Node>> createListOfDepthsBFS(Node root) {
		ArrayList<LinkedList<Node>> listOfDepths = new ArrayList<>();

		LinkedList<Node> current = new LinkedList<>();
		if (root != null) {
			current.add(root);
		}

		while (!current.isEmpty()) {
			listOfDepths.add(current);
			LinkedList<Node> parents = current;
			current = new LinkedList<>();
			for (Node n : parents) {
				if(n.left != null) {
					current.add(n.left);
				}
				if(n.right != null) {
					current.add(n.right);
				}
			}

		}

		return listOfDepths;
	}

}
