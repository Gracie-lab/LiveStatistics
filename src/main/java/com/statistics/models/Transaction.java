package com.statistics.models;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Service
public class Transaction {
    private LocalDateTime startTimeStamp = LocalDateTime.MIN;

    private BigDecimal sum = new BigDecimal(0);
    private BigDecimal avg = new BigDecimal(0);
    private BigDecimal max = new BigDecimal(0);
    private BigDecimal min = new BigDecimal(0);
    private long count;

//    public static LocalDateTime getStartTimeStamp() {
//        return startTimeStamp;
//    }
//
//    public static void setStartTimeStamp(LocalDateTime startTimeStamp) {
//        Transaction.startTimeStamp = startTimeStamp;
//    }
//
//    public static BigDecimal getSum() {
//        return sum;
//    }
//
//    public static void setSum(BigDecimal sum) {
//        Transaction.sum = sum;
//    }
//
//    public static BigDecimal getAvg() {
//        return avg;
//    }
//
//    public static void setAvg(BigDecimal avg) {
//        Transaction.avg = avg;
//    }
//
//    public static BigDecimal getMax() {
//        return max;
//    }
//
//    public static void setMax(BigDecimal max) {
//        Transaction.max = max;
//    }
//
//    public static BigDecimal getMin() {
//        return min;
//    }
//
//    public static void setMin(BigDecimal min) {
//        Transaction.min = min;
//    }
//
//    public static long getCount() {
//        return count;
//    }
//
//    public static void setCount(long count) {
//        Transaction.count = count;
//    }


}
