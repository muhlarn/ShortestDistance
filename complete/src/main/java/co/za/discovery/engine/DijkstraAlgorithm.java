package co.za.discovery.engine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import co.za.discovery.model.Vertex;

public class DijkstraAlgorithm {

	private final Map<Character, List<Vertex>> vertices;
	public final double doubleMax = Integer.MAX_VALUE; 

	public DijkstraAlgorithm() {
		this.vertices = new LinkedHashMap<Character, List<Vertex>>();
	}

	public void addVertex(Character character, List<Vertex> vertex) {
		this.vertices.put(character, vertex);
	}

	public List<Character> getShortestPath(Character start, Character finish) {
		
		Map<Character, Double> distances = new LinkedHashMap<Character, Double>();
		PriorityQueue<Vertex> nodes = new PriorityQueue<Vertex>();
		Map<Character, Vertex> previous = new LinkedHashMap<Character, Vertex>();
		List<Character> path = new LinkedList<Character>();

		addPreviousVertex(start, distances, nodes, previous);

		System.out.println(distances);
		while (!nodes.isEmpty()) {
			Vertex smallest = nodes.poll();
			if (smallest.getId() == finish) {
				path = new LinkedList<Character>();
				while (previous.get(smallest.getId()) != null) {
					path.add(smallest.getId());
					smallest = previous.get(smallest.getId());
				}
				
				return reverseInsertOrder(path);
			}

			if (distances.get(smallest.getId()) == doubleMax) {
				break;
			}

			for (Vertex neighbor : vertices.get(smallest.getId())) {
				Double alt = distances.get(smallest.getId())
						+ neighbor.getDistance();
				
				//System.out.println(smallest.getId() + "(" + alt + ")");
				
				if (null != distances.get(neighbor.getId())) {
					if (alt < distances.get(neighbor.getId())) {
						distances.put(neighbor.getId(), alt);
						previous.put(neighbor.getId(), smallest);
	
						forloop: for (Vertex n : nodes) {
							if (n.getId() == neighbor.getId()) {
								n.setDistance(alt);
								break forloop;
							}
						}
					}
				}
			}
		}
				
		List<Character> routeList = returnPathRoute(distances);

		return routeList;
	}
	
	private void addPreviousVertex(Character start,
			Map<Character, Double> distances, PriorityQueue<Vertex> nodes,
			Map<Character, Vertex> previous) {
		for (Character vertex : vertices.keySet()) {
			if (vertex == start) {
				distances.put(vertex, 0.00);
				nodes.add(new Vertex(vertex, 0.00));
			} else {
				distances.put(vertex, doubleMax);
				nodes.add(new Vertex(vertex, doubleMax));
			}
			previous.put(vertex, null);
		}
	}

	private List<Character> returnPathRoute(Map<Character, Double> distances) {
		
		List<Character> tempList = new ArrayList<Character>(distances.keySet());
		List<Character> routeList = reverseInsertOrder(tempList);
		
		return routeList;
	}
	
	private List<Character> reverseInsertOrder(List<Character> listToReverse) {
		
		Stack<Character> charStack = new Stack<Character>();
		List<Character> routeList = new ArrayList<Character>();

		for (Character c : listToReverse) {
			charStack.push(c);
		}

		int stackSize = charStack.size();
		for (int i=1; i<=stackSize; i++) {
			routeList.add(charStack.pop());
		}
		
		return routeList;
		
	}

}