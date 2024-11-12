package me.ayushdhar.ProductService.Mappers;

import me.ayushdhar.ProductService.DTOs.FakeStoreProductDTO;
import me.ayushdhar.ProductService.Models.Category;
import me.ayushdhar.ProductService.Models.Product;

public class ProductMapper {

    public static Product convertFakeStoreProductDTOtoProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        Category category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        product.setDescription(fakeStoreProductDTO.getDescription());
        return product;
    }
}
