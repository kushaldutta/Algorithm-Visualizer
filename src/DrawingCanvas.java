import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class DrawingCanvas extends JComponent {
    private int width;
    private int height;
    private final int MARGIN = 50;
    private ArrayList<Integer> inputs;
    private ArrayList<Rectangle2D> rectangles = new ArrayList<>();
    private int total;


    public DrawingCanvas(int w, int h, ArrayList<Integer> list) {
        width = w;
        height = h;
        inputs = list;
        total = inputs.size();
    }

    // use input ArrayList to set # of rectangles and height of each
    // width = (page width - 2 * margin) / (# of inputs)
    // height = input value
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        double rWidth = (width - 2 * MARGIN) / total;

        for (int i = 0; i < total; i++) {
            rectangles.add(new Rectangle2D.Double(MARGIN + i * rWidth, height - inputs.get(i), rWidth, inputs.get(i)));
        }

        //Rectangle2D.Double rtest = new Rectangle2D.Double(50, 75, 100, 250);
        //Rectangle2D.Double rtest2 = new Rectangle2D.Double(150, 75, 100, 275);
        g2d.setColor(Color.BLUE);
        for (Rectangle2D r : rectangles) {
            g2d.fill(r);
        }
        //g2d.fill(rtest);
        //g2d.fill(rtest2);

    }
}
