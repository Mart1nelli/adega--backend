package com.adegadopaibackend.adegadopaibackend.service;

import com.adegadopaibackend.adegadopaibackend.dto.request.CreateCategoryRequest;
import com.adegadopaibackend.adegadopaibackend.dto.request.UpdateCategoryRequest;
import com.adegadopaibackend.adegadopaibackend.dto.response.CategoryResponse;
import java.util.List;

public interface CategoryService {

    CategoryResponse create(CreateCategoryRequest req);

    List<CategoryResponse> findAll();

    CategoryResponse findById(Long id);

    CategoryResponse update(Long id, UpdateCategoryRequest req);

    void delete(Long id);
}
