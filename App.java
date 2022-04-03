import view.AppFrame;
import view.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
public class App{

    public static void main(String[] args) {
      

      AppFrame frame = new AppFrame();

      addActionListeners(frame);
    }

    public static void addActionListeners(AppFrame frame){

      frame.addButtonDepositActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("I was pressed");
            if(e.getSource() == frame.buttonDeposit){
              int input = Validation.inputInt(frame.depositField.getText());
              System.out.println(input);
            }
        }
      });

      frame.addButtonWithdrawActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("I was pressed");
            if(e.getSource() == frame.buttonWithdraw){
              int input = Validation.inputInt(frame.depositField.getText());
              System.out.println(input);
            }
        }
      });

    }

}