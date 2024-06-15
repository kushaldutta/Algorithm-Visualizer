import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MergeChart extends JPanel {
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
        MergeChart b = new MergeChart();
        f.add(b);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        move(f);


    }

    public static void move(JFrame f) {
        int i = 0;
        while (i < inputs.size()) {
            int j = 0;
            while (j < inputs.size() - i - 1) {
                if (inputs.get(j) > inputs.get(j + 1)) {
                    int temp = inputs.get(j);
                    inputs.set(j, inputs.get(j + 1));
                    inputs.set(j + 1, temp);
                    f.repaint();
                    try {
                        TimeUnit.MILLISECONDS.sleep(5); // how quickly it sorts
                    } catch (Exception e) {

                    }
                }
                j++;
            }
            i++;
        }
    }
}


