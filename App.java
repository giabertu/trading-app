import view.AppFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.JOptionPane;

import model.StockWrapper;
import service.StockService;
public class App{

    public static void main(String[] args) throws IOException {

      LoginFrame loginFrame = new LoginFrame();
      addLoginActionListener(loginFrame);
      AppFrame frame = loginFrame.newFrame;


      StockService stockService = new StockService();
		  StockWrapper stock = stockService.findStock("AAPL");
		  System.out.println(stock.getStock());
		  BigDecimal stockPrice = stockService.findPrice(stock);
		  System.out.println(stockPrice);


    }

    public static void addLoginActionListener(LoginFrame loginFrame){
      loginFrame.addSubmitActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          if (e.getSource() == loginFrame.submitButton){
            User user = new User(loginFrame.usernameField.getText(), loginFrame.pwField.getText());
            if(!new File("login.txt").exists()){
              try{
                Authentication.createFile(user);
                JOptionPane.showMessageDialog(null, "Account Created. Please remember your login details.", "Account Information", JOptionPane.INFORMATION_MESSAGE);
                loginFrame.setVisible(false);
                AppFrame frame = new AppFrame();
                loginFrame.newFrame = frame;
                addActionListeners(frame,user);
              }
              catch(Exception exception){}
            }
            else{
              try {
                if (Authentication.isAuthentic(user)){
                  JOptionPane.showMessageDialog(null, "Authentication successful!", "Login Information", JOptionPane.INFORMATION_MESSAGE);
                  loginFrame.setVisible(false);
                  AppFrame frame = new AppFrame();
                  loginFrame.newFrame = frame;
                  addActionListeners(frame, user);
                }
                else{
                  JOptionPane.showMessageDialog(null, "Wrong Login Details. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                  System.exit(0);
                }
              } catch (IOException e1) {}
            }
          }
        }
      });
    }

    public static void addActionListeners(AppFrame frame, User user){

      frame.addButtonDepositActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("I was pressed");
            if(e.getSource() == frame.buttonDeposit){
              try{
                int amount = Validation.inputInt(frame.depositField.getText());
                System.out.println(amount);
                user.getAccount().deposit(amount);
              }
              catch (Exception exc){JOptionPane.showMessageDialog(null, "Invalid input. Try again");}
            }
        }
      });

      frame.addButtonWithdrawActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("I was pressed");
            if(e.getSource() == frame.buttonWithdraw){
              try{
                int amount = Validation.inputInt(frame.depositField.getText());
                System.out.println(amount);
                user.getAccount().withdraw(amount);
              }
              catch (Exception exc){JOptionPane.showMessageDialog(null, "Invalid input. Try again");}
            }
        }
      });

    }

}