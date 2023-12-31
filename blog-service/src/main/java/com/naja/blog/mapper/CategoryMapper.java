package com.naja.blog.mapper;

import com.naja.blog.dto.request.CategoryRequest;
import com.naja.blog.dto.response.CategoryResponse;
import com.naja.blog.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryDtoToCategory(CategoryRequest category);
    List<CategoryResponse> categoriesToCategoryDto(List<Category> categories);
}
