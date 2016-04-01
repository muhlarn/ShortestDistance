package co.za.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.za.discovery.engine.DijkstraAlgorithm;
import co.za.discovery.model.Vertex;
import static org.junit.Assert.assertEquals;

public class TestDijkstraAlgorithm {

	DijkstraAlgorithm g = new DijkstraAlgorithm();
	
	@Before
	public void initInputs() {
		
//		
//		g.addVertex('A', Arrays.asList(new Vertex('B', 7.00), new Vertex('C', 8.00)));
//		g.addVertex('B', Arrays.asList(new Vertex('A', 7.00), new Vertex('F', 2.00)));
//		g.addVertex('C', Arrays.asList(new Vertex('A', 8.00), new Vertex('F', 6.00),
//				new Vertex('G', 4.00)));
//		g.addVertex('D', Arrays.asList(new Vertex('F', 8.00)));
//		g.addVertex('E', Arrays.asList(new Vertex('H', 1.00)));
//		g.addVertex('F', Arrays.asList(new Vertex('B', 2.00), new Vertex('C', 6.00),
//				new Vertex('D', 8.00), new Vertex('G', 9.00), new Vertex('H', 3.00)));
//		g.addVertex('G', Arrays.asList(new Vertex('C', 4.00), new Vertex('F', 9.00)));
//		g.addVertex('H', Arrays.asList(new Vertex('E', 1.00), new Vertex('F', 3.00)));		
//		
		g.addVertex('A', Arrays.asList(new Vertex('B', 0.44), new Vertex('C', 1.89), new Vertex('D', 0.1)));
		g.addVertex('B', Arrays.asList(new Vertex('H', 2.44), new Vertex('E', 3.45), new Vertex('A', 0.44)));
		g.addVertex('C', Arrays.asList(new Vertex('F', 0.49), new Vertex('A', 1.89)));
		g.addVertex('D', Arrays.asList(new Vertex('L', 2.34), new Vertex('M', 2.61), new Vertex('A', 0.1)));
		g.addVertex('E', Arrays.asList(new Vertex('I', 8.09), new Vertex('B', 3.45)));
		g.addVertex('F', Arrays.asList(new Vertex('J', 5.46), new Vertex('K', 3.67), new Vertex('C', 0.49)));
		g.addVertex('G', Arrays.asList(new Vertex('Z', 5.25), new Vertex('H', 3.71)));
		g.addVertex('H', Arrays.asList(new Vertex('G', 3.71), new Vertex('B', 2.44)));		
		g.addVertex('Z', Arrays.asList(new Vertex('I', 13.97), new Vertex('G', 5.35)));		
		g.addVertex('I', Arrays.asList(new Vertex('J', 14.78), new Vertex('Z', 13.97), new Vertex('E', 8.09)));		
		g.addVertex('L', Arrays.asList(new Vertex('T', 15.23), new Vertex('D', 2.34)));
		g.addVertex('J', Arrays.asList(new Vertex('I', 14.78), new Vertex('F', 5.46)));
	}
	
	
	@Test
	public void testExcute() {
		
		List<Character> result = g.getShortestPath('A', 'J');
		assertEquals(getRouteList(), result);
	}

	private List<Character> getRouteList() {

		List<Character> routeList = new ArrayList<Character>();
		//routeList.add('A');
		routeList.add('C');
		routeList.add('F');
		routeList.add('J');

		return routeList;
	}

}