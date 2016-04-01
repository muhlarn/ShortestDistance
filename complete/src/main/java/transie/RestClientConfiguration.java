package transie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.core.AnnotationRelProvider;
import org.springframework.hateoas.core.DefaultRelProvider;
import org.springframework.hateoas.core.DelegatingRelProvider;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.plugin.core.OrderAwarePluginRegistry;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
//@ComponentScan("transie")
public class RestClientConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(halConverter());

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.setMessageConverters(converters);

		return restTemplate;
	}

	@Bean
	public MappingJackson2HttpMessageConverter halConverter() {
		RelProvider defaultRelProvider = defaultRelProvider();
		RelProvider annotationRelProvider = annotationRelProvider();

		OrderAwarePluginRegistry<RelProvider, Class<?>> relProviderPluginRegistry = OrderAwarePluginRegistry
		        .create(Arrays.asList(defaultRelProvider, annotationRelProvider));

		DelegatingRelProvider delegatingRelProvider = new DelegatingRelProvider(relProviderPluginRegistry);

		ObjectMapper halObjectMapper = new ObjectMapper();
		halObjectMapper.registerModule(new Jackson2HalModule());
		//halObjectMapper
		  //      .setHandlerInstantiator(Jackson2HalModule.new Jackson2HalModule.HalHandlerInstantiator(delegatingRelProvider, null));

		MappingJackson2HttpMessageConverter halConverter = new MappingJackson2HttpMessageConverter();
		halConverter.setSupportedMediaTypes(Arrays.asList(MediaTypes.HAL_JSON));
		halConverter.setObjectMapper(halObjectMapper);
		return halConverter;
	}

	@Bean
	public DefaultRelProvider defaultRelProvider() {
		return new DefaultRelProvider();
	}

	@Bean
	public AnnotationRelProvider annotationRelProvider() {
		return new AnnotationRelProvider();
	}

}