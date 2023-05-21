package com.gol;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardRender extends JFrame {

    private int res;
    private List<Rectangle> squares = new ArrayList<Rectangle>();
    private MyPanel myPanel;

    public BoardRender(int width, int height, int res) {
        super("Game of Life");
        this.res = res;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        myPanel = new MyPanel();
        add(myPanel);
    }

    public void addSquare(int pos_i, int pos_j) {
        int x = pos_i * res;
        int y = pos_j * res;
        Rectangle rect = new Rectangle(x, y, res, res);
        squares.add(rect);
        myPanel.repaint();
    }

    public void clearBoard() {
        squares.clear();
        myPanel.repaint();
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for (Rectangle rect : squares) {
                g2.setColor(Color.BLACK);
                g2.fill(rect);
            }
        }
    }

}