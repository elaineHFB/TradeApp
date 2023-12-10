/* **********************
* ECS414 MiniProject
* Description: An trading App.
* Student Number: 210715349
* Name: Fang Shu Li
********************** */

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

public class TradeApp extends Frame{

    private UsersAll allUsers;
	private int userid;
    /* ********************** */
	//print messages to the user.
    private static TextArea infoArea = new TextArea("TradeApp");

    public static void print(String text){
		infoArea.setText(text);
    }  

	/* ********************** */
	//sign up
    public void newUserSignup(String name, String password){
		allUsers.addUser(new User(name, password));
    }
	/* ********************** */

    public TradeApp(){
		this.allUsers = new UsersAll();	

		// Add user to test
		newUserSignup("el", "123");

		/* ********************** */
		// Create frame
		
		Frame frameLogin = new Myframe1("Login", 500, 500);
		Panel panelLogin = new MyPanel1(50, 100, 400, 400);		

		Frame frame1 = new Myframe1("Trading App", 600, 600);
		Panel panel1 = new MyPanel1(50, 50, 400, 400);		
		
		/* ********************** */
		//buttons
		JLabel LUsername = new JLabel("User name: ");
		TextField Lname = new TextField();
		JLabel LUserP = new JLabel("Password: ");
		TextField Lpassword = new TextField();
		JButton login = new JButton("Login");
		JButton BSignUp = new JButton("Sign up");
		JButton BSignOut = new JButton("Sign out");
		/* ********************** */
		//change to framelogin
		panelLogin.add(login);
		panelLogin.add(BSignUp);

		frameLogin.add(LUsername);
		frameLogin.add(Lname);
		frameLogin.add(LUserP);
		frameLogin.add(Lpassword);
		frameLogin.add(panelLogin);

		frameLogin.setVisible(true);
		/* ********************** */
		//All on frame1
		//set
		panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		infoArea.setEditable(false);

		//panel1 add
		panel1.add(BSignOut);
		//frame1 add
		frame1.add(panel1);
		frame1.add(infoArea);

		/* ********************** */
		//login
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				int count = 0;
				for (int i = 0; i < allUsers.getNumberOfUsers(); i++) {
					if(Lname.getText().equals("") || Lpassword.getText().equals("")){
						System.out.println("Cant be empty");
					}
					else if(allUsers.getSingleUser(i).CheckAccount(Lname.getText(), Lpassword.getText())){
						userid = i;
						frameLogin.setVisible(false);
						frame1.setVisible(true);
					}
					else{count++;}	
				}
				if(count == allUsers.getNumberOfUsers()){
					System.out.println("No user found");
				}
			}
		});
		//Sign up(add new user)
		BSignUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {		
				Prompt acp = new Prompt();

				TextField name = new TextField("Enter User Name");
				TextField password = new TextField("Set password");
				acp.add(name);
				acp.add(password);
				acp.addSubmitListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt) {	
						newUserSignup(name.getText(), password.getText());
					}
				});
				acp.activate();
			}
		});
		/* ********************** */
		//sign out
		BSignOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				userid = -1;	
				frameLogin.setVisible(true);
				frame1.setVisible(false);
			}
		});
    }
    
    public static void main(String[] args){
		new TradeApp();
    }
}
