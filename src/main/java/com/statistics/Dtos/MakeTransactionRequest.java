package com.statistics.Dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeTransactionRequest {
    private String amount;


    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" , timezone = "UTC")
    private String timeStamp;
}
