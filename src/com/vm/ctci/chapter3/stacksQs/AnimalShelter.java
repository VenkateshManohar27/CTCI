package com.vm.ctci.chapter3.stacksQs;

import java.util.EmptyStackException;
import java.util.LinkedList;

abstract class Animal {
	private String name;
	private int order;

	public String getName() {
		return name;
	}

	public int getOrder() {
		return order;
	}

	public Animal(String name) {
		this.name = name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public boolean isOlderThan(Animal b) {
		return this.order < b.order;
	}

	abstract void makeSound();
}

class Dog extends Animal {

	public Dog(String name) {
		super(name);
		
	}

	@Override
	void makeSound() {
		System.out.println("Bow Bow!!");

	}

}

class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	void makeSound() {
		System.out.println("Meow ....");

	}

}

public class AnimalShelter {
	private int order = 0;
	private LinkedList<Dog> dogs;
	private LinkedList<Cat> cats;

	public AnimalShelter() {
		super();
		this.dogs = new LinkedList<>();
		this.cats = new LinkedList<>();
	}

	public boolean enqueue(Animal a) {
		order++;
		a.setOrder(order);
		if (a instanceof Dog) {
			dogs.add((Dog) a);
		}

		if (a instanceof Cat) {
			cats.add((Cat) a);
		}

		return true;
	}

	public Dog dequeueDog() {
		if (dogs.size() == 0) {
			throw new EmptyStackException();
		}
		return dogs.removeFirst();
	}

	public Cat dequeueCat() {
		if (cats.size() == 0) {
			throw new EmptyStackException();
		}
		return cats.removeFirst();
	}

	public Animal dequeueAny() {
		if (dogs.size() == 0 && cats.size() == 0) {
			throw new EmptyStackException();
		}

		if (dogs.size() == 0) {
			return cats.removeFirst();
		}
		if (cats.size() == 0) {
			return dogs.removeFirst();
		}

		Animal dog = dogs.getFirst();
		Animal cat = cats.getFirst();

		if (dog.isOlderThan(cat)) {
			return dogs.removeFirst();
		} else {
			return cats.removeFirst();
		}

	}

}
