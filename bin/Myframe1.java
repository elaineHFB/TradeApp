import java.awt.*;
public class Myframe1 extends Frame{
    public Myframe1(String title, int width, int height){    
        WindowCloser wc = new WindowCloser();
        addWindowListener(wc); 

        setTitle(title);
        setLayout(new FlowLayout());
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null); // Centers the window on the screen
        setVisible(false);//choose which is visible
    }
}
