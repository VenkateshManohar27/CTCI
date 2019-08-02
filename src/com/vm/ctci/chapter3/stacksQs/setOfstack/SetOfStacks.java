package com.vm.ctci.chapter3.stacksQs.setOfstack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
	private final int stackCapacity;
	private ArrayList<Stack<Integer>> listOfStacks = new ArrayList<>();
	public SetOfStacks(int capacity) {
		this.stackCapacity = capacity;
	}
	
	public void push(int item) {
		Stack<Integer> st = getLastStack();
		if(st == null || st.isFull()) {
			st = new Stack<Integer>(stackCapacity);
			listOfStacks.add(st);
		}
		st.push(item);
		
	}
	
	public int pop() {
		Stack<Integer> st = getLastStack();
		if(st == null) {
			throw new EmptyStackException();
		}
		int item = st.pop();
		if(st.isEmpty()) {
			listOfStacks.remove(listOfStacks.size()-1);
		}
		return item;
	}
	
	public int peak() {
		Stack<Integer> st = getLastStack();
		if(st == null) {
			throw new EmptyStackException();
		}
		return st.peak();
	}

	private Stack<Integer> getLastStack() {
		if(listOfStacks.size() == 0) return null;
		return listOfStacks.get(listOfStacks.size()-1);
	}
	
}

class Stack<T> {
	
	private final int CAPACITY;
	private int numOfElements = 0;
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			super();
			this.data = data;
		}
	}
	
	public Stack(int capacity) {
		CAPACITY = capacity;
	}

	private StackNode<T> top = null;

	public T pop() {
		if (top == null)
			throw new EmptyStackException();

		T item = top.data;
		top = top.next;
		numOfElements --;
		return item;
	}

	public boolean push(T item) {
		if(isFull()) {
			return false;
		}
		StackNode<T> node = new StackNode<T>(item);
		node.next = top;
		top = node;
		numOfElements++;
		return true;
	}

	public T peak() {
		if (top == null)
			throw new EmptyStackException();

		return top.data;

	}
	
	public boolean isEmpty() {
		return (top == null);
	}

	public boolean isFull() {
		return numOfElements == CAPACITY;
	}
}