package com.softwarelabs.InventorySystem.modules.accounting.transaction.service.impl;
//
//import com.softwarelabs.InventorySystem.exception.NameValueRequiredException;
//import com.softwarelabs.InventorySystem.exception.NotFoundException;
//import com.softwarelabs.InventorySystem.modules.catalog.entity.Product;
//import com.softwarelabs.InventorySystem.modules.catalog.repo.ProductRepo;
//import com.softwarelabs.InventorySystem.modules.catalog.supplier.entity.Supplier;
//import com.softwarelabs.InventorySystem.modules.catalog.supplier.repo.SupplierRepo;
//import com.softwarelabs.InventorySystem.modules.accounting.transaction.dto.TransactionDTO;
//import com.softwarelabs.InventorySystem.modules.accounting.transaction.dto.TransactionRequest;
//import com.softwarelabs.InventorySystem.modules.accounting.transaction.entity.Transaction;
//import com.softwarelabs.InventorySystem.modules.accounting.transaction.enums.TransactionStatus;
//import com.softwarelabs.InventorySystem.modules.accounting.transaction.enums.TransactionType;
//import com.softwarelabs.InventorySystem.modules.accounting.transaction.repo.TransactionRepo;
//import com.softwarelabs.InventorySystem.modules.accounting.transaction.service.TransactionService;
//import com.softwarelabs.InventorySystem.modules.user.dto.ResponseDTO;
//import com.softwarelabs.InventorySystem.modules.user.entity.User;
//import com.softwarelabs.InventorySystem.modules.user.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;

import com.softwarelabs.InventorySystem.modules.accounting.transaction.dto.TransactionDTO;
import com.softwarelabs.InventorySystem.modules.accounting.transaction.dto.TransactionRequest;
import com.softwarelabs.InventorySystem.modules.accounting.transaction.enums.TransactionStatus;
import com.softwarelabs.InventorySystem.modules.accounting.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public TransactionDTO restockInventory(TransactionRequest transactionRequest) {
        return null;
    }

    @Override
    public TransactionDTO sell(TransactionRequest transactionRequest) {
        return null;
    }

    @Override
    public TransactionDTO returnSupplier(TransactionRequest transactionRequest) {
        return null;
    }

    @Override
    public TransactionDTO getAllTransactions(int page, int size, String searchText) {
        return null;
    }

    @Override
    public TransactionDTO getTransactionById(Long id) {
        return null;
    }

    @Override
    public TransactionDTO getAllTransactionByMonthAndYear(int month, int year) {
        return null;
    }

    @Override
    public TransactionDTO updateTransactionStatus(Long idTransaction, TransactionStatus transactionStatus) {
        return null;
    }
