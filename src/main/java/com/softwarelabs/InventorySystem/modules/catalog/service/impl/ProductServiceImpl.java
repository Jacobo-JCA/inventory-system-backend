package com.softwarelabs.InventorySystem.modules.catalog.service.impl;

import com.softwarelabs.InventorySystem.modules.catalog.entity.Category;
import com.softwarelabs.InventorySystem.modules.catalog.repo.CategoryRepo;
import com.softwarelabs.InventorySystem.modules.catalog.common.crud.CRUDImpl;
import com.softwarelabs.InventorySystem.modules.catalog.repo.GenericRepo;
import com.softwarelabs.InventorySystem.modules.catalog.exception.NotFoundException;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Product;
import com.softwarelabs.InventorySystem.modules.catalog.repo.ProductRepo;
import com.softwarelabs.InventorySystem.modules.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl extends CRUDImpl<Product, Long> implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    @Override
    protected GenericRepo<Product, Long> getRepo() {
        return productRepo;
    }

    @Override
    public Product save(Product product) throws Exception {
        Category category = categoryRepo.findById(product.getCategory().getIdCategory()).orElseThrow(()
            -> new NotFoundException("ID Not Found"));
        Product productSave = Product.builder()
                .name(product.getName())
                .code(product.getCode())
                .unitPrice(product.getUnitPrice())
                .stockQuantity(product.getStockQuantity())
                .description(product.getDescription())
                .category(category)
                .build();
        return super.save(productSave);
    }

    @Transactional
    @Override
    public Product update(Product product, Long aLong) throws Exception {
        product.setIdProduct(aLong);
        if (product.getCategory().getIdCategory() != null) {
            Category category = categoryRepo.findById(product.getCategory().getIdCategory())
                    .orElseThrow(() -> new NotFoundException("Category not found"));
            product.setCategory(category);
        }
        return super.update(product, aLong);
    }
//
//    private String saveImage(MultipartFile imageFile) {
//        // 1. Validación del tipo de archivo
//        if (!imageFile.getContentType().startsWith("image/")) {
//            throw new IllegalArgumentException("Solo se permiten archivos de imagen");
//        }
//        // 2. Definir directorio usando Path (mejor que File)
//        Path uploadDir = Paths.get(IMAGE_DIRECTORY).toAbsolutePath().normalize();
//        try {
//            // 3. Crear directorio si no existe (con createDirectories)
//            Files.createDirectories(uploadDir);
//        } catch (IOException e) {
//            throw new RuntimeException("Error al crear el directorio: " + e.getMessage());
//        }
//        // 4. Generar nombre único y seguro
//        String originalFileName = imageFile.getOriginalFilename();
//        String safeFileName = originalFileName.replaceAll("[^a-zA-Z0-9.-]", "-");
//        String uniqueFileName = UUID.randomUUID() + "_" + safeFileName;
//        // 5. Construir ruta completa con Path (evita concatenar strings)
//        Path destinationPath = uploadDir.resolve(uniqueFileName);
//        try (InputStream inputStream = imageFile.getInputStream()) {
//            // 6. Copiar el archivo usando NIO (más eficiente que transferTo)
//            Files.copy(inputStream, destinationPath, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            throw new IllegalArgumentException("Error al guardar la imagen: " + e.getMessage());
//        }
//        return destinationPath.toString();
//    }

}
