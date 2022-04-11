package model;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import service.StockService;
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

    public BigDecimal getPrice() throws IOException{
        return new StockService().findPrice(this);
    }

    public LocalDateTime getLastAccessed() {
        return lastAccessedTime;
    }

    public String getName() {
        return stock.getName();
    }
/**
 * 
 * public void createChart(){
        JFreeChart chart = new JFreeChart();
    }

    private XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();

        ds.addSeries("series1", data);

        return ds;
    }
 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
   
    
}
