package me.ayushdhar.ProductService.Services;

import me.ayushdhar.ProductService.Models.Category;
import me.ayushdhar.ProductService.Models.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    Product getSingleProduct(Long id);

    List<Product> getAllProducts();

    List<Category> getAllCategories();

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);

    Product deleteProduct(Long id);
}

