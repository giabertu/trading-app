import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.StockWrapper;
import service.StockService;

public class Account{

    private int freeBalance;
    private ArrayList<StockSharePair> portfolio;
    
    public Account(){
        freeBalance = 0;
        portfolio = new ArrayList<>();
    }

    public Account(int amount){
        freeBalance = amount;
        portfolio = new ArrayList<>();
    }

    public int getFreeBalance(){
        return freeBalance;
    }

    public void deposit(int amount){
        freeBalance += amount;
    }

    public void withdraw(int amount){
        if(amount > freeBalance){
            JOptionPane.showInputDialog(null, "You are trying to withdraw more than you hold.");
            return;
        }
        freeBalance -= amount;
    }

    public void buyStock(StockWrapper stock, double amount) throws IOException{
        if(amount > freeBalance){
            JOptionPane.showMessageDialog(null, "You don't have enough free funds for this transation", "Purchase Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            StockSharePair stockOwned = new StockSharePair(stock, new StockService().findPrice(stock).divide(new BigDecimal(amount)));
            portfolio.add(stockOwned);
        } 
    }

    //create sellStock method
}