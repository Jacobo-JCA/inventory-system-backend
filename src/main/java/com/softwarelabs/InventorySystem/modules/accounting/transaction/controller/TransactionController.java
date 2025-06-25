package com.softwarelabs.InventorySystem.modules.accounting.transaction.controller;

import com.softwarelabs.InventorySystem.modules.accounting.transaction.dto.TransactionDTO;
import com.softwarelabs.InventorySystem.modules.accounting.transaction.dto.TransactionRequest;
import com.softwarelabs.InventorySystem.modules.accounting.transaction.enums.TransactionStatus;
import com.softwarelabs.InventorySystem.modules.accounting.transaction.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/transactions")
@RestController
public class TransactionController {
    private final TransactionService service;

    @PostMapping("/purchase")
    public ResponseEntity<TransactionDTO> restockInventory(@RequestBody @Valid TransactionRequest transactionRequest) {
        return ResponseEntity.ok(service.restockInventory(transactionRequest));
    }

    @PostMapping("/sell")
    public ResponseEntity<TransactionDTO> sell(@RequestBody @Valid TransactionRequest transactionRequest) {
        return ResponseEntity.ok(service.sell(transactionRequest));
    }

    @PostMapping("/return")
    public ResponseEntity<TransactionDTO> returnToSupplier(@RequestBody @Valid TransactionRequest transactionRequest) {
        return ResponseEntity.ok(service.returnSupplier(transactionRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<TransactionDTO> getAllTransactions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1000") int size,
            @RequestParam(required = false) String searchText
    ) {
        return ResponseEntity.ok(service.getAllTransactions(page, size, searchText));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTransactionById(id));
    }

    @GetMapping("/by-month-year")
    public ResponseEntity<TransactionDTO> getAllTransactionByMonthAndYear(
            @RequestParam int month,
            @RequestParam int year
    ) {
        return ResponseEntity.ok(service.getAllTransactionByMonthAndYear(month, year));
    }

    @PutMapping("/update/{transactionId}")
    public ResponseEntity<TransactionDTO> updateTransactionStatus(
            @PathVariable Long transactionId,
            @RequestBody @Valid TransactionStatus status) {
        System.out.println("ID IS: " + transactionId);
        System.out.println("Status IS: " + status);
        return ResponseEntity.ok(service.updateTransactionStatus(transactionId, status));
    }
}