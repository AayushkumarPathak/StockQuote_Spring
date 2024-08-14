package com.stock.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stock.stock.entities.StockQuote;
import com.stock.stock.services.StockService;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/")
    public String home() {
        try {
            return "Stock Home API\n\n TEST:  http://localhost:8020/api/stocks/quote/{symbol}\n http://localhost:8020/api/stocks/quotes?symbols=AAPL,MSFT,GOOGL";

        } catch (Exception e) {
            e.printStackTrace();
            return "Internal server error";
        }
    }

    @GetMapping("/quote/{symbol}")
    public StockQuote getQuoteBySymbol(@PathVariable String symbol) {
        try {
            return stockService.getQuoteBySymbol(symbol);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/quotes")
    public List<StockQuote> getStockBatch(@RequestParam List<String> symbols) {
        try {
            return stockService.getListOfQuotes(symbols);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
