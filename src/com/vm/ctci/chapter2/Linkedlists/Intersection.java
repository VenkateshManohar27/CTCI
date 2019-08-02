package com.vm.ctci.chapter2.Linkedlists;

class TailAndLength {
	Node tail = null;
	int length = 0;

	public TailAndLength(Node tail, int length) {
		super();
		this.tail = tail;
		this.length = length;
	}
}

public class Intersection {

	public Node doIntersect(Node list1, Node list2) {
		if (list1 == null || list2 == null) {
			return null;
		}

		TailAndLength tl1 = getTailAndLength(list1);
		TailAndLength tl2 = getTailAndLength(list2);

		if (tl1.tail != tl2.tail) {
			return null;
		}
		Node longer = null;
		Node shorter = null;
		
		if (tl1.length > tl2.length) {
			longer = list1;
			shorter = list2;
		} else {
			longer = list2;
			shorter = list1;
		}
		
		longer = advanceLongerListByNodes(longer, Math.abs(tl1.length-tl2.length));
		
		while(shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		return longer;
	}

	

	private Node advanceLongerListByNodes(Node longer, int len) {
		while(longer != null && len > 0) {
			longer = longer.next;
			len--;
		}
		return longer;
	}



	private TailAndLength getTailAndLength(Node list) {
		int length = 0;
		while (list != null) {
			list = list.next;
			length++;
		}
		return new TailAndLength(list, length);
	}

}
