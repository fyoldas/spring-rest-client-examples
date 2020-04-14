package guru.springframework.springrestclientexamples.services;


import java.util.List;

import guru.springframework.api.domain.Customer;
import guru.springframework.api.domain.Customers;
import guru.springframework.api.domain.User;

public interface ApiService {

	List<User> getUsers(Integer limit);
	Customers  getCustomers();
	Customer createCustomer(Customer customer);
	Customer updateCustomer(Long id, Customer customer);
	void deleteCustomerById(Long id);
}
