package com.softwarelabs.InventorySystem.modules.catalog.service.impl;

import com.softwarelabs.InventorySystem.modules.catalog.entity.Category;
import com.softwarelabs.InventorySystem.modules.catalog.repo.CategoryRepo;
import com.softwarelabs.InventorySystem.modules.catalog.common.crud.CRUDImpl;
import com.softwarelabs.InventorySystem.modules.catalog.common.repo.GenericRepo;
import com.softwarelabs.InventorySystem.modules.catalog.exception.NotFoundException;
import com.softwarelabs.InventorySystem.modules.catalog.entity.Product;
import com.softwarelabs.InventorySystem.modules.catalog.repo.ProductRepo;
import com.softwarelabs.InventorySystem.modules.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


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

    //    @Override
//    public ResponseDTO createProduct(ProductDTO productDTO, MultipartFile imageFile) {
//        Category category = categoryRepo.findById(productDTO.getIdCategory()).orElseThrow(() ->
//                new NotFoundException("ID Not Found"));
//        Product productToSave = Product.builder()
//                .name(productDTO.getName())
//                .sku(productDTO.getSku())
//                .price(productDTO.getPrice())
//                .stockQuantity(productDTO.getStockQuantity())
//                .description(productDTO.getDescription())
//                .category(category)
//                .build();
//        if(imageFile != null) {
//            String imagenPath = saveImage(imageFile);
//            productToSave.setImageUrl(imagenPath);
//        }
//        repo.save(productToSave);
//        return ResponseDTO.builder()
//                .status(201)
//                .message("Created Successfully")
//                .build();
//    }
//
//    @Override
//    public ResponseDTO updateProduct(ProductDTO productDTO, MultipartFile imageFile) {
//        Product existingProduct = repo.findById(productDTO.getIdProduct()).orElseThrow(()
//                -> new NotFoundException("ID Not Found"));
//        if(imageFile != null && !imageFile.isEmpty()) {
//            String imagenPath = saveImage(imageFile);
//            existingProduct.setImageUrl(imagenPath);
//        }
//        if(productDTO.getIdCategory() != null && productDTO.getIdCategory() > 0) {
//            Category category = categoryRepo.findById(productDTO.getIdProduct()).orElseThrow(()
//                    -> new NotFoundException("ID Not Found"));
//            existingProduct.setCategory(category);
//        }
//        Optional.ofNullable(productDTO.getName())
//                .filter(name -> !name.isBlank())
//                .ifPresent(existingProduct::setName);
//        Optional.ofNullable(productDTO.getSku())
//                .filter(sku -> !sku.isBlank())
//                .ifPresent(existingProduct::setSku);
//        Optional.ofNullable(productDTO.getDescription())
//                .filter(desc -> !desc.isBlank())
//                .ifPresent(existingProduct::setDescription);
//        // Para BigDecimal (precio)
//        Optional.ofNullable(productDTO.getPrice())
//                .filter(price -> price.compareTo(BigDecimal.ZERO) >= 0)
//                .ifPresent(existingProduct::setPrice);
//        // Para stock (Integer/Long)
//        Optional.ofNullable(productDTO.getStockQuantity())
//                .filter(stock -> stock >= 0)
//                .ifPresent(existingProduct::setStockQuantity);
//        repo.save(existingProduct);
//        return ResponseDTO.builder()
//                .status(200)
//                .message("Product successfully Updated")
//                .build();
//    }
//
//    @Override
//    public ResponseDTO getAllProducts() {
//        List<Product> products = repo.findAll(Sort.by(Sort.Direction.DESC, "idProduct"));
//        List<ProductDTO> productDTOs = mapper.map(products, new TypeToken<List<ProductDTO>>() {}.getType());
//        return ResponseDTO.builder()
//                .status(200)
//                .message("Success")
//                .products(productDTOs)
//                .build();
//    }
//
//    @Override
//    public ResponseDTO getProductById(Long id) {
//        Product product = repo.findById(id).orElseThrow(() -> new NotFoundException("ID Not Found"));
//        return ResponseDTO.builder()
//                .status(200)
//                .message("Success")
//                .product(mapper.map(product, ProductDTO.class))
//                .build();
//    }
//
//    @Override
//    public ResponseDTO deleteProduct(Long id) {
//        repo.findById(id).orElseThrow(() -> new NotFoundException("ID Not Found"));
//        repo.deleteById(id);
//        return ResponseDTO.builder()
//                .status(204)
//                .message("Deleted Successfully")
//                .build();
//    }
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
