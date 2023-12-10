/*
Contains all user
*/



import java.util.ArrayList;
import java.util.Iterator;
public class UsersAll{

    private ArrayList<User> users;

    public UsersAll(){
		users = new ArrayList<User>();
    }
    public void addUser(User c){
		users.add(c);
    }
   
    public int getNumberOfUsers(){
		return users.size();
    }
	public ArrayList<User> getUsersall(){
		return this.users;
	}
	public User getSingleUser(int UserNumber){
		return users.get(UserNumber);
	}
	//Print user info for "name balance password"
    public String getUserInfo(int UserNumber){
    	User c = users.get(UserNumber);

		String text = "";
		text += "Name: " + c.getName() + "\n";
		text += "Balance: " + c.getFunds() + "\n";
		text += "Password: " + c.getPassword() + "\n";
		return text;
    }
    
	//print out each "bought/selling/sold" items list

	    public String getUserItemsList(int UserNumber,String arrayname){
		User c = users.get(UserNumber);
		String text = "";

		for (Product p : c.getItemList(arrayname)) {
			text += p.toString() + "\n";
		}
		return text;
    }

	//Polymorphism method
	public String getAllUserSellingItems(){
		String text = "";
		for (User user : this.users) {
			user.getItemList("selling");
			text += user.toString() + "\n";
		}
		return text;
    }

    public boolean deposit(String UserName, int amount){
		Iterator<User> it = users.iterator();
		boolean found = false;	
		while (it.hasNext()){
			User c = it.next();
			if (c.getName().equals(UserName)){
			found = true;
			c.deposit(amount);
			}
		}
		return found;
    }
}
