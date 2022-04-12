package service;

import java.io.IOException;
import java.math.BigDecimal;


import model.StockWrapper;

import yahoofinance.YahooFinance;


public class StockService {
    
    public StockWrapper findStock(String ticker) throws IOException{
        return new StockWrapper(YahooFinance.get(ticker));
        
    }

    public BigDecimal findPrice(final StockWrapper stock) throws IOException{
        return stock.getStock().getQuote(true).getPrice();
    }

}
