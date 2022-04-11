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

    public static double inputDouble(String message){
      double input = Double.parseDouble(message);
      while (input < 0){
        input = Double.parseDouble(JOptionPane.showInputDialog(null, "The number you inserted is not valid. Try again here."));
      }
      return input;
  }



    public static String inputString(String message){
      if(message.matches("[0-9]+")){
        throw new DigitOnlyException();
      }
      return message.trim().toUpperCase();
    }
  
}
