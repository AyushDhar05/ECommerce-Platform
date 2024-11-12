package me.ayushdhar.ProductService.Services;

import me.ayushdhar.ProductService.DTOs.FakeStoreProductDTO;
import me.ayushdhar.ProductService.Mappers.ProductMapper;
import me.ayushdhar.ProductService.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {
        String url = "https://fakestoreapi.com/products/" + id;
        FakeStoreProductDTO fakeStoreProductDTO =
                restTemplate.getForObject(url, FakeStoreProductDTO.class);
        return ProductMapper.convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject(url,
                FakeStoreProductDTO[].class);

        ArrayList<Product> productList = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS) {
            productList.add(ProductMapper.convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO));
        }
        return productList;
    }
}
