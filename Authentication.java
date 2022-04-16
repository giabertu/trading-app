
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Authentication {
    public static File login;
   
    public static void createFile(User user)throws IOException{
        if (!new File("login.txt").exists()){
            login = new File("login.txt");
            PrintWriter outputStream = new PrintWriter(new FileWriter(login));
        
            outputStream.println(user.getName() + "\n" + user.getPw());
            outputStream.close();
            return;
        }
        System.out.println("You are trying to override login details. Not allowed");
    }

    public static boolean isAuthentic(User user)throws IOException{
        if (new File("login.txt").exists()){
            login = new File("login.txt");
            BufferedReader inputStream = new BufferedReader(new FileReader(login));
            if(inputStream.readLine().equals(user.getName()) && inputStream.readLine().equals(user.getPw())){
                inputStream.close();
                return true;
            }
            inputStream.close();
        }
        return false;
    }

}
