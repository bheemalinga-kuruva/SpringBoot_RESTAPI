package com.bhim.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhim.binding.Customer;
import com.bhim.binding.CustomerResponse;

@RestController
public class CustomerRestController {

	@PostMapping(value = "/customer", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerResponse> saveCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		CustomerResponse res = saveUser(customer);
		return new ResponseEntity<>(res, HttpStatus.CREATED);

	}


	@PutMapping(
			value = "/customer",
			consumes = "application/json",
			produces = "application/json"
	)
	public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody Customer c) {
		System.out.println("reuest "+c);
		Customer customers = getCustomers();
		 System.out.println("response data"+customers);
		   customers.setName(c.getName());
		  System.out.println(customers);
		return new ResponseEntity<>( new  CustomerResponse("Customer Updated"), HttpStatus.OK);
	}
	
	
	
	
	

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Integer id) {
		return new ResponseEntity<>(new CustomerResponse("customer deleted   " +  "1"), HttpStatus.OK);
	}

	@GetMapping(value = "/customers", produces = "application/json")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		Customer customer1 = new Customer(101, "abc", "abc@gmail.com");
		Customer customer2 = new Customer(102, "cba", "cba@gmail.com");
		Customer customer3 = new Customer(103, "bca", "bca@gmail.com");
		List<Customer> response = Arrays.asList(customer1, customer2, customer3);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/customer", produces = "application/json")
	public ResponseEntity<Customer> getCustomer() {
		Customer response = new Customer(101, "abc", "abc@gmail.com");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	public Customer getCustomers() {
		Customer response = new Customer(101, "abc", "abc@gmail.com");
		return response;
	}
	
	public CustomerResponse saveUser(Customer customer) {
		CustomerResponse response = new CustomerResponse();
		response.setName("success");
		return response;
	}
	
}
