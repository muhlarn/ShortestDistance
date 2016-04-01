package transie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@Component("transportService")
@Transactional
public class TransportServiceImpl implements TransportService {

	private final TransportRepository transportRepository;
	
	@Autowired
	public TransportServiceImpl(TransportRepository transportRepository) {
		this.transportRepository = transportRepository;
	}
	
	
	@Override
	public List<Transport> getShortestRoute(String origin, String destination) {
		
		System.out.println("getting shortest route");
		Assert.notNull(origin, "source cannot be empty");
		Assert.notNull(destination, "destination cannot be empty");
		
		List<Transport> transportList = transportRepository.findAll();
		
		for(Transport transport : transportList) {
			System.out.println(transport.getOrigin());
		}
		
		return this.transportRepository.findByOriginAndDestination(origin, destination);
	}

}
