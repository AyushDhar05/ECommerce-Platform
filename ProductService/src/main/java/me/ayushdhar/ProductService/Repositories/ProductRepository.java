package me.ayushdhar.ProductService.Repositories;

import me.ayushdhar.ProductService.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{ 
}
