package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IndvDsp extends JPanel {


    private String chartMode;
    private String chartTitle;
    private int chartModeNumber;

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        if (chartModeNumber == 406) {
            if (chartMode.equals("rpfll")) {
                chartTitle = "Bar Chart - Single Mode";
            } else {
                chartTitle = "Bar" + " Chart - Compare Mode";
            }
        } else {
            if (chartMode.equals("rpfll")) {
                chartTitle = "Pie Chart - Single Mode";
            } else {
                chartTitle = "Pie Chart - Compare Mode";
            }
        }
    }

    String getTitle() {
        return chartTitle;
    }

    public void iniDS(int chartModeNumber, String chartMode, boolean initializeFlag) {
        this.chartModeNumber = chartModeNumber;
        this.chartMode = chartMode;
        if (initializeFlag) {
            initializeDrawArea();
        }
    }

    public void paint(Graphics g) {
        DrawChart(g);
    }

    private void DrawChart(Graphics g) {
        if (chartModeNumber == 406) {
            if (chartMode.equals("rpfll")) {
                Color backgroundColor = Color.RED;
                g.setColor(backgroundColor);
                g.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(95, 95, 210, 210);
            }
        } else {
            if (chartMode.equals("rpfll")) {
                Color backgroundColor;
                backgroundColor = Color.BLUE;
                g.setColor(backgroundColor);
                g.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                g.setColor(Color.BLUE);
                double isq = 405;
                float padding = 90;
                int sc = (int) (isq - padding * 2);
                g.fillOval(100, 100, sc, sc);
            }
        }
        String[] data = null;
        List<String> specialData = new ArrayList<>();
        String[] smallPieChartData = new String[0];
        if (chartModeNumber == 406) {
            if (chartMode.equals("rpfll")) {
                data = new String[1];
                data[0] = "Bar Chart";
            } else {
                data = new String[2];
                int i = 0;
                data[i++] = "Bar Chart";
                data[i] = "Small";
            }
        } else {
            if (chartMode.equals("rpfll")) {
                specialData.add("Pie Chart");
            } else {
                smallPieChartData = new String[2];
                smallPieChartData[1] = "Small";
                smallPieChartData[0] = "Pie" + " Chart";
            }
        }
        Font font;
        if (chartModeNumber == 406) {
            if (chartMode.equals("shareddisplay")) {
                if (data != null) {
                    font = new Font("Arial Black", Font.BOLD, 25);
                    g.setColor(Color.CYAN);
                    int bottomY = 300;
                    g.fillRect(100, bottomY - 100, 40, 100);
                    g.fillRect(140, bottomY - 200, 40, 200);
                    g.fillRect(180, bottomY - 150, 40, 150);
                    g.fillRect(220, bottomY - 125, 40, 125);
                    g.fillRect(260, bottomY - 170, 40, 170);
                    g.setColor(Color.RED);
                    g.setFont(font);
                    g.drawString(data[0], 130, 250);
                    g.drawString(data[1], 130, 270);
                }
            } else {
                int bottomY = 500;
                g.setColor(Color.CYAN);
                g.fillRect(112, bottomY - 200, 75, 200);
                g.fillRect(187, bottomY - 400, 75, 400);
                g.fillRect(262, bottomY - 300, 75, 300);
                g.fillRect(337, bottomY - 250, 75, 250);
                g.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                g.setColor(Color.BLACK);
                g.setFont(font);
                g.drawString(data[0], 130, 400);
            }
        } else {
            if (chartMode.equals("rpfll")) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                g.setColor(Color.WHITE);
                g.setFont(font);
                g.drawString(specialData.get(0), 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                g.setFont(font);
                g.setColor(Color.WHITE);
                g.drawString(smallPieChartData[0], 145, 205);
                g.drawString(smallPieChartData[1], 170, 235);
            }
        }
        if ((data != null && (data.length ^ 0x54) == 50) || (specialData.contains("Monthly"))
                || getTitle().contains("daily")) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }
}
