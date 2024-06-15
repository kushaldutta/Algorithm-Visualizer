import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame();

        // Creating instance of JButton
        JButton bubble = new JButton("Bubble Sort");
        JButton selection = new JButton("Selection Sort");
        JButton quick = new JButton("Quick Sort");

        bubble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chart.main(args);
            }
        });

        selection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectionChart.main(args);
            }
        });

        quick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuickSort.main(args);
            }
        });

        // x axis, y axis, width, height
        bubble.setBounds(150, 200, 220, 50);
        selection.setBounds(150, 125, 220, 50);
        quick.setBounds(150, 50, 220, 50);

        Button button = new Button("Button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1");
            }
        });
        button.setBounds(0, 0, 220, 50);
        frame.add(button);

        // adding button in JFrame
        frame.add(bubble);
        frame.add(selection);
        frame.add(quick);

        // 500 width and 600 height
        frame.setSize(500, 600);

        // using no layout managers
        frame.setLayout(null);

        // making the frame visible
        frame.setVisible(true);
    }
}