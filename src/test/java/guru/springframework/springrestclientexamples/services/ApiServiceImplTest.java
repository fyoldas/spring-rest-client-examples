package guru.springframework.springrestclientexamples.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.api.domain.Customer;
import guru.springframework.api.domain.Customers;
import guru.springframework.api.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

	@Autowired
	ApiService apiService;
	
	@Before
	public void setUp() throws Exception {
	}

	/*
	@Test
	public void testGetUsers() {
		List<User> users = apiService.getUsers(3);
		assertEquals(1, users.size());
	}
	*/
	
	/*
	@Test
	public void testGetCustmers() {
		Customers customers = apiService.getCustomers();
		assertEquals(2, customers.getCustomers().size());
	}
	*/
	
	/*
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("Mete");
		customer.setLastName("YOLDAŞ");
		
		Customer savedCustomer = apiService.createCustomer(customer);
		assertEquals("Mete", savedCustomer.getFirstName());
	}
	*/
	
	/*
	@Test
	public void updateCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("Metem");
		customer.setLastName("YOLDAŞ");
		
		long id = 3L;
		Customer updateCustomer = apiService.updateCustomer(id, customer);
		assertEquals("Metem", updateCustomer.getFirstName());
	}
	*/
	
	@Test
	public void deleteCustomer() {
		long id = 3L;
		apiService.deleteCustomerById(id);
	}

}
