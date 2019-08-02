package com.vm.ctci.chapter4.treesandgraphs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vm.ctci.chapter4.treesandgraphs.BuildOrder.Project;

public class BuildOrderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHappyPath() {
		String[] projectNames = { "a", "b", "c", "d", "e", "f" };
		String[][] dependencies = { { "a", "d" }, { "f", "b" }, { "b", "d" }, { "f", "a" }, { "d", "c" } };
		Project[] projects = BuildOrder.findBuildOrder(projectNames, dependencies);
		assertEquals("e", projects[0].getName());
		assertEquals("f", projects[1].getName());
		assertEquals("b", projects[2].getName());
		assertEquals("a", projects[3].getName());
		assertEquals("d", projects[4].getName());
		assertEquals("c", projects[5].getName());

	}

	@Test
	public void testCTCIex2() {
		String[] projectNames = { "f", "d", "c", "b", "a", "g", "e" };
		String[][] dependencies = { { "f", "c" }, { "f", "b" }, { "f", "a" }, { "c", "a" }, { "b", "a" }, { "a", "e" },
				{ "b", "e" }, { "d", "g" } };
		Project[] projects = BuildOrder.findBuildOrder(projectNames, dependencies);
		assertEquals("f", projects[0].getName());
		assertEquals("d", projects[1].getName());
		assertEquals("c", projects[2].getName());
		assertEquals("b", projects[3].getName());
		assertEquals("g", projects[4].getName());
		assertEquals("a", projects[5].getName());
		assertEquals("e", projects[6].getName());

	}

}
