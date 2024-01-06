package com.swifty.webapi.service.product;

import com.swifty.webapi.dto.ProductDTO;
import com.swifty.webapi.model.Product;

import java.util.List;

public interface ProductService {
	Product createProduct(ProductDTO productDTO);

	Product getProduct(Long id);

	List<Product> getAllProducts();

	Product updateProduct(ProductDTO productDTO, Long id);

	Product deleteProduct(Long id);
}
