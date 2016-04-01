package transie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.hateoas.mvc.TypeConstrainedMappingJackson2HttpMessageConverter;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import co.za.discovery.engine.DijkstraAlgorithm;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebService
// @SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public class ShortestRouteImpl implements ShortestRoute {

	@Autowired
	TransportServiceImpl transServ;

	public ShortestRouteImpl() {

	}

	@Override
	public List<Character> getShortestRoute(String origin, String destination) {

		char originChar = origin.charAt(0);
		char destinationChar = destination.charAt(0);

		return new DijkstraAlgorithm().getShortestPath(originChar, destinationChar);

	}

	
	@Override
	public List<Transport> getAllRouteData() {
		String url = "http://localhost:8080/gs-accessing-data-rest-0.1.0/transport";
		ResponseEntity<PagedResources<Transport>> responseEntity = restTemplate()
				.exchange(
						url,
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<PagedResources<Transport>>() {
						});

		PagedResources<Transport> resources = responseEntity.getBody();
		List<Transport> transports = new ArrayList<Transport>(
				resources.getContent());
		System.out.println(transports);

		System.out.println("The size before the end: " + transports.size());

		return transports;
	}

	private RestTemplate restTemplate() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		mapper.registerModule(new Jackson2HalModule());

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(MediaType
				.parseMediaTypes("application/hal+json"));
		converter.setObjectMapper(mapper);
		return new RestTemplate(Arrays.asList(converter));
	}
}
