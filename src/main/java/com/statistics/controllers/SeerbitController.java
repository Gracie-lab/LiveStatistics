package com.statistics.controllers;

import com.statistics.Dtos.GetStatisticsResponse;
import com.statistics.Dtos.MakeTransactionRequest;
import com.statistics.services.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeerbitController {

    @Autowired
    TransactionServiceImpl transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<?> transactions(MakeTransactionRequest request){
        boolean response = transactionService.MakeTransaction(request);
        return new ResponseEntity<>(response ? HttpStatus.NO_CONTENT : HttpStatus.CREATED  );

    }

    @GetMapping("/statistics")
    public ResponseEntity<?> statistics(){
        GetStatisticsResponse response = transactionService.GetStatistics();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
