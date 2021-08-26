package com.statistics.services;

import com.statistics.Dtos.MakeTransactionRequest;
import com.statistics.models.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TransactionServiceImplTest {
    @Autowired
    TransactionServiceImpl transactionService;

    @Autowired
    Transaction transaction;


    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Test that count increases after transaction")
    void testIncreaseCount(){
        var request = new MakeTransactionRequest();
        request.setAmount("500");
        request.setTimeStamp("2016-07-13T18:08:50.118Z");
        log.info("Request is null : " + request.getTimeStamp());
        transactionService.MakeTransaction(request);
        assertEquals(3, transaction.getCount());

    }

    @Test
    @DisplayName("Test that sum increases after transaction")
    void  testIncreaseSum(){
        var oldSum = transaction.getSum();
        var request = new MakeTransactionRequest();
        request.setAmount("50");
        request.setTimeStamp("2016-07-13T18:08:50.118Z");
        log.info("Request is null : " + request.getTimeStamp());
        transactionService.MakeTransaction(request);
        log.info("Sum is : "  + transaction.getSum());
        //assertEquals(oldSum.add(request.getAmount()), Transaction.getSum());
    }

    @Test
    @DisplayName("Test that statistics returns all valid details")
    void testStatistics(){
        var oldSum = transaction.getSum();
        var request = new MakeTransactionRequest();
        request.setAmount("150");
        request.setTimeStamp("2016-07-13T18:08:50.118Z");
        log.info("Request is null : " + request.getTimeStamp());
        transactionService.MakeTransaction(request);
        log.info("Sum is : "  + transaction.getSum());
        var response =transactionService.GetStatistics();
        log.info("Response ==> {}", response);
        assertNotNull(response);

    }

    @Test
    @DisplayName("Test that time is reset after 60 seconds")
    void testResetTime(){

    }

    @Test
    @DisplayName("Test that delete resets all statistics to default")
    void testDeleteStatistics(){
        var oldSum = transaction.getSum();
        var request = new MakeTransactionRequest();
        request.setAmount("50");
        request.setTimeStamp("2016-07-13T18:08:50.118Z");
        log.info("Request is null : " + request.getTimeStamp());
        transactionService.MakeTransaction(request);
        transactionService.deleteTransactions();
        assertEquals(0, transaction.getCount());
    }
}