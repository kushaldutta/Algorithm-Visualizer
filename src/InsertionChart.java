import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InsertionChart extends JPanel {
    static JFrame f;
    static private ArrayList<Integer> inputs;
    private static ArrayList<Rectangle2D> rectangles;
    static private int total;
    private final int MARGIN = 50;
    static int width = 1280;
    static int height = 960;

    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        setSize(f.getSize());
        graphics2D.setColor(Color.RED);
        rectangles = new ArrayList<>();

        double rWidth = (width - 2 * MARGIN) / total;
        for (int i = 0; i < total; i++) {
            rectangles.add(new Rectangle2D.Double(MARGIN + i * rWidth, height - inputs.get(i), rWidth, inputs.get(i)));
        }

        for (Rectangle2D r : rectangles) {
            graphics2D.fill(r);
        }
    }

    public static void main(String[] args) {
        inputs = new ArrayList<>();
        for (int i = 0; i < 250; i++) { // total # of inputs
            Random random = new Random();
            inputs.add(random.nextInt(960));
        }
        total = inputs.size();

        f = new JFrame("Chart");
        f.setSize(width, height);
        InsertionChart b = new InsertionChart();
        f.add(b);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            move(f);
        }


    }

    public static void move(JFrame f) {
        int n = total;
        for (int i = 1; i < n; ++i) {
            int key = inputs.get(i);
            int j = i - 1;

            while (j >= 0 && inputs.get(j) > key) {
                inputs.set(j + 1, inputs.get(j));
                j = j - 1;
                f.repaint();
                try {
                    TimeUnit.MILLISECONDS.sleep(5);
                } catch (Exception e) {

                }
            }
            inputs.set(j + 1, key);
            f.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(5); // how quickly it sorts
            } catch (Exception e) {

            }
        }
    }
}


