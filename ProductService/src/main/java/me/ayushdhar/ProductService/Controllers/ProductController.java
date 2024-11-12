package me.ayushdhar.ProductService.Controllers;

import me.ayushdhar.ProductService.Models.Product;
import me.ayushdhar.ProductService.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    // all CRUD APIs for product

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Product createProduct(){
        return null;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    public Product updateProduct(Long id){
        return null;
    }

    public String deleteProduct(Long id){
        return "";
    }
}
