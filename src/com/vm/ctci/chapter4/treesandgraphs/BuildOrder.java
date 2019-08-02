package com.vm.ctci.chapter4.treesandgraphs;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildOrder {

	public static Project[] findBuildOrder(String[] projectNames, String[][] dependencies) {
		Graph graph = buildGraph(projectNames, dependencies);
		return createBuildOrder(graph);
	}

	private static Project[] createBuildOrder(Graph graph) {
		Project[] buildOrder = new Project[graph.children.size()];
		ArrayList<Project> projects = graph.children;
		int endIndex = addNonDependentsToBuildOrder(projects, 0, buildOrder);
		int index = 0;
		while (index < graph.children.size()) {
			Project project = buildOrder[index];

			if (project == null) {
				return null;
			}
			
			ArrayList<Project> children = project.getChildren();
			for (Project child: children) {
				child.decrementDependencies();
			}
			
			endIndex = addNonDependentsToBuildOrder(children, endIndex, buildOrder);
			index++;
			
		}
		return buildOrder;
	}

	private static int addNonDependentsToBuildOrder(ArrayList<Project> projects, int index, Project[] buildOrder) {
		for (int i = 0; i < projects.size(); i++) {
			if (projects.get(i).getDependencies() == 0) {
				buildOrder[index] = projects.get(i);
				index++;
			}

		}
		return index;
	}

	private static Graph buildGraph(String[] projectNames, String[][] dependencies) {
		Graph graph = new Graph();
		for (String name : projectNames) {
			graph.createOrAddNode(name);
		}

		for (String[] dependent : dependencies) {
			String start = dependent[0];
			String end = dependent[1];

			graph.addEdge(start, end);
		}

		return graph;
	}

	static class Graph {
		private ArrayList<Project> children = new ArrayList<>();
		private HashMap<String, Project> projects = new HashMap<>();

		public Project createOrAddNode(String name) {
			if (!projects.containsKey(name)) {
				Project project = new Project(name);
				children.add(project);
				projects.put(name, project);
				return project;
			}
			return projects.get(name);
		}

		public void addEdge(String start, String end) {
			Project startNode = createOrAddNode(start);
			Project endNode = createOrAddNode(end);
			startNode.addDependent(endNode);

		}

		public ArrayList<Project> getChildren() {
			return children;
		}

	}

	static class Project {
		private String name;
		private int dependencies;
		private ArrayList<Project> children = new ArrayList<>();

		public ArrayList<Project> getChildren() {
			return children;
		}

		public Project(String name) {
			this.name = name;
		}

		public void addDependent(Project end) {
			this.children.add(end);
			end.incrementDependencies();
		}

		public String getName() {
			return name;
		}

		public int getDependencies() {
			return dependencies;
		}

		public void incrementDependencies() {
			dependencies++;
		}

		public void decrementDependencies() {
			dependencies--;
		}
	}
}
