package transie;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ShortestRoute {

	@WebMethod
	public List<Character> getShortestRoute(String origin, String destination);

	public List<Transport> getAllRouteData();
}
