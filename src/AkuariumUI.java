import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.Timer;

import static java.awt.event.KeyEvent.VK_G;
import static java.awt.event.KeyEvent.VK_P;

public class AkuariumUI extends JPanel implements ActionListener {
    private final int SCREEN_WIDTH = 640;
    private final int SCREEN_HEIGHT = 480;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;
    private Timer timer;
    private int x=0;
    private int y=0;
//    private Image guppy;
    private Image guppy1LR[];
    private Image guppy2LR[];
    private Image guppy3LR[];
    private Image piranhaLR[];
//    private Image guppyR[];
    private Image background;
    private Image pellet;
    private Image koin;
    private Image siput;
    private JLabel ShowKoin;
    private Akuarium arkavquarium;
    public AkuariumUI() {
        addKeyListener(new TAdapter());
        addMouseListener(new MAdapter());
        setFocusable(true);

        setPreferredSize(new Dimension(SCREEN_WIDTH+90, SCREEN_HEIGHT+90));
        arkavquarium = new Akuarium();
        loadImages();
        initGame();
    }
    private void loadImages()
    {
        ImageIcon bgi = new ImageIcon(getClass().getResource("img/tank1.png"));
        background = bgi.getImage();
        ImageIcon gupL1 = new ImageIcon(getClass().getResource("img/Guppy-1-Kiri.png"));
        ImageIcon gupR1 = new ImageIcon(getClass().getResource("img/Guppy-1-Kanan.png"));
        guppy1LR = new Image[3];
        guppy1LR[0] = gupL1.getImage();
        guppy1LR[1] = gupR1.getImage();
        ImageIcon gupL2 = new ImageIcon(getClass().getResource("img/Guppy-2-Kiri.png"));
        ImageIcon gupR2 = new ImageIcon(getClass().getResource("img/Guppy-2-Kanan.png"));
        guppy2LR = new Image[3];
        guppy2LR[0] = gupL2.getImage();
        guppy2LR[1] = gupR2.getImage();
        ImageIcon gupL3 = new ImageIcon(getClass().getResource("img/Guppy-3-Kiri.png"));
        ImageIcon gupR3 = new ImageIcon(getClass().getResource("img/Guppy-3-Kanan.png"));
        guppy3LR = new Image[3];
        guppy3LR[0] = gupL3.getImage();
        guppy3LR[1] = gupR3.getImage();
        ImageIcon pirL = new ImageIcon(getClass().getResource("img/Piranha-Kiri.png"));
        ImageIcon pirR = new ImageIcon(getClass().getResource("img/Piranha-Kanan.png"));
        piranhaLR = new Image[3];
        piranhaLR[0] = pirL.getImage();
        piranhaLR[1] = pirR.getImage();
        ImageIcon pel = new ImageIcon(getClass().getResource("img/MakananIkan.png"));
        pellet = pel.getImage();
        ImageIcon koi = new ImageIcon(getClass().getResource("img/Koin.png"));
        koin = koi.getImage();
        ImageIcon sip = new ImageIcon(getClass().getResource("img/Siput-kiri.png"));
        siput = sip.getImage();
//        guppyR = new Image[12];
//        for (int i = 1; i<= 10;i++)
//        {
//            ImageIcon g = new ImageIcon(getClass().getResource("img/guppy/turnleft/"+i+".png"));
//            guppyR[i] = g.getImage();
//        }
    }
    public void initGame()
    {
        timer = new Timer(100, this);
        timer.start();
    }
    public void move()
    {
        arkavquarium.ProsesWaktu();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        move();
        repaint();
    }
    //Repaint bakal manggil 2 fungsi dibawah ini
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        createDrawing(g);
    }
    private void createDrawing(Graphics g) {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
//        g.drawImage(gup, x, y, null);
        int fontSize = 20;

        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));

        g.setColor(Color.red);

        g.drawString("Player's Coin : " + arkavquarium.getKoin(), SCREEN_WIDTH - 100, 20);
        for (int i=0; i< arkavquarium.getIkanList().getSize();i++)
        {
            Ikan cur = arkavquarium.getIkanList().get(i);
            float x = cur.getX();
            float y = cur.getY();
            if (cur.getTipe().equalsIgnoreCase("guppy"))
            {
                Guppy cur_g = (Guppy) cur;
                if (cur.getHadapKanan())
                {
                    if (cur_g.getTahapPertumbuhan() == 1)
                        g.drawImage(guppy1LR[1], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                    else if (cur_g.getTahapPertumbuhan() == 2)
                        g.drawImage(guppy2LR[1], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                    else
                        g.drawImage(guppy3LR[1], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                }
                else
                {
                    if (cur_g.getTahapPertumbuhan() == 1)
                        g.drawImage(guppy1LR[0], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                    else if (cur_g.getTahapPertumbuhan() == 2)
                        g.drawImage(guppy2LR[0], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                    else
                        g.drawImage(guppy3LR[0], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                }
            }
            else
            {
                if (cur.getHadapKanan())
                {
                    g.drawImage(piranhaLR[1], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                }
                else
                {
                    g.drawImage(piranhaLR[0], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                }
            }
        }
        for (int i=0; i< arkavquarium.getMakananIkanList().getSize(); i++)
        {
            float x = arkavquarium.getMakananIkanList().get(i).getX();
            float y = arkavquarium.getMakananIkanList().get(i).getY();
            g.drawImage(pellet, (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
        }
        for (int i=0; i< arkavquarium.getKoinList().getSize();i++)
        {
            float x = arkavquarium.getKoinList().get(i).getX();
            float y = arkavquarium.getKoinList().get(i).getY();
            g.drawImage(koin, (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
        }
        g.drawImage(siput, (int) (SCREEN_WIDTH * arkavquarium.getSiput().getX() / 30), (int) (SCREEN_HEIGHT * (arkavquarium.getSiput().getY()) / 15), null);
    }
    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            int key = e.getKeyCode();
            if (key == VK_G)
            {
                arkavquarium.BeliGuppy();
            }
            if (key == VK_P)
            {
                arkavquarium.BeliPiranha();
            }
        }
    }
    private class MAdapter extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            float scaled_x = (float) (e.getX() * 30.0 / (SCREEN_WIDTH*1.0));
            float scaled_y = (float) (e.getY() * 15.0 / (SCREEN_HEIGHT*1.0));
            if (!arkavquarium.AmbilKoin((float) (scaled_x-0.5), (float) (scaled_y-0.3)))
            {
                arkavquarium.BeliMakanan((float) (scaled_x-0.5), (float) (scaled_y-0.3));
            }
        }
    }
}
