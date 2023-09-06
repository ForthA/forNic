package ru.tarasov.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FileComponent extends JFrame {
    private JPanel panel = new JPanel(null);

    private JScrollPane fileScroller;

    private JList fileList;

    private JScrollPane tableScroller;

    private JScrollPane previewScroller;

    private JPanel graphPanel;

    private Resizable fileResizer;
    private Resizable previewResizer;

    private Resizable tableResizer;

    private Resizable graphResizer;

    private int sizeX;

    private int sizeY;

    public void init(){
        setSize(new Dimension(800, 600));
        sizeX = this.getBounds().getSize().width;
        sizeY = this.getBounds().getSize().height;
        add(panel);

        tableScroller = new JScrollPane();
        previewScroller = new JScrollPane();
        fileScroller = new JScrollPane();
        graphPanel = new JPanel();

        fileResizer = new Resizable(fileScroller);
        previewResizer =  new Resizable(previewScroller);
        tableResizer = new Resizable(tableScroller);
        graphResizer = new Resizable(graphPanel);

        fileResizer.setBounds(0, 0, sizeX/3, sizeY/2);
        previewResizer.setBounds(0, sizeY/2 - 10 , sizeX/3, sizeY/2);
        tableResizer.setBounds(sizeX/3, 0, (sizeX*2)/3, sizeY/2);
        graphResizer.setBounds(sizeX/3, sizeY/2 - 10, (sizeX*2)/3, sizeY/2);

        fileResizer.setAvailableDirections(Set.of(Cursor.SE_RESIZE_CURSOR));
        previewResizer.setAvailableDirections(Set.of(Cursor.NE_RESIZE_CURSOR));
        tableResizer.setAvailableDirections(Set.of(Cursor.SW_RESIZE_CURSOR));
        graphResizer.setAvailableDirections(Set.of(Cursor.NW_RESIZE_CURSOR));

        panel.add(fileResizer);
        panel.add(previewResizer);
        panel.add(tableResizer);
        panel.add(graphResizer);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Trajectory app");
        setLocationRelativeTo(null);
    }

    public void resizeAllComponents(){
        previewResizer.repaint(0, fileResizer.getY() + fileResizer.getHeight(), sizeY - graphResizer.getWidth(), sizeX - fileResizer.getHeight());
        previewResizer.resize();
    }


    public FileComponent() {
        init();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                requestFocus();
                resizeAllComponents();
                fileResizer.repaint();
                previewResizer.repaint();
                tableResizer.repaint();
                graphResizer.repaint();
            }
        });
    }
    public static void main(String[] args) {
        FileComponent rc = new FileComponent();
        rc.setVisible(true);
    }
}

