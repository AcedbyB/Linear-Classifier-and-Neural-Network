package learn.draw.util;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Drawing {

    static public void drawLoss(ArrayList<Double> loss) {
        JFrame frame = new JFrame("Loss by Iterations");
        frame.setSize(600, 600);
        Painting painting = new Painting();
        painting.numsteps = loss.size();
        painting.loss = loss;
        frame.add(painting);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static class Painting extends Canvas {
        int numsteps;
        ArrayList<Double> loss;

        public void paint(Graphics g) {
            int height = this.getHeight();
            int width = this.getWidth();
            g.drawLine(width / 13, height / 13, width / 13, height / 13 * 12);
            g.drawLine(width / 13, height / 13 * 12, width / 13 * 12, height / 13 * 12);
            g.drawString("0.0", width / 13 - 20, height / 13 * 12);
            g.drawString("0.2", width / 13 - 20, height / 13 * 10);
            g.drawString("0.4", width / 13 - 20, height / 13 * 8);
            g.drawString("0.6", width / 13 - 20, height / 13 * 6);
            g.drawString("0.8", width / 13 - 20, height / 13 * 4);
            g.drawString("1.0", width / 13 - 20, height / 13 * 2);
            for (int i = 1; i <= 5; i++) {
                int cur = numsteps / 5 * i;
                g.drawString(Integer.toString(cur), width / 13 * (i * 2 + 1) - 20, height / 13 * 12 + 20);
            }
            double lastX = 0.0;
            double lastY = 0.0;
            for (int i = 0; i < loss.size(); i++) {
                double curX = width / 13 + i * width / 13 * 10 / numsteps;
                double curY = height / 13 * 12 - height / 13 * 10 * loss.get(i);
                if (lastX == 0.0) lastX = curX;
                if (lastY == 0.0) lastY = curY;
                g.drawLine((int) lastX, (int) lastY, (int) curX, (int) curY);
                lastX = curX;
                lastY = curY;
            }
        }
    }

}
