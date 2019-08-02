package com.vm.ctci.chapter3.stacksQs;

import java.util.Comparator;

public class SortStack<T> {

	private Stack<T> sortedStack;
	private Stack<T> tempStack;
	private Comparator<T> comparatorInstance;

	public SortStack(Comparator<T> comparator) {
		super();
		sortedStack = new Stack<>();
		tempStack = new Stack<>();
		comparatorInstance = comparator;
	}

	public void push(T data) {
		while (!sortedStack.isEmpty() && compare(data, sortedStack.peak())) {
			tempStack.push(sortedStack.pop());
		}
		sortedStack.push(data);
		while (!tempStack.isEmpty()) {
			sortedStack.push(tempStack.pop());
		}
	}

	public T pop() {
		return sortedStack.pop();
	}

	public T peak() {
		return sortedStack.peak();
	}

	public boolean isEmpty() {
		return sortedStack.isEmpty();
	}

	public boolean compare(T item1, T item2) {
		return (comparatorInstance.compare(item1, item2) > 0);
	}

	public static Comparator<Integer> ascending = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {

			return Integer.compare(o1, o2);
		}

	};

	public static Comparator<Integer> descending = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {

			return Integer.compare(o2, o1);
		}

	};
}
