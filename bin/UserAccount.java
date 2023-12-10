public class UserAccount {

    private String name;
    private String password;
    
    public UserAccount(String name, String password){
	    this.name = name;
        this.password = password;
    }

    public String getName(){
	    return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean CheckAccount(String Enteredname, String EnteredPassword){
        return Enteredname.equals(name) && EnteredPassword.equals(password);
    }

    public boolean CheckPassword(String EnteredPassword){
        return EnteredPassword == password;
    }

    public void setName(String name){
	    this.name = name;
    }

    public void setPassword(String password){
	    this.password = password;
    }
    
}
