package control;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.StockWrapper;
import service.StockService;

public class Account{

    private int freeBalance;
    private ArrayList<StockSharePair> portfolio;
    private BigDecimal totBalance;
    
    public Account(){
        freeBalance = 0;
        portfolio = new ArrayList<>();
        totBalance = new BigDecimal(freeBalance);
    }

    public Account(int amount){
        freeBalance = amount;
        portfolio = new ArrayList<>();
        totBalance = new BigDecimal(freeBalance);
    }

    public int getFreeBalance(){
        return freeBalance;
    }

    public BigDecimal getTotBalance(){
        calculateTotBalance();
        return totBalance;
    }

    public void deposit(int amount){
        freeBalance += amount;
        totBalance.add(new BigDecimal(amount));
    }

    public void withdraw(int amount){
        if(amount > freeBalance){
            JOptionPane.showInputDialog(null, "You are trying to withdraw more than you hold.");
            return;
        }
        freeBalance -= amount;
        totBalance.subtract(new BigDecimal(amount));
    }

    public void calculateTotBalance(){
        totBalance = new BigDecimal(0);
        for (int i=0; i < portfolio.size(); i++){
            totBalance = totBalance.add(portfolio.get(i).getTotValue());
        }
        totBalance = totBalance.add(new BigDecimal(freeBalance));
    }

    public void buyStock(StockWrapper stock, double amount) throws IOException{
        if(amount > freeBalance){
            JOptionPane.showMessageDialog(null, "You don't have enough free funds for this transation", "Purchase Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i = 0; i < portfolio.size(); i++){
            if (stock.getStock().getName().equals((portfolio.get(i).getStock()).getName())){
                portfolio.get(i).addShares(amount);
                return;
            }
        }
        StockSharePair stockOwned = new StockSharePair(stock, new StockService().findPrice(stock).divide(new BigDecimal(amount)));
        portfolio.add(stockOwned);
    }

    //create sellStock method
    //create method to calculate totBalance 
}