import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Authentication {
    public static File login;
   
    public static void createFile(String username, String pw)throws IOException{
        if (!login.exists()){
        PrintWriter outputStream = new PrintWriter(new FileWriter(login));
        
        outputStream.println(username + "\n" + pw);
        outputStream.close();
        return;
        }
        System.out.println("You are trying to recreate override login details. Not allowed");
    }

    public static boolean isAuthentic(String username, String pw)throws IOException{
        if (login.exists()){
            BufferedReader inputStream = new BufferedReader(new FileReader(login));
            if(inputStream.readLine().equals(username) && inputStream.readLine().equals(pw)){
            return true;
            }
        }
        return false;
    }

}
