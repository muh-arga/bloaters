package longParameterFix;

public class Wallet {
    private int balance;
    
    public Wallet(){
        this.balance = 0;
    }
    
    public void add(int amount){
        balance += amount;
    }
    
    public void reduce(int amount){
        balance -= amount;
    }
    
    public int getBalance(){
        return this.balance;
    }
}
