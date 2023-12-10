
public class Product{

    private String ProductName;
    private int price;
    
    // public Product(String name){
    //     this.ProductName = name;
    //     this.price = 0;
    // }    

    public Product(String name, int price){
        this.ProductName = name;
        this.price = price;
    }

    public String getname(){
        return this.ProductName;
    }

    public int getprice(){
        return this.price;
    }    

    public void ChangeObjName(String newProductName){
        this.ProductName = newProductName;
    }

    public void ChangePrice(int newPrice){
        this.price = newPrice;
    }

    public String toString(){
	    return "Product name: " + this.ProductName + " Price: " + this.price;
    }
    
}
