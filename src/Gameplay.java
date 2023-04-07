import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {
    private ImageIcon titleImage;
    public Gameplay(){

    }
    public void paint(Graphics graphics){
        // Border of title image
        graphics.setColor(Color.white);
        graphics.drawRect(24,10,851,55);

        titleImage= new ImageIcon("snaketitle.jpg");
        titleImage.paintIcon(this,graphics,25,11);
        //Border of gameplay
        graphics.setColor(Color.white);
        graphics.drawRect(24,74,851,577);
        graphics.setColor(Color.black);
        graphics.fillRect(25,75,850,575);

    }

}
