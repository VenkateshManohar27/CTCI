package com.vm.utility;

import com.vm.ctci.chapter4.treesandgraphs.Node;

public class TreeUtility {

	public static int maxDepth(Node root) {
	    if(root==null)
	        return 0;
	 
	    int leftDepth = maxDepth(root.left);
	    int rightDepth = maxDepth(root.right);
	 
	    int bigger = Math.max(leftDepth, rightDepth);
	 
	    return bigger+1;
	}

	public static int calculateTreeNodes(Node root) {
		int depth = maxDepth(root);
		
		return (int) (Math.pow(2, depth+1)-1);
	}

}
