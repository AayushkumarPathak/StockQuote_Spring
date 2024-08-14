package com.stock.stock.entities;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StockQuote {
    private String symbol;
    private double price;
    private double change;
    private double percentChange;
    private LocalDateTime timeStamp;


    
}
