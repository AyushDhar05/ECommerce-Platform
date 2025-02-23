package me.ayushdhar.ProductService.Services;

import me.ayushdhar.ProductService.Exceptions.ProductNotFoundException;
import me.ayushdhar.ProductService.Models.Category;
import me.ayushdhar.ProductService.Models.Product;
import me.ayushdhar.ProductService.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public Product getSingleProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.getProductById(id);
        if(optionalProduct.isEmpty()) throw new ProductNotFoundException("Product with id: " + id + " does not exist!");
        return optionalProduct.get();
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
