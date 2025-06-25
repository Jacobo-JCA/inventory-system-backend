package com.softwarelabs.InventorySystem.modules.accounting.transaction.service;

import com.softwarelabs.InventorySystem.modules.accounting.transaction.dto.TransactionDTO;
import com.softwarelabs.InventorySystem.modules.accounting.transaction.dto.TransactionRequest;
import com.softwarelabs.InventorySystem.modules.accounting.transaction.enums.TransactionStatus;

public interface TransactionService {
    TransactionDTO restockInventory(TransactionRequest transactionRequest);
    TransactionDTO sell(TransactionRequest transactionRequest);
    TransactionDTO returnSupplier(TransactionRequest transactionRequest);
    TransactionDTO getAllTransactions(int page, int size, String searchText);
    TransactionDTO getTransactionById(Long id);
    TransactionDTO getAllTransactionByMonthAndYear(int month, int year);
    TransactionDTO updateTransactionStatus(Long idTransaction, TransactionStatus transactionStatus);
}
