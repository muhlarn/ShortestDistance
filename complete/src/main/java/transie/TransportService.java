package transie;

import java.util.List;

public interface TransportService {
	
	List<Transport> getShortestRoute(String source, String destination);

}
