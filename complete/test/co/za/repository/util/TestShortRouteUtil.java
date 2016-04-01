package co.za.repository.util;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import transie.ShortestRoute;
import transie.Transport;
import co.za.discovery.engine.DijkstraAlgorithm;
import co.za.discovery.model.Vertex;
import co.za.util.ShortRouteUtil;

public class TestShortRouteUtil {
	
	List<Character> expectedResults = new ArrayList<Character>();
	
	@Before
	public void initInputs() {
		
		expectedResults.add('A');
		expectedResults.add('C');
		expectedResults.add('F');
		expectedResults.add('J');
	}
	
	@Test
	public void testConvertDataToVertex() {
		
		ShortestRoute shortRoute;
		List<Transport> transList;
		DijkstraAlgorithm d_alg = new DijkstraAlgorithm();
		new ArrayList<Vertex>();
		int d_algLength = 0;
		
		try {
			shortRoute = ShortRouteUtil.getWSShortRouteService();
			transList = shortRoute.getAllRouteData();
			
			d_algLength = ShortRouteUtil.populateVertexList(transList, d_alg);
			
			assertEquals(13, d_algLength);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}        
		
	}
	
	@Test
	public void testAlgorithmWithDBData() {
		
		ShortestRoute shortRoute;
		List<Transport> transList;
		DijkstraAlgorithm d_alg = new DijkstraAlgorithm();
		new ArrayList<Vertex>();
		try {
			shortRoute = ShortRouteUtil.getWSShortRouteService();
			transList = shortRoute.getAllRouteData();
			
			int d_algLength = ShortRouteUtil.populateVertexList(transList, d_alg);
			System.out.println(d_alg);
			List<Character> actualList = d_alg.getShortestPath('A', 'F');
			//List<Character> expectedResults = getListResults();
			
			System.out.println(actualList);
			System.out.println(expectedResults);
			Assert.assertEquals(expectedResults, actualList);
			//assertEquals(expectedResults);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}        		
		
	}
	
}
