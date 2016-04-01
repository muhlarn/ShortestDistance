package co.za.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import co.za.discovery.engine.DijkstraAlgorithm;
import co.za.discovery.model.Vertex;
import transie.ShortestRoute;
import transie.Transport;

public class ShortRouteUtil {

	public static ShortestRoute getWSShortRouteService()
			throws MalformedURLException {
		URL url = new URL("http://localhost:8080/gs-accessing-data-rest-0.1.0/ShortestRouteImpl?wsdl");
	        QName qname = new QName("http://transie/", "ShortestRouteImplService");
	 
	        Service service = Service.create(url, qname);
	 
	        ShortestRoute shortRoute = service.getPort(ShortestRoute.class);
		return shortRoute;
	}
	
	public static int populateVertexList(List<Transport> transList,
			DijkstraAlgorithm d_alg) {
		
		List<Vertex> vertexList = new ArrayList<Vertex>();
		int listCount = 0;
		int d_algLength = 0;
		
		Collections.sort(transList, Transport.TransportOriginComparator);
		char previousChar = ' ';
		
		for (Transport trans : transList) {
			
			Vertex vertex = new Vertex(trans.getDestination().charAt(0), trans.getDistance().doubleValue());
			
			
			if (listCount == 0) {
				vertexList.add(vertex);
			} else if(Character.valueOf(previousChar) == Character.valueOf(trans.getOrigin().charAt(0))) {
				vertexList.add(vertex);
			} else {
				//System.out.println(previousChar + ", " + vertexList);
				//System.out.println(previousChar + ", " + vertex);
				d_alg.addVertex(previousChar, vertexList);
				vertexList = new ArrayList<Vertex>();
				vertexList.add(vertex);	 
				d_algLength += 1;
				
			}
			
			listCount += 1;
			previousChar = trans.getOrigin().charAt(0);
		}
		
		//we add the last iteration
		d_alg.addVertex(previousChar, vertexList);
		d_algLength += 1;
		
		return d_algLength;
	}

}
