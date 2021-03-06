import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;


public class App{

    public static void main(String[] args) throws IOException {
      LoginFrame loginFrame = new LoginFrame();
      addLoginActionListener(loginFrame);

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

            if(e.getSource() == frame.buttonDeposit){
              try{
                int amount = Validation.inputInt(frame.depositField.getText());

                user.getAccount().deposit(amount);
                frame.displayAccount(frame.accountInfo, user);
              }
              catch (Exception exc){JOptionPane.showMessageDialog(null, "Invalid input. Try again");}
            }
        }
      });

      //add the change to the account displayed inside the deposit and withdraw methods of account.


      frame.addButtonWithdrawActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == frame.buttonWithdraw){
              try{
                int amount = Validation.inputInt(frame.withdrawField.getText());
                user.getAccount().withdraw(amount);
                frame.displayAccount(frame.accountInfo, user);
              }
              catch (Exception exc){JOptionPane.showMessageDialog(null, "Invalid input. Try again");}
            }
        }
      });

      frame.addButtonSearchActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          if (e.getSource() == frame.buttonSearch || e.getSource() == frame.buttonCryptoSearch){

            String ticker = "";
            AssetWrapper asset = new AssetWrapper(null);
            try{
              if (e.getSource() == frame.buttonSearch){
                System.out.println("I was pressed");
                ticker = Validation.inputString(frame.searchField.getText());
                asset = new AssetService().findAsset(ticker);
                frame.displayAsset(frame.assetLabel, asset);
              }
              else if (e.getSource() == frame.buttonCryptoSearch) {
                ticker = Validation.inputString(frame.searchCryptoField.getText()) + "-USD";
                System.out.println(ticker);
                asset = new AssetService().findCrypto(ticker);
              }

              frame.displayAsset(frame.assetLabel, asset);
            }
            catch(DigitOnlyException | IOException dException){JOptionPane.showMessageDialog(null, "Invalid ticker. Try again");}
          }
        }
      });

      frame.AddButtonBuyActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          if (e.getSource() == frame.buttonBuy){

            double amount = Validation.inputDouble(frame.buyField.getText());
            try {

              int output = user.getAccount().buyAsset(frame.currentAsset, amount);
              if (output == 1){

                frame.displayAccount(frame.accountInfo, user);
                frame.displayPortfolio(frame.portfolioLabel, user);
                JOptionPane.showMessageDialog(null, "Purchase successful! You just bought some " + frame.currentAsset.getName() + ".", "Purchase Information", JOptionPane.INFORMATION_MESSAGE);
              }
            }
            catch (IOException e1) {JOptionPane.showMessageDialog(null, "Invalid buy. Try again", "Purchase Error", JOptionPane.ERROR_MESSAGE);}
          }
        }
      });

      frame.AddButtonSellActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
          if (e.getSource()== frame.buttonSell){
            double amount = Validation.inputDouble(frame.sellField.getText());
            try {
              int output = user.getAccount().sellAsset(frame.currentAsset, amount);
              if (output == 1){
                frame.displayAccount(frame.accountInfo, user);
                frame.displayPortfolio(frame.portfolioLabel, user);
                JOptionPane.showMessageDialog(null, "Sale successful! You just sold some " +
                frame.currentAsset.getName() + ".", "Sale Information", JOptionPane.INFORMATION_MESSAGE);
              }
            } catch (IOException e1) {JOptionPane.showMessageDialog(null, "Invalid sale. Try again");}
          }
        }
      });
    }

}