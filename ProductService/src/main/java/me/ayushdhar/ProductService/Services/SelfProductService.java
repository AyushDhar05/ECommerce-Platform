package me.ayushdhar.ProductService.Services;

import me.ayushdhar.ProductService.Models.Category;
import me.ayushdhar.ProductService.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService{
    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public Product getSingleProduct(Long id) {
        Product product = null;
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }
}
