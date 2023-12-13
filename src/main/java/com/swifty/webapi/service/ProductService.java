package com.swifty.webapi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import lombok.*;

import com.swifty.webapi.dto.ProductDTO;
import com.swifty.webapi.repository.ProductRepository;
import com.swifty.webapi.model.Product;


@Service
@AllArgsConstructor
public class ProductService {    
    private final ProductRepository productRepository;

    public Product createProduct(ProductDTO productDTO) {

        Product product = new Product();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());

        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ArrayList<Product> getAllProducts() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    public Product updateProduct(ProductDTO productDTO, Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());

        return productRepository.save(product);
    }

    public Product deleteProduct(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.deleteById(id);
        return product;
    }

}
