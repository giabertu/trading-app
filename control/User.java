
package control;
public class User {

    private final String name;
    private final String pw;
    private Account account;

    public User(String name, String pw){
        this.name = name;
        account = new Account(0);
        this.pw = pw;
    }

    public String getName(){
        return name;
    }
    public String getPw(){
        return pw;
    }
    
    public Account getAccount(){
        return account;
    }

}
