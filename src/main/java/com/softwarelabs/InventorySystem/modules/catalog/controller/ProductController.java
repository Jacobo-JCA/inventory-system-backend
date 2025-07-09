package com.softwarelabs.InventorySystem.modules.catalog.controller;

import com.softwarelabs.InventorySystem.modules.catalog.common.mapper.ProductMapper;
import com.softwarelabs.InventorySystem.modules.catalog.dto.ProductRequestDTO;
import com.softwarelabs.InventorySystem.modules.catalog.dto.ProductResponse;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Product;
import com.softwarelabs.InventorySystem.modules.catalog.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/products")
@RestController
public class ProductController {
    private final ProductService service;

    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY')")
    @PostMapping("/add")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) throws Exception {
        Product product = service.save(ProductMapper.convertToEntity(productRequestDTO));
        return new ResponseEntity<>(ProductMapper.convertToDto(product), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY')")
    @GetMapping(path = "/all")
    public ResponseEntity<List<ProductResponse>> getAllProducts() throws Exception {
        List<ProductResponse> productResponseDTOs = service.readAll().stream()
                .map(ProductMapper::convertToDto)
                .toList();
        return new ResponseEntity<>(productResponseDTOs, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY')")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) throws Exception {
        ProductResponse productResponse = ProductMapper.convertToDto(service.readById(id));
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequestDTO productRequestDTO)
            throws Exception {
        Product product = service.update(ProductMapper.convertToEntity(productRequestDTO), id);
        return new ResponseEntity<>(ProductMapper.convertToDto(product), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('INVENTORY')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
