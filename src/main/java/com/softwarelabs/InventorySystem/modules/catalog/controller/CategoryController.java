package com.softwarelabs.InventorySystem.modules.catalog.controller;

import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryRequestDTO;
import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryResponse;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Category;
import com.softwarelabs.InventorySystem.modules.catalog.service.CategoryService;
import com.softwarelabs.InventorySystem.modules.catalog.common.mapper.CategoryMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/categories")
@RestController
public class CategoryController {
    private final CategoryService service;

    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY')")
    @PostMapping("/add")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequestDTO categoryDTO) throws Exception {
        Category category = service.save(CategoryMapper.convertToEntity(categoryDTO));
        return new ResponseEntity<>(CategoryMapper.convertToDto(category), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY')")
    @GetMapping(path = "/all")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() throws Exception {
        List<CategoryResponse> categoryDTOs = service.readAll().stream()
                .map(CategoryMapper::convertToDto)
                .toList();
        return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY')")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) throws Exception {
        CategoryResponse categoryResponse = CategoryMapper.convertToDto(service.readById(id));
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY')")
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO categoryDTO)
            throws Exception {
        Category category = service.update(CategoryMapper.convertToEntity(categoryDTO), id);
        return new ResponseEntity<>(CategoryMapper.convertToDto(category),
                HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
