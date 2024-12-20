package me.ayushdhar.ProductService.Services;

import me.ayushdhar.ProductService.DTOs.FakeStoreProductDTO;
import me.ayushdhar.ProductService.Exceptions.ProductNotFoundException;
import me.ayushdhar.ProductService.Mappers.CategoryMapper;
import me.ayushdhar.ProductService.Mappers.ProductMapper;
import me.ayushdhar.ProductService.Models.Category;
import me.ayushdhar.ProductService.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
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
    public Product saveProduct(Product product) {
        String url = "https://fakestoreapi.com/products";
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.postForObject(url, product, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO==null) throw new ProductNotFoundException("New Product Couldn't be Saved!");
        return ProductMapper.convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO);
    }

    @Override
    public Product getSingleProduct(Long id) {
        String url = "https://fakestoreapi.com/products/" + id;
        FakeStoreProductDTO fakeStoreProductDTO =
                restTemplate.getForObject(url, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO==null) throw new ProductNotFoundException("Product with id: " + id + " not found!");
        return ProductMapper.convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject(url,
                FakeStoreProductDTO[].class);

        ArrayList<Product> productList = new ArrayList<>();
        if(fakeStoreProductDTOS==null) throw new ProductNotFoundException("No Products Exist in FakeStoreDB");
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS) {
            productList.add(ProductMapper.convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO));
        }
        return productList;
    }

    public List<Category> getAllCategories(){
        String url = "https://fakestoreapi.com/products/categories";
        String[] categories = restTemplate.getForObject(url, String[].class);
        List<Category> categoryList = new ArrayList<>();
        if(categories==null) throw new ProductNotFoundException("No Product Categories Exist in FakeStoreDB!");
        for(String string : categories) {
            categoryList.add(CategoryMapper.convertFakeStoreCategoryToCategoryObject(string));
        }
        return categoryList;
     }

     /* Fake Store has issues with patch request */
    @Override
    public Product updateProduct(Long id, Product product) {
        String url = "https://fakestoreapi.com/products/" + id;
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.patchForObject(url, product, FakeStoreProductDTO.class);
//        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor =
//                new HttpMessageConverterExtractor(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(product);
//        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.execute(url, HttpMethod.PATCH, requestCallback, responseExtractor);
        if(fakeStoreProductDTO==null) throw new ProductNotFoundException("Product with " + id + " Couldn't be Updated");
        return ProductMapper.convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        String url = "https://fakestoreapi.com/products/" + id;
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product);
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor);
        if(fakeStoreProductDTO==null) throw new ProductNotFoundException("Product with " + id + " Couldn't be Replaced");
        return ProductMapper.convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO);
    }

    @Override
    public Product deleteProduct(Long id) {
        String url = "https://fakestoreapi.com/products/" + id;
        RequestCallback requestCallback = restTemplate.httpEntityCallback(new Product(), FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.execute(url, HttpMethod.DELETE, requestCallback, responseExtractor);
        if(fakeStoreProductDTO==null) throw new ProductNotFoundException("Product with " + id + " Couldn't be Deleted.");
        return ProductMapper.convertFakeStoreProductDTOtoProduct(fakeStoreProductDTO);
    }
}
