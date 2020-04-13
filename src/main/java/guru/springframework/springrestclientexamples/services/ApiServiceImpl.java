package guru.springframework.springrestclientexamples.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;
import guru.springframework.springrestclientexamples.config.PropertyConfig;
import guru.springframework.springrestclientexamples.config.RestServiceConfig;

@Service
public class ApiServiceImpl implements ApiService {

	@Value("${api.uri}")
	String restUri;
	
	@Autowired
	PropertyConfig propertyConfig;

	private final RestTemplate restTemplate;

	public ApiServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<User> getUsers(Integer limit) {

		
//		  RestServiceConfig config = (RestServiceConfig)propertyConfig.getRestServiceConfig(); 
//		  String restUrl = config.getServiceUrl(); 
//		  UserData userData = restTemplate.getForObject(restUrl + limit, UserData.class);
//		 

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.
				fromUriString(restUri).
				queryParam("limit", limit);

		UserData userData = restTemplate.getForObject(uriBuilder.toUriString(), UserData.class);
		
		return userData.getData();
	}

}
