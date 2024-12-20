package me.ayushdhar.ProductService.Mappers;

import lombok.Getter;
import lombok.Setter;
import me.ayushdhar.ProductService.Models.Category;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class CategoryMapper {

    public static Category convertFakeStoreCategoryToCategoryObject(String string){
        Category category = new Category();
        category.setName(string);
        return category;
    }
}
