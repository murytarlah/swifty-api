package com.swifty.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swifty.webapi.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  
}