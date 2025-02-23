package me.ayushdhar.ProductService.Repositories;

import me.ayushdhar.ProductService.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    Optional<Product> getProductById(long id);
}
