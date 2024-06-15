import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DrawingTester {
    static JFrame f = new JFrame();
    static DrawingCanvas dc;
    static int w = 1280;
    static int h = 960;

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(600);
        arr.add(900);
        arr.add(600);
        arr.add(300);
        arr.add(800);
        arr.add(200);
        arr.add(340);
        arr.add(600);



        dc = new DrawingCanvas(w, h, arr);

        JButton button = new JButton("Button");
        button.setBounds(150, 200, 220, 50);
        f.add(button);


        f.setSize(w, h);
        f.setTitle("Drawing in Java");
        f.add(dc);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        //f.remove(dc);
        //f.repaint();
        /*try {
            TimeUnit.MILLISECONDS.sleep(500);
            f.add(dc);
            f.repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sort(arr); */


        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(200);
        arr2.add(300);
        arr2.add(340);
        arr2.add(600);
        arr2.add(600);
        arr2.add(600);
        arr2.add(800);
        arr2.add(900);

        DrawingCanvas dc2 = new DrawingCanvas(w, h, arr2);
        try {
            //TimeUnit.MILLISECONDS.sleep(500);
            //f.remove(dc);
        } catch (Exception e) {

        }


        //f.add(dc2);
        //f.remove(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.remove(dc);
                f.add(dc2);
                f.remove(button);
            }
        });



    }

    public static void sort(ArrayList<Integer> list) {
        int i = 0;
        while (i < list.size()) {
            int j = 0;
            while (j < list.size() - i - 1) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    try {
                        TimeUnit.MILLISECONDS.sleep(250);
                        f.remove(dc);
                        dc = new DrawingCanvas(w, h, list);
                        f.add(dc);
                        f.repaint();
                    } catch (Exception e) {

                    }
                }
                j++;
            }
            i++;
        }
    }
}
