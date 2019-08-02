package com.vm.ctci.chapter4.treesandgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import com.vm.ctci.chapter4.treesandgraphs.BuildOrderDFS.Project.Status;

public class BuildOrderDFS {
	public static Stack<Project> findBuildOrder(String[] projectNames, String[][] dependencies) {
		Graph graph = buildGraph(projectNames, dependencies);
		return createBuildOrder(graph);
	}

	private static Stack<Project> createBuildOrder(Graph graph) {
		ArrayList<Project> nodes = graph.getNodes();
		Stack<Project> buildOrder = new Stack<>();
		for (Project project : nodes) {
			if (project.getStatus() == Status.BLANK) {
				doDFS(project, buildOrder);
			}
		}

		return buildOrder;
	}

	private static boolean doDFS(Project project, Stack<Project> buildOrder) {
		if (project.getStatus() == Status.PARTIAL) {
			return false;
		}
		if (project.getStatus() == Status.BLANK) {
			project.setStatus(Status.PARTIAL);
			ArrayList<Project> children = project.getChildren();

			for (Project child : children) {
				if (child.getStatus() == Status.BLANK) {
					if (!doDFS(child, buildOrder)) {
						return false;
					}
				}
			}
			project.setStatus(Status.COMPLETED);
			buildOrder.push(project);
		}
		return true;
	}

	private static Graph buildGraph(String[] projectNames, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : projectNames) {
			graph.createOrAddNode(project);
		}

		for (String[] dependents : dependencies) {
			Project start = graph.createOrAddNode(dependents[0]);
			Project end = graph.createOrAddNode(dependents[1]);
			start.addDependent(end);
		}
		return graph;
	}

	static class Graph {
		private ArrayList<Project> nodes = new ArrayList<>();
		private HashMap<String, Project> projects = new HashMap<>();

		public Project createOrAddNode(String name) {
			if (!projects.containsKey(name)) {
				Project project = new Project(name);
				nodes.add(project);
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

		public ArrayList<Project> getNodes() {
			return nodes;
		}

	}

	static class Project {
		private String name;
		private int dependencies;
		private ArrayList<Project> children = new ArrayList<>();

		public enum Status {
			BLANK, PARTIAL, COMPLETED
		};

		private Status status;

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public ArrayList<Project> getChildren() {
			return children;
		}

		public Project(String name) {
			this.name = name;
			this.status = Status.BLANK;
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
