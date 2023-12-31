package com.naja.blog.service.impl;

import com.naja.blog.dto.request.CategoryRequest;
import com.naja.blog.dto.response.CategoryResponse;
import com.naja.blog.mapper.CategoryMapper;
import com.naja.blog.model.Category;
import com.naja.blog.repository.CategoryRepository;
import com.naja.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(CategoryRequest category) {
        return categoryRepository.save(CategoryMapper.INSTANCE.categoryDtoToCategory(category));
    }

    @Override
    public List<CategoryResponse> getAll() {
        return CategoryMapper.INSTANCE.categoriesToCategoryDto(categoryRepository.findAll());
    }
}
