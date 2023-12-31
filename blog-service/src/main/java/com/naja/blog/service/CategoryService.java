package com.naja.blog.service;

import com.naja.blog.dto.request.CategoryRequest;
import com.naja.blog.dto.response.CategoryResponse;
import com.naja.blog.model.Category;

import java.util.List;

public interface CategoryService {
    Category save(CategoryRequest category);
    List<CategoryResponse> getAll();
}
