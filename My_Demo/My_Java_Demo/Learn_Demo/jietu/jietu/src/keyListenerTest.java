import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class keyListenerTest {
    public static void main(String[] args) {
        MainFace mainFace = new MainFace();
        mainFace.setSize(10, 10);
        mainFace.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_0) {
                    System.out.println("VK_NUMPAD0");

                    jirtu1.jietu2222();

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        mainFace.setVisible(true);
        mainFace.requestFocus();

    }
}

class MainFace extends JFrame {
    public MainFace() {
        super("IDEA GUI");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });


    }
}
