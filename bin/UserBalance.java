
public class UserBalance{
    private int balance;
    
    public UserBalance(){
        this.balance=0;
    }    

    public UserBalance(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return this.balance;
    }    

    public void deposit(int amount){
        this.balance += amount;
    }    

    public void withdraw(int amount){
        this.balance -= amount;
    }

    public String toString(){
	return "Balance: " + this.balance;
    }
    
}
