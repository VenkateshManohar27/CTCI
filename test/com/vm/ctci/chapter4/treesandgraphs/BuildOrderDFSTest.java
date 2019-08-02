package com.vm.ctci.chapter4.treesandgraphs;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vm.ctci.chapter4.treesandgraphs.BuildOrderDFS.Project;

public class BuildOrderDFSTest {

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
		Stack<Project> projects = BuildOrderDFS.findBuildOrder(projectNames, dependencies);
		assertEquals("e", projects.pop().getName());
		assertEquals("f", projects.pop().getName());
		assertEquals("b", projects.pop().getName());
		assertEquals("a", projects.pop().getName());
		assertEquals("d", projects.pop().getName());
		assertEquals("c", projects.pop().getName());

	}

	@Test
	public void testCTCIex2() {
		String[] projectNames = { "f", "d", "c", "b", "a", "g", "e" };
		String[][] dependencies = { { "f", "c" }, { "f", "b" }, { "f", "a" }, { "c", "a" }, { "b", "a" }, { "a", "e" },
				{ "b", "e" }, { "d", "g" } };
		Stack<Project> projects = BuildOrderDFS.findBuildOrder(projectNames, dependencies);
		assertEquals("f", projects.pop().getName());
		assertEquals("d", projects.pop().getName());
		assertEquals("c", projects.pop().getName());
		assertEquals("b", projects.pop().getName());
		assertEquals("g", projects.pop().getName());
		assertEquals("a", projects.pop().getName());
		assertEquals("e", projects.pop().getName());

	}

}
