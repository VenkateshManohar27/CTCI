package com.vm.ctci.chapter3.stacksQs;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnimalShelterTest {
	private static Dog jimmy, yellow, brownie;
	private static Cat catie, snowy, chips;
	private AnimalShelter animalShelter;
	
	@BeforeClass
	public static void setUp() {
		jimmy = new Dog("jimmy");
		yellow = new Dog("yellow");
		brownie = new Dog("brownie");
		catie = new Cat("catie");
		snowy = new Cat("snowy");
		chips = new Cat("chips");
	}
	
	@Before
	public void setUpForEachTest() {
		animalShelter = new AnimalShelter();
	}
	
	@Test(expected = EmptyStackException.class)
	public void testDequeueEmptyShelter() {
		animalShelter.dequeueAny();
	}
	
	@Test(expected = EmptyStackException.class)
	public void testDequeueDogEmptyShelter() {
		animalShelter.dequeueDog();
	}
	
	@Test(expected = EmptyStackException.class)
	public void testDequeueCatEmptyShelter() {
		animalShelter.dequeueCat();
	}
	
	@Test
	public void testHappyPath() {
		animalShelter.enqueue(jimmy);
		animalShelter.enqueue(catie);
		animalShelter.enqueue(chips);
		assertEquals(jimmy, animalShelter.dequeueAny());
		assertEquals(catie, animalShelter.dequeueAny());
		assertEquals(chips, animalShelter.dequeueAny());
	}
	
	@Test
	public void testShelterWithOnlyDogs() {
		animalShelter.enqueue(jimmy);
		animalShelter.enqueue(yellow);
		animalShelter.enqueue(brownie);
		assertEquals(jimmy, animalShelter.dequeueAny());
		assertEquals(yellow, animalShelter.dequeueAny());
		assertEquals(brownie, animalShelter.dequeueAny());
	}
	
	@Test
	public void testShelterWithOnlyCats() {
		animalShelter.enqueue(catie);
		animalShelter.enqueue(snowy);
		animalShelter.enqueue(chips);
		assertEquals(catie, animalShelter.dequeueAny());
		assertEquals(snowy, animalShelter.dequeueAny());
		assertEquals(chips, animalShelter.dequeueAny());
	}
	
	@Test
	public void testShelterDequeueDogsOnly() {
		animalShelter.enqueue(jimmy);
		animalShelter.enqueue(catie);
		animalShelter.enqueue(yellow);
		animalShelter.enqueue(snowy);
		animalShelter.enqueue(brownie);
		animalShelter.enqueue(chips);
		assertEquals(jimmy, animalShelter.dequeueDog());
		assertEquals(yellow, animalShelter.dequeueDog());
		assertEquals(brownie, animalShelter.dequeueDog());
		assertEquals(catie, animalShelter.dequeueAny());
		
	}
	
	@Test
	public void testShelterDequeueCatsOnly() {
		animalShelter.enqueue(jimmy);
		animalShelter.enqueue(catie);
		animalShelter.enqueue(yellow);
		animalShelter.enqueue(snowy);
		animalShelter.enqueue(brownie);
		animalShelter.enqueue(chips);
		assertEquals(catie, animalShelter.dequeueCat());
		assertEquals(snowy, animalShelter.dequeueCat());
		assertEquals(chips, animalShelter.dequeueCat());
		assertEquals(jimmy, animalShelter.dequeueAny());
	}
	
	@Test(expected=EmptyStackException.class)
	public void testShelterEmptyAfterDequeueall() {
		animalShelter.enqueue(jimmy);
		animalShelter.enqueue(catie);
		animalShelter.enqueue(yellow);
		animalShelter.enqueue(snowy);
		animalShelter.enqueue(brownie);
		animalShelter.enqueue(chips);
		assertEquals(jimmy, animalShelter.dequeueAny());
		assertEquals(catie, animalShelter.dequeueAny());
		assertEquals(yellow, animalShelter.dequeueAny());
		assertEquals(snowy, animalShelter.dequeueAny());
		assertEquals(brownie, animalShelter.dequeueAny());
		assertEquals(chips, animalShelter.dequeueAny());
		animalShelter.dequeueAny();
		
	}

}
