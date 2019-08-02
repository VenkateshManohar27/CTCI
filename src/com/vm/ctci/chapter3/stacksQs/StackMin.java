package com.vm.ctci.chapter3.stacksQs;

import com.vm.ctci.chapter3.stacksQs.Stack;

public class StackMin extends Stack<Integer> {
	private Stack<Integer> stackMin = new Stack<>();

	public void push(Integer data) {
		if (data <= min()) {
			stackMin.push(data);
		}
		super.push(data);
	}

	public Integer min() {
		if (stackMin.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return stackMin.peak();
		}
	}

	public Integer pop() {
		Integer item = super.pop();

		if (item == min()) {
			stackMin.pop();
		}
		return item;
	}

}
