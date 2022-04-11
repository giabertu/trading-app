package control;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public int buyStock(StockWrapper stock, double amount) throws IOException{
        if(amount > freeBalance){
            JOptionPane.showMessageDialog(null, "You don't have enough free funds for this transation", "Purchase Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else if(portfolio.contains(stock)){
            portfolio.get(portfolio.indexOf(stock)).addShares(amount);;
            return 1;
        }
        StockSharePair stockOwned = new StockSharePair(stock, new BigDecimal(amount).divide(stock.getPrice(), 2, RoundingMode.HALF_UP));
        portfolio.add(stockOwned);
        freeBalance -= amount;
        return 1;
    }

    public int sellStock(StockWrapper stock, double amount) throws IOException{
        BigDecimal bdAmount = new BigDecimal(amount);
        int indexOfStock = -1;
        for (int i = 0; i < portfolio.size(); i ++){
            if (portfolio.get(i).equals(new StockSharePair(stock, new BigDecimal(0)))){
                indexOfStock = i;
                break;
            }
        }
        BigDecimal valueSharesOwned = portfolio.get(indexOfStock).getTotValue(); 
        if (bdAmount.compareTo(valueSharesOwned) == 1){
            JOptionPane.showMessageDialog(null, "You don't have enough shares to sell", "Sale Error", JOptionPane.ERROR_MESSAGE);
            return -1; 
        }
        else if(bdAmount.compareTo(valueSharesOwned) == 0){
            portfolio.remove(stock);
            freeBalance += amount;
            return 1;
        }
        portfolio.get(indexOfStock).removeShares(amount);
        freeBalance += amount;
        return 1;
    }
    //create method to calculate totBalance 
}