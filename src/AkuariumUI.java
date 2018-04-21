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
import static java.awt.event.KeyEvent.VK_T;

public class AkuariumUI extends JPanel implements ActionListener {
    private final int SCREEN_WIDTH = 640;
    private final int SCREEN_HEIGHT = 480;
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
    private Image winBG;
    private Image loseBG;
    private Image pellet;
    private Image koin;
    private Image siputLR[];
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
        ImageIcon win = new ImageIcon(getClass().getResource("img/win.png"));
        winBG = win.getImage();
        ImageIcon lose = new ImageIcon(getClass().getResource("img/lose.png"));
        loseBG = lose.getImage();
        ImageIcon gupL1 = new ImageIcon(getClass().getResource("img/Guppy-1-Kiri.png"));
        ImageIcon gupR1 = new ImageIcon(getClass().getResource("img/Guppy-1-Kanan.png"));
        ImageIcon gupHL1 = new ImageIcon(getClass().getResource("img/Guppy-1-H-Kiri.png"));
        ImageIcon gupHR1 = new ImageIcon(getClass().getResource("img/Guppy-1-H-Kanan.png"));
        guppy1LR = new Image[5];
        guppy1LR[0] = gupL1.getImage();
        guppy1LR[1] = gupR1.getImage();
        guppy1LR[2] = gupHL1.getImage();
        guppy1LR[3] = gupHR1.getImage();
        ImageIcon gupL2 = new ImageIcon(getClass().getResource("img/Guppy-2-Kiri.png"));
        ImageIcon gupR2 = new ImageIcon(getClass().getResource("img/Guppy-2-Kanan.png"));
        ImageIcon gupHL2 = new ImageIcon(getClass().getResource("img/Guppy-2-H-Kiri.png"));
        ImageIcon gupHR2 = new ImageIcon(getClass().getResource("img/Guppy-2-H-Kanan.png"));
        guppy2LR = new Image[5];
        guppy2LR[0] = gupL2.getImage();
        guppy2LR[1] = gupR2.getImage();
        guppy2LR[2] = gupHL2.getImage();
        guppy2LR[3] = gupHR2.getImage();
        ImageIcon gupL3 = new ImageIcon(getClass().getResource("img/Guppy-3-Kiri.png"));
        ImageIcon gupR3 = new ImageIcon(getClass().getResource("img/Guppy-3-Kanan.png"));
        ImageIcon gupLH3 = new ImageIcon(getClass().getResource("img/Guppy-3-H-Kiri.png"));
        ImageIcon gupRH3 = new ImageIcon(getClass().getResource("img/Guppy-3-H-Kanan.png"));
        guppy3LR = new Image[5];
        guppy3LR[0] = gupL3.getImage();
        guppy3LR[1] = gupR3.getImage();
        guppy3LR[2] = gupLH3.getImage();
        guppy3LR[3] = gupRH3.getImage();
        ImageIcon pirL = new ImageIcon(getClass().getResource("img/Piranha-Kiri.png"));
        ImageIcon pirR = new ImageIcon(getClass().getResource("img/Piranha-Kanan.png"));
        ImageIcon pirHL = new ImageIcon(getClass().getResource("img/Piranha-H-Kiri.png"));
        ImageIcon pirHR = new ImageIcon(getClass().getResource("img/Piranha-H-Kanan.png"));
        piranhaLR = new Image[5];
        piranhaLR[0] = pirL.getImage();
        piranhaLR[1] = pirR.getImage();
        piranhaLR[2] = pirHL.getImage();
        piranhaLR[3] = pirHR.getImage();
        ImageIcon pel = new ImageIcon(getClass().getResource("img/MakananIkan.png"));
        pellet = pel.getImage();
        ImageIcon koi = new ImageIcon(getClass().getResource("img/Koin.png"));
        koin = koi.getImage();
        ImageIcon sipL = new ImageIcon(getClass().getResource("img/Siput-kiri.png"));
        ImageIcon sipR = new ImageIcon(getClass().getResource("img/Siput-kanan.png"));
        siputLR = new Image[3];
        siputLR[0] = sipL.getImage();
        siputLR[1] = sipR.getImage();
//        guppyR = new Image[12];
//        for (int i = 1; i<= 10;i++)
//        {
//            ImageIcon g = new ImageIcon(getClass().getResource("img/guppy/turnleft/"+i+".png"));
//            guppyR[i] = g.getImage();
//        }
    }
    public void initGame()
    {
        timer = new Timer(50, this);
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
        if (arkavquarium.getTelur() >= 3)
        {
            g.drawImage(winBG, 0, 0, getWidth(), getHeight(), this);
        }
        else if (arkavquarium.getIkanList().getSize() == 0 && arkavquarium.getKoin() < 50)
        {
            g.drawImage(loseBG, 0, 0, getWidth(), getHeight(), this);
        }
        else
        {
            createDrawing(g);
        }
    }
    private void createDrawing(Graphics g) {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
//        g.drawImage(gup, x, y, null);
        int fontSize = 20;

        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));

        g.setColor(Color.red);

        g.drawString("Player's Coin : " + arkavquarium.getKoin(), SCREEN_WIDTH - 100, 20);
        g.drawString("Player's Egg  : " + arkavquarium.getTelur(), SCREEN_WIDTH - 100, 40);
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
                    {
                        if (cur_g.getWaktuBebas() == 0)
                        {
                            g.drawImage(guppy1LR[3], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                        else
                        {
                            g.drawImage(guppy1LR[1], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                    }
                    else if (cur_g.getTahapPertumbuhan() == 2)
                    {
                        if (cur_g.getWaktuBebas() == 0)
                        {
                            g.drawImage(guppy2LR[3], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                        else
                        {
                            g.drawImage(guppy2LR[1], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                    }
                    else
                    {
                        if (cur_g.getWaktuBebas() == 0)
                        {
                            g.drawImage(guppy3LR[3], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                        else
                        {
                            g.drawImage(guppy3LR[1], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                    }
                }
                else
                {
                    if (cur_g.getTahapPertumbuhan() == 1)
                    {
                        if (cur_g.getWaktuBebas() == 0)
                        {
                            g.drawImage(guppy1LR[2], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                        else
                        {
                            g.drawImage(guppy1LR[0], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                    }
                    else if (cur_g.getTahapPertumbuhan() == 2)
                    {
                        if (cur_g.getWaktuBebas() == 0)
                        {
                            g.drawImage(guppy2LR[2], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                        else
                        {
                            g.drawImage(guppy2LR[0], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                    }
                    else
                    {
                        if (cur_g.getWaktuBebas() == 0)
                        {
                            g.drawImage(guppy3LR[2], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                        else
                        {
                            g.drawImage(guppy3LR[0], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                        }
                    }
                }
            }
            else
            {
                if (cur.getHadapKanan())
                {
                    if (cur.getWaktuBebas() == 0)
                    {
                        g.drawImage(piranhaLR[3], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                    }
                    else
                    {
                        g.drawImage(piranhaLR[1], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                    }
                }
                else
                {
                    if (cur.getWaktuBebas() == 0)
                    {
                        g.drawImage(piranhaLR[2], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                    }
                    else
                    {
                        g.drawImage(piranhaLR[0], (int) (SCREEN_WIDTH * x / 30), (int) (SCREEN_HEIGHT * y / 15), null);
                    }
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
        if (arkavquarium.getSiput().getHadapKanan())
        {
            g.drawImage(siputLR[1], (int) (SCREEN_WIDTH * arkavquarium.getSiput().getX() / 30), (int) (SCREEN_HEIGHT * (arkavquarium.getSiput().getY()) / 15), null);
        }
        else
        {
            g.drawImage(siputLR[0], (int) (SCREEN_WIDTH * arkavquarium.getSiput().getX() / 30), (int) (SCREEN_HEIGHT * (arkavquarium.getSiput().getY()) / 15), null);
        }
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
            if(key == VK_T)
            {
                arkavquarium.BeliTelur();
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
