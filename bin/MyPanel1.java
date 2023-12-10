import java.awt.*;
public class MyPanel1 extends Panel {
    public MyPanel1(int x, int y, int width, int height){
        this.setBounds(x, y, width, height);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

}
