package guru.springframework.springrestclientexamples.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:service.properties")
})
public class PropertyConfig {

	@Value("${resturl}")
	String serviceUrl;
	
	@Bean
	public RestServiceConfig getRestServiceConfig() {
		RestServiceConfig restServiceConfig = new RestServiceConfig();
		restServiceConfig.setServiceUrl(serviceUrl);
		return restServiceConfig;
	}
}
