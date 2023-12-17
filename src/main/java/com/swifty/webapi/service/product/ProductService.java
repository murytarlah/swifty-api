package com.swifty.webapi.service.product;

import com.swifty.webapi.dto.ProductDTO;
import com.swifty.webapi.model.Product;

import java.util.ArrayList;

public interface ProductService {
	public Product createProduct(ProductDTO productDTO);

	public Product getProductById(Long id);

	public ArrayList<Product> getAllProducts();

	public Product updateProduct(ProductDTO productDTO, Long id);

	public Product deleteProduct(Long id);
}
