package control;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.AssetWrapper;

public class Account{

    private int freeBalance;
    private ArrayList<AssetSharePair> portfolio;
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
            JOptionPane.showMessageDialog(null, "You are trying to withdraw more than you hold.", "Withdraw Error", JOptionPane.ERROR_MESSAGE);
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

    public int buyAsset(AssetWrapper stock, double amount) throws IOException{
        AssetSharePair stockGiven = new AssetSharePair(stock, new BigDecimal(0)); 
        
        if(amount > freeBalance){
            JOptionPane.showMessageDialog(null, "You don't have enough free funds for this transation", "Purchase Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else if(portfolio.contains(stockGiven)){
            portfolio.get(portfolio.indexOf(new AssetSharePair(stock, new BigDecimal(0)))).addShares(amount);;
            return 1;
        }
        AssetSharePair stockOwned = new AssetSharePair(stock, new BigDecimal(amount).divide(stock.getPrice(), 2, RoundingMode.HALF_UP));
        portfolio.add(stockOwned);
        freeBalance -= amount;
        return 1;
    }

    public int sellAsset(AssetWrapper stock, double amount) throws IOException{
        AssetSharePair stockGiven = new AssetSharePair(stock, new BigDecimal(0)); 
        BigDecimal bdAmount = new BigDecimal(amount);
        int indexOfStock = -1;
        for (int i = 0; i < portfolio.size(); i ++){
            if (portfolio.get(i).equals(stockGiven)){
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
            portfolio.remove(stockGiven);
            freeBalance += amount;
            return 1;
        }
        portfolio.get(indexOfStock).removeShares(amount);
        freeBalance += amount;
        return 1;
    }

    public String portfolioToString(){
        String result = "Stocks owned:";
        for (int i=0; i < portfolio.size(); i++){
            result += " " + portfolio.get(i).toString() + ";";
        }
        return result;
    }
}