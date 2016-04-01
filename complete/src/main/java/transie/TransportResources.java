package transie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;


public class TransportResources extends Resources<Transport> {

	public TransportResources() {
	}

	public TransportResources(final Iterable<Transport> content, final Iterable<Link> links) {
		super(content, links);
	}

	public TransportResources(final Iterable<Transport> content, final Link... links) {
		super(content, links);
	}

	public List<Transport> unwrap() {
		Collection<Transport> resources = getContent();
		List<Transport> transports = new ArrayList<>(resources.size());

		for (Transport resource : resources) {
			transports.add(resource);
		}

		return transports;
	}

}
