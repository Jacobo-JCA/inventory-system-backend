package com.softwarelabs.InventorySystem.modules.catalog.controller;

import com.softwarelabs.InventorySystem.modules.catalog.dto.CategoryDTO;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Category;
import com.softwarelabs.InventorySystem.modules.catalog.service.CategoryService;
import com.softwarelabs.InventorySystem.modules.catalog.transformer.GenericMapper;
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

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) throws Exception {
        Category category = service.save(GenericMapper.convertToEntity(categoryDTO, Category.class));
        return new ResponseEntity<>(GenericMapper.convertToDto(category, CategoryDTO.class), HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws Exception {
        List<CategoryDTO> categoryDTOs = service.readAll().stream()
                .map(e -> GenericMapper.convertToEntity(e, CategoryDTO.class))
                .toList();
        return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) throws Exception {
        CategoryDTO categoryDTO = GenericMapper.convertToDto(service.readById(id), CategoryDTO.class);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO)
            throws Exception {
        Category category = service.update(GenericMapper.convertToEntity(categoryDTO, Category.class), id);
        return new ResponseEntity<>(GenericMapper.convertToDto(category, CategoryDTO.class),
                HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
