package model;

import java.time.LocalDateTime;
import yahoofinance.Stock;

public class StockWrapper {
    private final Stock stock;
    private final LocalDateTime lastAccessedTime;

    public StockWrapper(Stock stock){
        this.stock = stock;
        lastAccessedTime = LocalDateTime.now();
    }

    public Stock getStock(){
        return stock;
    }

    public LocalDateTime getLastAccessed() {
        return lastAccessedTime;
    }
    
}
