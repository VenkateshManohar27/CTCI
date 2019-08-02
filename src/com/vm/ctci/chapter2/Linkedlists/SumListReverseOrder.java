package com.vm.ctci.chapter2.Linkedlists;

import java.util.LinkedList;
import java.util.List;

public class SumListReverseOrder {
	private List<Integer> l1;
	private List<Integer> l2;
	private List<Integer> result;
	public List<Integer> add(List<Integer> l1, List<Integer> l2) {
		this.result = new LinkedList<>();
		this.l1 = l1;
		this.l2 = l2;
		
		return addLists(getElement(l1,0), getElement(l2,0), 0, 0);
	}

	private List<Integer> addLists(Integer list1Item, Integer list2Item, int carry, int index) {
		if (list1Item == null && list2Item == null && carry == 0) {
			return null;
		} 
		
		
		int value = carry;

		if (list1Item != null) {
			value += list1Item;
		}

		if (list2Item != null) {
			value += list2Item;
		}

		result.add(value % 10);
	    index +=1;
		addLists(getElement(l1,index), getElement(l2,index), value > 10 ? 1 : 0, index);
		return result;
	}
	
	private Integer getElement(List<Integer> list, int index) {
		Integer element = null;
		if(list != null && list.size() > index  ) {
			element = list.get(index);
		}
		return element;
				
	}

}
