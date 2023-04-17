import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.jar.JarInputStream;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

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
    private int[] enemyxpos= {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,
            600,625,650,675,700,725,750,775,800,825,850};
    private int[] enemyypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,
            600,625};

    private ImageIcon enemyimage;
    private Random random =new Random();
    private int xpos=random.nextInt(34);
    private int ypos=random.nextInt(23);
    private Timer timer;
    private int delay = 100;
    private int lengthofsnake = 3;
    private int moves = 0;
    private int scores= 0;

    private ImageIcon titleImage;

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics graphics) {

        if (moves == 0) {
            snakexlength[0] = 100;
            snakexlength[1] = 75;
            snakexlength[2] = 50;

            snakeylength[0] = 100;
            snakeylength[1] = 100;
            snakeylength[2] = 100;

        }

        // Border of title image
        graphics.setColor(Color.white);
        graphics.drawRect(24, 10, 851, 55);

        titleImage = new ImageIcon("snaketitle.jpg");
        titleImage.paintIcon(this, graphics, 25, 11);
        //Border of gameplay
        graphics.setColor(Color.white);
        graphics.drawRect(24, 74, 851, 577);
        graphics.setColor(Color.black);
        graphics.fillRect(25, 75, 850, 575);

        // draw the scores
        graphics.setColor(Color.white);
        graphics.setFont(new Font("arial",Font.PLAIN,14));
        graphics.drawString("Scores : "+scores,780,30);
        graphics.drawString("Length : "+lengthofsnake,780,50);

        rightmouth = new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this, graphics, snakexlength[0], snakeylength[0]);

        for (int a = 0; a < lengthofsnake; a++) {
            if (a == 0 && right) {
                rightmouth = new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this, graphics, snakexlength[a], snakeylength[a]);
            }
            if (a == 0 && left) {
                leftmouth = new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this, graphics, snakexlength[a], snakeylength[a]);

            }
            if (a == 0 && up) {
                upmouth = new ImageIcon("upmouth.png");
                upmouth.paintIcon(this, graphics, snakexlength[a], snakeylength[a]);

            }
            if (a == 0 && down) {
                downmouth = new ImageIcon("downtmouth.png");
                downmouth.paintIcon(this, graphics, snakexlength[a], snakeylength[a]);

            }
            if (a != 0) {
                snakeimage = new ImageIcon("snakeimage.png");
                snakeimage.paintIcon(this, graphics, snakexlength[a], snakeylength[a]);
            }
        }
        enemyimage = new ImageIcon("enemy.png");
        enemyimage.paintIcon(this,graphics,enemyxpos[xpos],enemyxpos[ypos]);

        if(enemyxpos[xpos]==snakexlength[0] && enemyypos[ypos]==snakexlength[0])
        {
            lengthofsnake++;
            scores++;
            xpos= random.nextInt(34);
            ypos=random.nextInt(24);
        }
        enemyimage.paintIcon(this,graphics,enemyxpos[xpos],enemyxpos[ypos]);
        for(int b=1; b<lengthofsnake;b++)
        {
            if(snakexlength[b]== snakexlength[0] && snakeylength[b]== snakeylength[0])
            {
                right=false;
                left=false;
                up=false;
                down=false;

                graphics.setColor(Color.white);
                graphics.setFont(new Font("arial",Font.BOLD,50));
                graphics.drawString("Game Over!",300,300);

                graphics.setFont(new Font("arial",Font.BOLD,20));
                graphics.drawString("Scape to RESTART",300,340);
            }
        }
        graphics.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (right) {
            for (int i = lengthofsnake - 1; i >= 0; i--) {
                snakeylength[i + 1] = snakeylength[i];
            }
            for (int i = lengthofsnake; i >= 0; i--) {
                if (i == 0) {
                    snakexlength[i] = snakexlength[i] + 25;
                } else {
                    snakexlength[i] = snakexlength[i - 1];
                }
                if (snakexlength[i] > 850) {
                    snakexlength[i] = 25;
                }
            }
            repaint();
        }
        if (left) {
            for (int i = lengthofsnake - 1; i >= 0; i--) {
                snakeylength[i + 1] = snakeylength[i];
            }
            for (int i = lengthofsnake; i >= 0; i--) {
                if (i == 0) {
                    snakexlength[i] = snakexlength[i] - 25;
                } else {
                    snakexlength[i] = snakexlength[i - 1];
                }
                if (snakexlength[i] < 25) {
                    snakexlength[i] = 850;
                }
            }
            repaint();
        }
        if (up) {
            for (int i = lengthofsnake - 1; i >= 0; i--) {
                snakexlength[i + 1] = snakexlength[i];
            }
            for (int i = lengthofsnake; i >= 0; i--) {
                if (i == 0) {
                    snakeylength[i] = snakeylength[i] - 25;
                } else {
                    snakeylength[i] = snakeylength[i - 1];
                }
                if (snakeylength[i] < 75) {
                    snakeylength[i] = 625;
                }
            }
            repaint();
        }
        if (down) {
            for (int i = lengthofsnake - 1; i >= 0; i--) {
                snakexlength[i + 1] = snakexlength[i];
            }
            for (int i = lengthofsnake; i >= 0; i--) {
                if (i == 0) {
                    snakeylength[i] = snakeylength[i] + 25;
                } else {
                    snakeylength[i] = snakeylength[i - 1];
                }
                if (snakeylength[i] > 625) {
                    snakeylength[i] = 75;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) ;
        {
            moves++;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) ;
        {
            moves++;
            if (!right) {
                left = true;
            } else {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moves++;
            if (!down) {
                up = true;
            } else {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moves++;
            if (!up) {
                down = true;
            } else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            scores=0;
            moves=0;
            lengthofsnake=3;
            repaint();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}

