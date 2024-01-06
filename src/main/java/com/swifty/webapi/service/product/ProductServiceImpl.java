package com.swifty.webapi.service.product;

import java.util.List;

import com.swifty.webapi.exception.ProductException;
import org.springframework.stereotype.Service;
import lombok.*;

import com.swifty.webapi.dto.ProductDTO;
import com.swifty.webapi.repository.ProductRepository;
import com.swifty.webapi.model.Product;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDTO productDTO) {

        Product product = new Product();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());

        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

        return allProducts;
    }

    @Override
    public Product updateProduct(ProductDTO productDTO, Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductException("Product not found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());

        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductException("Product not found"));
        productRepository.deleteById(id);
        return product;
    }

}
