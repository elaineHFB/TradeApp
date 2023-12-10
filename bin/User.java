/*
Everything a single user needs.
*/

import java.util.ArrayList;

public class User extends UserAccount {    
    
    //private Product item;
    private UserBalance account;
    private ArrayList<Product> BoughtItems;
    private ArrayList<Product> SellingItems;
    private ArrayList<Product> SoldItems;
    
    
    public User(String name, String password){
        super(name, password);
        this.account = new UserBalance();
        BoughtItems = new ArrayList<Product>();
        SellingItems = new ArrayList<Product>();
        SoldItems = new ArrayList<Product>();
    }
    
    
    public ArrayList<Product> getItemList(String listname){
        if (listname == "bought"){
            return this.BoughtItems;}
        else if(listname == "selling"){
            return this.SellingItems;}
        else if(listname == "sold"){ 
            return this.SoldItems;}
        else{//error
            return new ArrayList<>();}
            
    }
    /* ***************** */
    public void RemoveSellingItem(int num){
        this.SellingItems.remove(num);
    }
    /* ***************** */
    public Product getSellingItem(int num){
        return this.SellingItems.get(num);
    }

    //I wanna buy product
    public boolean Buyitem(Product item){
        boolean check = getFunds() >= item.getprice();

        if(check){
            withdraw(item.getprice());
            BoughtItems.add(item);
        }
        return check;
    }
    /* ***************** */
    //Someone wanna buy my product
    public void SellItemTo(boolean check, Product item){
        if (check) {
            SellingItems.remove(item);
            SoldItems.add(item);
        }
        else{
            System.out.println("Sorry, you dont have enough balance to buy this product.");
        }
        return;
    }
    //Add selling item
    public void AddSellingItem(String name, int price){
        SellingItems.add(new Product(name,price));
    }
    /* ***************** */
    //add or remove money from user account
    public void deposit(int amount){
	    this.account.deposit(amount);
    }

    public void withdraw(int amount){
	    this.account.withdraw(amount);
    }

    public int getFunds(){
	    return this.account.getBalance();
    }
    /* ***************** */
}
