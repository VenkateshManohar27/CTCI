package com.vm.ctci.chapter3.stacksQs;

import java.util.EmptyStackException;

public class MyQueue<T> {
	private Stack<T> stackPush;
	private Stack<T> stackPop;

	public MyQueue() {
		super();
		this.stackPush = new Stack<>();
		this.stackPop = new Stack<>();
	}

	public void add(T data) {
		stackPush.push(data);
	}

	public T remove() {
		if(stackPop.isEmpty() && stackPush.isEmpty()) {
			throw new EmptyStackException();
		}
		shiftStacks();
		T item = stackPop.pop();
		return item;
	}

	private void shiftStacks() {
		if (stackPop.isEmpty()) {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
	}
	
	public T peak() {
		if(stackPop.isEmpty() && stackPush.isEmpty()) {
			throw new EmptyStackException();
		}
		shiftStacks();
		return stackPop.peak();
	}
	

}
