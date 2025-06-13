package com.softwarelabs.InventorySystem.modules.catalog.controller;

import com.softwarelabs.InventorySystem.modules.catalog.dto.ProductRequestDTO;
import com.softwarelabs.InventorySystem.modules.catalog.dto.ProductResponseDTO;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Product;
import com.softwarelabs.InventorySystem.modules.catalog.service.ProductService;
import com.softwarelabs.InventorySystem.modules.catalog.transformer.GenericMapper;
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

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("/add")
    public ResponseEntity<ProductRequestDTO> createProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) throws Exception {
        Product product = service.save(GenericMapper.convertToEntity(productRequestDTO, Product.class));
        return new ResponseEntity<>(GenericMapper.convertToDto(product, ProductRequestDTO.class), HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() throws Exception {
        List<ProductResponseDTO> productResponseDTOs = service.readAll().stream()
                .map(e -> GenericMapper.convertToDto(e, ProductResponseDTO.class))
                .toList();
        return new ResponseEntity<>(productResponseDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) throws Exception {
        ProductResponseDTO productResponseDTO = GenericMapper.convertToDto(service.readById(id), ProductResponseDTO.class);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PutMapping("/add")
    public ResponseEntity<ProductRequestDTO> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequestDTO productRequestDTO)
            throws Exception {
        Product product = service.update(GenericMapper.convertToEntity(productRequestDTO, Product.class), id);
        return new ResponseEntity<>(GenericMapper.convertToDto(product, ProductRequestDTO.class), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
