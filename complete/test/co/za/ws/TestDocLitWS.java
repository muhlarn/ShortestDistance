package co.za.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import co.za.util.ShortRouteUtil;
import transie.ShortestRoute;
import transie.ShortestRouteImpl;
import transie.Transport;


public class TestDocLitWS {
	
	public static void main(String[] args) throws Exception {
		 
		getShortRouteService();
	 
	    }

	private static void getShortRouteService() throws MalformedURLException {
		ShortestRoute shortRoute = ShortRouteUtil.getWSShortRouteService();
	 
	        List<Character> transList = shortRoute.getShortestRoute("A", "D");
	         
	        System.out.println("returning back the results " + transList.size());
	        for (Character trans : transList) {
	        	System.out.println(trans);
	        }
	}

	

}
