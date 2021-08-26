package com.statistics.services;

import com.statistics.Dtos.MakeTransactionRequest;
import com.statistics.models.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    void MakeTransaction(MakeTransactionRequest request);
    Transaction GetStatistics();
    void deleteTransactions();
}
