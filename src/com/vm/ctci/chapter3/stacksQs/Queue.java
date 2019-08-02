package com.vm.ctci.chapter3.stacksQs;

import java.util.NoSuchElementException;

public class Queue<T> {
	private static class QueueNode<T> {
		private T data;
		public QueueNode<T> next;

		public QueueNode(T item) {
			data = item;
		}
	}

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T data) {
		QueueNode<T> node = new QueueNode<T>(data);
		if(last != null) {
			last.next = node;
		}
		last = node;
		
		if(first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}
