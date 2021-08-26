package com.statistics.services;

import com.statistics.Dtos.GetStatisticsResponse;
import com.statistics.Dtos.MakeTransactionRequest;
import com.statistics.models.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
public class TransactionServiceImpl{

    @Autowired
    Transaction transaction;


    ModelMapper modelMapper = new ModelMapper();

    public boolean MakeTransaction(MakeTransactionRequest request) {
        LocalDateTime startTime = transaction.getStartTimeStamp();
        LocalDateTime parsedDate = LocalDateTime.parse(request.getTimeStamp(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        log.info("Parsed date --> {}", parsedDate);
        BigDecimal amount = new BigDecimal(request.getAmount());
        long diff = ChronoUnit.SECONDS.between(startTime, parsedDate);
        boolean isDiffGreaterThan60 = false;
        log.info("The start time : " + startTime);
        if( diff > 60){
            transaction.setStartTimeStamp(parsedDate);
            diff = ChronoUnit.SECONDS.between(transaction.getStartTimeStamp(), parsedDate);
            deleteTransactions();
            isDiffGreaterThan60 = true;
            //reset other fields
        }
        log.info("Difference between parsed date and start date --> {}", diff);

        if(diff <= 60){
            transaction.setCount(transaction.getCount()+1);
            transaction.setSum(transaction.getSum().add(amount));
            if(transaction.getMax().compareTo(amount) < 0){
                transaction.setMax(amount);
            }
            if(transaction.getMin().compareTo(amount) > 0){
                transaction.setMin(amount);
            }
            transaction.setAvg(transaction.getSum().divide(amount));
        }

        return isDiffGreaterThan60;
    }

//    private BigDecimal roundUpper(BigDecimal a){
//        double roundOff = Math.round(a * 100.0) / 100.0;
//    }

    public GetStatisticsResponse GetStatistics() {

        GetStatisticsResponse response = new GetStatisticsResponse(transaction.getSum(), transaction.getAvg(),
                transaction.getMax(), transaction.getMin(), transaction.getCount());
        return response;
    }

    public  void deleteTransactions() {
        transaction.setCount(0);
        transaction.setAvg(new BigDecimal(0));
        transaction.setMin(new BigDecimal(0));
        transaction.setSum(new BigDecimal(0));
        transaction.setMax(new BigDecimal(0));
    }
}
