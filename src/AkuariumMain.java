import java.awt.EventQueue;
import javax.swing.JFrame;
public class AkuariumMain extends JFrame {
    public AkuariumMain() {
        getContentPane().add(new AkuariumUI());
//        setSize(640, 480);
        setResizable(false);
        pack();

        setTitle("ArkavQuarium");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ex = new AkuariumMain();
                ex.setVisible(true);
            }
        });
    }
}
