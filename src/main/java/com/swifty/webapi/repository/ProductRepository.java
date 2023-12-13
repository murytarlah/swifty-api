package com.swifty.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swifty.webapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
