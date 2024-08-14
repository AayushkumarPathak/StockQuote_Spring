package com.stock.stock.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.stock.entities.StockQuote;
import com.stock.stock.helper.RestClient;

@Service
public class StockServiceImpl implements StockService {

    @Value("${api.key}")
    private String apiKey;

    private RestClient restClient;

    public StockServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    private String buildUrl(String symbol) {
        return "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey;
    }

    @Override
    public StockQuote getQuoteBySymbol(String symbol) {
        String url = buildUrl(symbol);
        String response = restClient.getStockData(url);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(response);
            JsonNode globalQuote = root.path("Global Quote");

            double price = globalQuote.path("05. price").asDouble();
            double change = globalQuote.path("09. change").asDouble();
            double percentageChange = Double
                    .parseDouble(globalQuote.path("10. change percent").asText().replace("%", ""));

            return new StockQuote(symbol, price, change, percentageChange, LocalDateTime.now());
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse stock data", e);
        }
    }

    @Override
    public List<StockQuote> getListOfQuotes(List<String> symbols) {
        List<StockQuote> stockQuotes = new ArrayList<>();

    for (String symbol : symbols) {
        try {
            StockQuote stockQuote = getQuoteBySymbol(symbol);
            stockQuotes.add(stockQuote);
        } catch (Exception e) {
            System.out.println("Failed to retrieve stock data for symbol not found: " + symbol);
            e.printStackTrace();
        }
    }

    return stockQuotes;
}

}
