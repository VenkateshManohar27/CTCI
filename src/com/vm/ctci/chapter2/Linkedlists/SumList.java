package com.vm.ctci.chapter2.Linkedlists;

import java.util.LinkedList;
import java.util.List;

class PartialSum {
	public Integer sum;
	public Integer carry = 0;
}

public class SumList {

	public List<Integer> add(List<Integer> list1, List<Integer> list2) {
		List<Integer> result = new LinkedList<>();
		if (list1 == null && list2 == null) {
			return null;
		} else {
			if (list1 == null) {
				list1 = new LinkedList<>();
			}
			if (list2 == null) {
				list2 = new LinkedList<>();
			}
		}

		if (list1.size() != list2.size()) {
			if (list1.size() > list2.size()) {
				padList(list2, list1.size() - list2.size());
			} else {
				padList(list1, list2.size() - list1.size());
			}
		}

		addList(list1, list2, 0, result);
		return result;
	}

	private void padList(List<Integer> list, int count) {
		for (int i = 1; i <= count; i++) {
			list.add(0, 0);
		}
	}

	private PartialSum addList(List<Integer> list1, List<Integer> list2, int index, List<Integer> res) {
		Integer list1Item = getElement(list1, index);
		Integer list2Item = getElement(list2, index);
		if (list1Item == null && list2Item == null) {
			return new PartialSum();
		}
		PartialSum partialSum = addList(list1, list2, ++index, res);

		int sum = list1Item + list2Item + partialSum.carry;
		res.add(0, sum % 10);
		PartialSum ps = new PartialSum();
		ps.carry = sum > 10 ? 1 : 0;
		return ps;

	}

	private Integer getElement(List<Integer> list, int index) {
		Integer element = null;
		if (list != null && list.size() > index) {
			element = list.get(index);
		}
		return element;

	}

}