//    private final TransactionRepo repo;
//    private final ModelMapper mapper;
//    private final SupplierRepo supplierRepo;
//    private final UserService userService;
//    private final ProductRepo productRepo;
//
//    @Override
//    public ResponseDTO restockInventory(TransactionRequest transactionRequest) {
//        Long idProduct = transactionRequest.getIdProduct();
//        Long idSupplier = transactionRequest.getIdSupplier();
//        Integer quantity = transactionRequest.getQuantity();
//        Optional.ofNullable(idProduct)
//                .orElseThrow(() -> new NameValueRequiredException("El ID no puede ser nulo"));
//        Product product = productRepo.findById(idProduct).orElseThrow(()
//                -> new NotFoundException("Product Not Found"));
//        Supplier supplier = supplierRepo.findById(idSupplier).orElseThrow(()
//                -> new NotFoundException("Supplier Not Found"));
//        User user = userService.getCurrentLoggedInUser();
//        product.setStockQuantity(product.getStockQuantity() + quantity);
//        productRepo.save(product);
//        Transaction transaction = Transaction.builder()
//                .transactionType(TransactionType.PURCHASE)
//                .transactionStatus(TransactionStatus.COMPLETED)
//                .product(product)
//                .user(user)
//                .totalProducts(quantity)
//                .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(quantity)))
//                .build();
//        repo.save(transaction);
//        return ResponseDTO.builder()
//                .status(200)
//                .message("Successfully")
//                .build();
//    }
//
//    @Override
//    public ResponseDTO sell(TransactionRequest transactionRequest) {
//        Long idProduct = transactionRequest.getIdProduct();
//        Integer quantity = transactionRequest.getQuantity();
//        Product product = productRepo.findById(idProduct).orElseThrow(()
//                -> new NotFoundException("Id Not Found"));
//        User user = userService.getCurrentLoggedInUser();
//        product.setStockQuantity(product.getStockQuantity() - quantity);
//        productRepo.save(product);
//        Transaction transaction = Transaction.builder()
//                .transactionType(TransactionType.SALE)
//                .transactionStatus(TransactionStatus.COMPLETED)
//                .product(product)
//                .user(user)
//                .totalProducts(quantity)
//                .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(quantity)))
//                .build();
//        repo.save(transaction);
//        return ResponseDTO.builder()
//                .status(200)
//                .message("Transaction Sold Successfully")
//                .build();
//    }
//
//    @Override
//    public ResponseDTO returnSupplier(TransactionRequest transactionRequest) {
//        Long productId = transactionRequest.getIdProduct();
//        Long supplierId = transactionRequest.getIdSupplier();
//        Integer quantity = transactionRequest.getQuantity();
//        if (supplierId == null) throw new NameValueRequiredException("Supplier Id id Required");
//        Product product = productRepo.findById(productId)
//                .orElseThrow(()-> new NotFoundException("Product Not Found"));
//        Supplier supplier = supplierRepo.findById(supplierId)
//                .orElseThrow(()-> new NotFoundException("Supplier Not Found"));
//        User user = userService.getCurrentLoggedInUser();
//        product.setStockQuantity(product.getStockQuantity() - quantity);
//        productRepo.save(product);
//        Transaction transaction = Transaction.builder()
//                .transactionType(TransactionType.RETURN_TO_SUPPLIER)
//                .transactionStatus(TransactionStatus.PROCESSING)
//                .product(product)
//                .user(user)
//                .supplier(supplier)
//                .totalProducts(quantity)
//                .totalPrice(BigDecimal.ZERO)
//                .description(transactionRequest.getDescription())
//                .build();
//        repo.save(transaction);
//        return ResponseDTO.builder()
//                .status(200)
//                .message("Transaction Returned Successfully Initialized")
//                .build();
//    }
//
//    @Override
//    public ResponseDTO getAllTransactions(int page, int size, String searchText) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "idTransaction"));
//        Page<Transaction> transactionPage = repo.searchTransactions(searchText, pageable);
//        List<TransactionDTO> transactionDTOS = mapper
//                .map(transactionPage.getContent(), new TypeToken<List<TransactionDTO>>() {}.getType());
//        transactionDTOS.forEach(transactionDTOItem -> {
//            transactionDTOItem.setUser(null);
//            transactionDTOItem.setProduct(null);
//            transactionDTOItem.setSupplier(null);
//        });
//        return ResponseDTO.builder()
//                .status(200)
//                .message("success")
//                .transactions(transactionDTOS)
//                .build();
//    }
//
//    @Override
//    public ResponseDTO getTransactionById(Long id) {
//        Transaction transaction = repo.findById(id)
//                .orElseThrow(()-> new NotFoundException("Transaction Not Found"));
//        TransactionDTO transactionDTO = mapper.map(transaction, TransactionDTO.class);
//        transactionDTO.getUser().setTransactions(null);
//        return ResponseDTO.builder()
//                .status(200)
//                .message("success")
//                .transaction(transactionDTO)
//                .build();
//    }
//
//    @Override
//    public ResponseDTO getAllTransactionByMonthAndYear(int month, int year) {
//        List<Transaction> transactions = repo.findAllByMonthAndYear(month, year);
//        List<TransactionDTO> transactionDTOS = mapper
//                .map(transactions, new TypeToken<List<TransactionDTO>>() {}.getType());
//        transactionDTOS.forEach(transactionDTOItem -> {
//            transactionDTOItem.setUser(null);
//            transactionDTOItem.setProduct(null);
//            transactionDTOItem.setSupplier(null);
//        });
//        return ResponseDTO.builder()
//                .status(200)
//                .message("success")
//                .transactions(transactionDTOS)
//                .build();
//    }
//
//    @Override
//    public ResponseDTO updateTransactionStatus(Long idTransaction, TransactionStatus transactionStatus) {
//        Transaction existingTransaction = repo.findById(idTransaction)
//                .orElseThrow(()-> new NotFoundException("Transaction Not Found"));
//        existingTransaction.setTransactionStatus(transactionStatus);
//        existingTransaction.setUpdatedAt(LocalDateTime.now());
//        repo.save(existingTransaction);
//        return ResponseDTO.builder()
//                .status(200)
//                .message("Transaction Status Successfully Updated")
//                .build();
//    }
}
