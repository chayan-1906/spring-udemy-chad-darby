package com.pdas.springdemo.service;

import java.util.List;

import com.pdas.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);
	
}