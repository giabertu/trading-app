public class User {

    private final String name;
    private Account account;

    public User(String name){
        this.name = name;
        account = new Account(0);
    }

    public String getName(){
        return name;
    }

}
