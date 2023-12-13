package com.swifty.webapi.service;


import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import com.swifty.webapi.repository.CustomerRepository;
import com.swifty.webapi.model.Customer;
import com.swifty.webapi.dto.CustomerDTO;


@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public Customer createCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer();

        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setEmail(customerDTO.getEmail());

        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public ArrayList<Customer> getAllCustomers() {
        return (ArrayList<Customer>) customerRepository.findAll();
    }

    public Customer updateCustomer(CustomerDTO customerDTO, Long id) {

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setEmail(customerDTO.getEmail());

        return customerRepository.save(customer);
    }

    public Customer deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).get();
        customerRepository.deleteById(id);
        return customer;
    }

}
