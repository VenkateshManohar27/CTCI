package com.vm.ctci.chapter3.stacksQs;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ThreeInOne {
	private int[] values = null;
	private int[] sizes = null;
	private int stackCapacity = 0;
	private final int NO_OF_STACKS;

	public ThreeInOne(int stackSize, int numOfStacks) {
		super();
		this.stackCapacity = stackSize;
		NO_OF_STACKS = numOfStacks;
		values = new int[stackSize * NO_OF_STACKS];
		sizes = new int[NO_OF_STACKS];
	}

	public void push(int stackNum, int item) {
		if (isStackFull(stackNum)) {
			throw new NoSuchElementException("Stack is full");
		}
		int topIndex = indexOfTop(stackNum);
		values[++topIndex] = item;
		sizes[stackNum - 1]++;

	}

	public int pop(int stackNum) {
		if (isStackEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int topIndex = indexOfTop(stackNum);
		int item = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum - 1]--;
		return item;

	}

	public int peak(int stackNum) {
		if (isStackEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int topIndex = indexOfTop(stackNum);
		return values[topIndex];
	}

	private boolean isStackFull(int stackNum) {
		return sizes[stackNum - 1] == stackCapacity;
	}

	private boolean isStackEmpty(int stackNum) {
		return sizes[stackNum - 1] == 0;
	}

	private int indexOfTop(int stackNum) {
		int offset = (stackNum - 1) * stackCapacity;
		int size = sizes[stackNum - 1];

		return offset + size - 1;
	}

}
