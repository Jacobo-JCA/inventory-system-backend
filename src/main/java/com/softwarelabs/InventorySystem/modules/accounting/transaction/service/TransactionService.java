package com.softwarelabs.InventorySystem.modules.accounting.transaction.service;

import com.softwarelabs.InventorySystem.modules.accounting.transaction.dto.TransactionRequest;
import com.softwarelabs.InventorySystem.modules.accounting.transaction.enums.TransactionStatus;
import com.softwarelabs.InventorySystem.modules.user.dto.ResponseDTO;

public interface TransactionService {
    ResponseDTO restockInventory(TransactionRequest transactionRequest);
    ResponseDTO sell(TransactionRequest transactionRequest);
    ResponseDTO returnSupplier(TransactionRequest transactionRequest);
    ResponseDTO getAllTransactions(int page, int size, String searchText);
    ResponseDTO getTransactionById(Long id);
    ResponseDTO getAllTransactionByMonthAndYear(int month, int year);
    ResponseDTO updateTransactionStatus(Long idTransaction, TransactionStatus transactionStatus);
}
