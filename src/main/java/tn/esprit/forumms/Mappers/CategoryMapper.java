package tn.esprit.forumms.Mappers;


import tn.esprit.forumms.DTOentities.CategoryProductDto;
import tn.esprit.forumms.Entity.CategoryProduct;

public class CategoryMapper {
    public static CategoryProductDto mapToDto(CategoryProduct categoryProduct){
        CategoryProductDto categoryProductDto = CategoryProductDto.builder()
                .nameCategoryProduct(categoryProduct.getNameCategoryProduct())
                .posts(categoryProduct.getPosts())
                .build();
        return categoryProductDto;
    }
    public static CategoryProduct mapToEntity(CategoryProductDto categoryProductDto){
        CategoryProduct categoryProduct = CategoryProduct.builder()
                .nameCategoryProduct(categoryProductDto.getNameCategoryProduct())
                .posts(categoryProductDto.getPosts())
                .build();
        return categoryProduct;
    }
}
