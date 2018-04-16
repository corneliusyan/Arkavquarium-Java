import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.Timer;

public class AkuariumUI extends JPanel implements ActionListener {
    private final int S_WIDTH = 640;
    private final int S_HEIGHT = 480;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;
    private Timer timer;
    private int x=0;
    private int y=0;
    private Image gup;
    private Image bg;
    public AkuariumUI() {
//        addKeyListener(new TAdapter());
        setFocusable(true);

        setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
        loadImages();
//        guppy = new ImageIcon("img/Guppy-3-Kiri.png").getImage();
        initGame();
    }
    private void loadImages()
    {
        ImageIcon bgi = new ImageIcon(getClass().getResource("img/tank1.png"));
        bg = bgi.getImage();
        ImageIcon guppy = new ImageIcon(getClass().getResource("img/Guppy-3-Kiri.png"));
        gup = guppy.getImage();
    }
    public void initGame()
    {
        timer = new Timer(140, this);
        timer.start();
    }
    public void move()
    {
        x++;
        y++;
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
        g.drawImage(bg, 0, 0, null);
        g.drawImage(gup, x, y, null);
    }
}
