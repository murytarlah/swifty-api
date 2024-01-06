package com.swifty.webapi.controller;

import com.swifty.webapi.dto.ApiResponse;
import com.swifty.webapi.service.product.ProductService;
import lombok.AllArgsConstructor;
import com.swifty.webapi.dto.ProductDTO;
import com.swifty.webapi.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ApiResponse<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product createdProduct = productService.createProduct(productDTO);
        return new ApiResponse<>(HttpStatus.CREATED.value(), "product added successfully",createdProduct);
    }

    @GetMapping
    public ApiResponse<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        String message = !products.isEmpty() ? "products fetched successfully": "no product found";
        return new ApiResponse<>(HttpStatus.OK.value(), message, products);
    }

    @GetMapping("/{id}")
    public ApiResponse<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        return new ApiResponse<>( HttpStatus.OK.value(), "product fetched successfully",product );
    }

    @PutMapping("/{id}")
    public ApiResponse<Product> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
        Product updatedProduct = productService.updateProduct(productDTO, id);
        return new ApiResponse<>(HttpStatus.OK.value(),"product updated successfully",updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Product> deleteProduct(@PathVariable Long id) {
        Product deletedProduct = productService.deleteProduct(id);
        return new ApiResponse<>( HttpStatus.OK.value(),"product deleted successfully",null);
    }
}
