import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Ball extends JPanel {
    static JFrame f;
    static int x = 0;
    static int y = 100;
    static boolean right = true;
    public void paint(Graphics g) {
        setSize(f.getSize());
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
    }

    public static void main(String[] args) {
        f = new JFrame("Ball");
        f.setSize(500, 500);
        Ball b = new Ball();
        f.add(b);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            move(f);
        }
    }

    public static void move(JFrame f) {
        try{
            TimeUnit.MILLISECONDS.sleep(5);
            if (right) {
                x++;
                if (x > f.getWidth() - 50) {
                    right = !right;
                }
            }
            if (!right) {
                x--;
                if (x == 0) {
                    right = !right;
                }
            }
            f.repaint();
        } catch (Exception e) {

        }

    }
}


