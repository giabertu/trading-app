package service;

import java.io.IOException;
import java.math.BigDecimal;
//import java.util.List;
//import java.util.stream.Collectors;

import model.StockWrapper;

import yahoofinance.YahooFinance;


public class StockService {
    
    //private final RefreshService refreshService;

    public StockWrapper findStock(String ticker) throws IOException{
        return new StockWrapper(YahooFinance.get(ticker));
        
    }

    public BigDecimal findPrice(final StockWrapper stock) throws IOException{
        return stock.getStock().getQuote(true).getPrice();
    }

    //public List<StockWrapper> findStocks(final List<String> tickers){
    //   return tickers.stream().map(this::findStock).filter(Objects::nonNull).collet(Collectors.toList());
    //}


}
