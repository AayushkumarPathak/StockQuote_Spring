package com.stock.stock.services;

import java.util.List;

import com.stock.stock.entities.StockQuote;

public interface StockService {
    StockQuote getQuoteBySymbol(String symbol);
    List<StockQuote> getListOfQuotes(List<String> symbols);
    
}
