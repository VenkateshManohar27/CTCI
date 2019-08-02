package com.vm.ctci.chapter4.treesandgraphs;

public class CommonAncestor {

	public static Node commonAncestorUsingParent(Node p, Node q) {
		if (p == null || q == null) {
			return null;
		}

		int delta = depth(p) - depth(q);
		Node shallower = null;
		Node deeper = null;
		if (delta > 0) {
			shallower = q;
			deeper = p;
		} else {
			shallower = p;
			deeper = q;
		}

		deeper = goUpBy(deeper, Math.abs(delta));

		while (deeper != null && shallower != null && deeper != shallower) {
			deeper = deeper.parent;
			shallower = shallower.parent;
		}

		return deeper;
	}

	private static Node goUpBy(Node deeper, int abs) {
		while (deeper != null && abs > 0) {
			deeper = deeper.parent;
			abs--;
		}
		return deeper;
	}

	private static int depth(Node node) {
		int depth = 0;
		while (node != null) {
			node = node.parent;
			depth++;
		}

		return depth;
	}

	public static Node commonAncestorUsingBottomUp(Node root, Node p, Node q) {
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		} else if (covers(p, q)) {
			return p;
		} else if (covers(q, p)) {
			return q;
		}

		Node sibling = getSibling(p);
		Node parent = p.parent;

		while (sibling != null && !covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}

		return parent;
	}

	private static Node getSibling(Node p) {
		Node parent = p.parent;
		if (parent == null)
			return null;
		return (parent.left == p) ? p.right : p.left;
	}

	private static boolean covers(Node root, Node p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}
		return covers(root.left, p) || covers(root.right, p);
	}

	public static Node commonAncestorWithoutParentLinks(Node root, Node p, Node q) {
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		}

		return commonAncestorHelper(root, p, q);
	}

	private static Node commonAncestorHelper(Node node, Node p, Node q) {
		if (node == null || node == p || node == q) {
			return node;
		}

		boolean pIsOnLeft = covers(node.left, p);
		boolean qIsOnLeft = covers(node.left, q);
		if (pIsOnLeft == qIsOnLeft) {
			if (pIsOnLeft) {
				node = node.left;
			} else {
				node = node.right;
			}
		} else {
			return node;
		}

		return commonAncestorHelper(node, p, q);
	}

}
