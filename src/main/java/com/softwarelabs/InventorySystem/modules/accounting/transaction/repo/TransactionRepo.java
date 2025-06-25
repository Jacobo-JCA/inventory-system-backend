package com.softwarelabs.InventorySystem.modules.accounting.transaction.repo;

import com.softwarelabs.InventorySystem.modules.billing.common.repo.GenericRepo;
import com.softwarelabs.InventorySystem.modules.accounting.transaction.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepo extends GenericRepo<Transaction, Long> {
    @Query("SELECT t FROM Transaction t " +
    "WHERE YEAR(t.createdAt) = :year AND MONTH(t.createdAt)= :month")
    List<Transaction> findAllByMonthAndYear(@Param("month") int month, @Param("year") int year);

    @Query("SELECT t FROM Transaction t " +
            "LEFT JOIN t.product p " +
            "WHERE (:searchText IS NULL OR " +
            "       LOWER(t.description) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "       LOWER(t.transactionStatus) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "       LOWER(p.name) LIKE LOWER(CONCAT('%', :searchText, '%')))")
    Page<Transaction> searchTransactions(@Param("searchText") String searchText, Pageable pageable);
}
