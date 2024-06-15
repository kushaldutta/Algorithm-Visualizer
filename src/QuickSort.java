import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class QuickSort extends JPanel {
    static JFrame f;
    static private ArrayList<Integer> inputs;
    private static ArrayList<Rectangle2D> rectangles;
    static private int total;
    private final int MARGIN = 10;
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
        QuickSort b = new QuickSort();
        f.add(b);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        move(f);
    }

    public static void move(JFrame f) {
        quickSort(0, total - 1);
    }

    static void merge(int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        ArrayList<Integer> L1 = new ArrayList<>();
        ArrayList<Integer> R1 = new ArrayList<>();

        for (int i = 0; i < n1; ++i) {
            L1.add(inputs.get(i + 1));
        }
        for (int j = 0; j < n2; ++j) {
            R1.add(inputs.get(m + 1 + j));
        }


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L1.get(i) <= R1.get(j)) {
                inputs.set(k, L1.get(i));
                f.repaint();
                try {
                    TimeUnit.MILLISECONDS.sleep(25);
                } catch (Exception e) {

                }
                i++;
            }
            else {
                inputs.set(k, R1.get(j));
                f.repaint();
                try {
                    TimeUnit.MILLISECONDS.sleep(25);
                } catch (Exception e) {

                }
                j++;
            }
            k++;
        }

        while (i < n1) {
            inputs.set(k, L1.get(i));
            f.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (Exception e) {

            }
            i++;
            k++;
        }

        while (j < n2) {
            inputs.set(k, R1.get(j));
            f.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (Exception e) {

            }
            j++;
            k++;
        }
    }

    static void sort(int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(l, m);
            sort(m + 1, r);

            // Merge the sorted halves
            merge(l, m, r);
        }
    }
        static void swap(int i, int j)
        {
            int temp = inputs.get(i);
            inputs.set(i, inputs.get(j));
            inputs.set(j, temp);
            f.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (Exception e) {

            }
        }

        static int partition(int low, int high)
        {
            int pivot = inputs.get(high);

            int i = (low - 1);

            for (int j = low; j <= high - 1; j++) {

                if (inputs.get(j) < pivot) {

                    i++;
                    swap(i, j);
                }
            }
            swap(i + 1, high);
            return (i + 1);
        }

        static void quickSort(int low, int high)
        {
            if (low < high) {

                int pi = partition(low, high);

                quickSort(low, pi - 1);
                quickSort(pi + 1, high);
            }
        }
}


