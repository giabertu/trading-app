import javax.swing.JOptionPane;

public class Account{

    private int freeBalance;
    private Portfolio portfolio;
    
    public Account(){
        freeBalance = 0;
    }

    public Account(int amount){
        freeBalance = amount;
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
}