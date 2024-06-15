import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SelectionChart extends JPanel {
    static JFrame f;
    static private ArrayList<Integer> inputs;
    private static ArrayList<Rectangle2D> rectangles;
    static private int total;
    private final int MARGIN = 50;
    static int width = 1280;
    double rWidth;
    static int height = 960;
    static ArrayList<Double[]> attributes;

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
        for (int i = 0; i < 250; i++) { // put user input for amount of inputs
            Random random = new Random();
            inputs.add(random.nextInt(960));
        }

        total = inputs.size();

        f = new JFrame("Chart");
        f.setSize(width, height);
        SelectionChart b = new SelectionChart();
        f.add(b);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        move(f);
    }

    public static void move(JFrame f) {
        for (int i = 0; i < total; i++) {
            int smallest = inputs.get(i);
            int pos = i;
            for (int j = i; j < total; j++) {
                if (inputs.get(j) < smallest) {
                    smallest = inputs.get(j);
                    pos = j;
                }
            }
            inputs.set(pos, inputs.get(i));
            inputs.set(i, smallest);
            f.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (Exception e) {

            }
        }
    }
}


