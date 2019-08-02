package com.vm.ctci.chapter3.stacksQs;

import java.util.EmptyStackException;

public class Stack<T> {

	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			super();
			this.data = data;
		}
	}

	private StackNode<T> top = null;

	public T pop() {
		if (top == null)
			throw new EmptyStackException();

		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T item) {
		StackNode<T> node = new StackNode<T>(item);
		node.next = top;
		top = node;
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
		
		return false;
	}
}
