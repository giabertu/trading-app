package control;
import javax.swing.JOptionPane;

public class Validation {
   
    public static int inputInt(String message){
        int input = Integer.parseInt(message);
        while (input < 0){
          input = Integer.parseInt(JOptionPane.showInputDialog(null, "The number you inserted is not valid. Try again here."));
        }
        return input;
      }
}
