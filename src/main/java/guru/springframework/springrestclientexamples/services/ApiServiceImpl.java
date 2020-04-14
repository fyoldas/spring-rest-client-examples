package guru.springframework.springrestclientexamples.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import guru.springframework.api.domain.Customer;
import guru.springframework.api.domain.Customers;
import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;
import guru.springframework.springrestclientexamples.config.PropertyConfig;
import guru.springframework.springrestclientexamples.config.RestServiceConfig;

@Service
public class ApiServiceImpl implements ApiService {

	@Value("${api.uri.fy}")
	String restUriFy;
	
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

	@Override
	public Customers getCustomers() {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.
				fromUriString(restUriFy);

		Customers customers = restTemplate.getForObject(uriBuilder.toUriString(), Customers.class);
		
		return customers;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.
				fromUriString(restUriFy);

		Customer savedCustomer = restTemplate.postForObject(uriBuilder.toUriString(), customer, Customer.class);
		
		return savedCustomer;
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.
				fromUriString(restUriFy);

		Map<String, Long> uriParameters = new HashMap<String, Long>();
		uriParameters.put("id", id);

		restTemplate.put(uriBuilder.toUriString() + "/{id}", customer,  uriParameters);
		
		return customer;
	}

	@Override
	public void deleteCustomerById(Long id) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.
				fromUriString(restUriFy);

		Map<String, Long> uriParameters = new HashMap<String, Long>();
		uriParameters.put("id", id);

		restTemplate.delete(uriBuilder.toUriString() + "/{id}", uriParameters);
	}

}
