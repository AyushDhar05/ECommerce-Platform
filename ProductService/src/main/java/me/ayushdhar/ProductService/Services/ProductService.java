package me.ayushdhar.ProductService.Services;

import me.ayushdhar.ProductService.Models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id);

    List<Product> getAllProducts();
}

