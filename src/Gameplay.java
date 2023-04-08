import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
//import java.awt.Color;
//import java.awt.Graphics;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];
    private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
    private ImageIcon rightmouth;
    private ImageIcon leftmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon snakeimage;
    private Timer timer;
    private int delay=100;
    private int lengthofsnake=3;
    private int moves=0;

    private ImageIcon titleImage;
    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeys(true);
        timer= new Timer(delay,)
    }
    public void paint(Graphics graphics){

        if(moves==0)
        {
            snakexlength[0]=100;
            snakexlength[1]=75;
            snakexlength[2]=50;

            snakeylength[0]=100;
            snakeylength[1]=100;
            snakeylength[2]=100;

        }

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

        rightmouth =new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this,graphics,snakexlength[0],snakeylength[0] );

        for( int a =0; a<lengthofsnake;a++)
        {
            if(a==0 && right)
            {
                rightmouth =new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this,graphics,snakexlength[a],snakeylength[a] );
            }
            if(a==0 && left)
            {
                leftmouth =new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this,graphics,snakexlength[a],snakeylength[a] );

            }
            if(a==0 && up)
            {
                upmouth =new ImageIcon("upmouth.png");
                upmouth.paintIcon(this,graphics,snakexlength[a],snakeylength[a] );

            }
            if(a==0 && down)
            {
                downmouth =new ImageIcon("downtmouth.png");
                downmouth.paintIcon(this,graphics,snakexlength[a],snakeylength[a] );

            }
            if(a!=0)
            {
                snakeimage =new ImageIcon("snakeimage.png");
                snakeimage.paintIcon(this,graphics,snakexlength[a],snakeylength[a] );
            }
        }
        graphics.dispose();

    }

}
