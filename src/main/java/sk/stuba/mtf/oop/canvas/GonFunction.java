package sk.stuba.mtf.oop.canvas;

import java.awt.*;

public enum GonFunction {
    SINUS,
    COSINUS,
    TANGENS,
    COTANGENS;

    public void draw(Graphics g, int amplitude, int constant, int degrees) {
        int width = g.getClipBounds().width;
        int height = g.getClipBounds().height;

        switch (this) {
            case SINUS:
                g.setColor(Color.BLACK);
                for (int x = 0; x < width; x++) {
                    int y = (int) (amplitude * Math.sin(Math.toRadians(x + degrees)) * constant);
                    g.drawLine(x, height / 2, x, height / 2 - y);
                }
                break;

            case COSINUS:
                g.setColor(Color.BLUE);
                for (int x = 0; x < width; x++) {
                    int y = (int) (amplitude * Math.cos(Math.toRadians(x + degrees)) * constant);
                    g.drawLine(x, height / 2, x, height / 2 - y);
                }
                break;

            case TANGENS:
                g.setColor(Color.RED);
                for (int x = 0; x < width; x++) {
                    int y = (int) (amplitude * Math.tan(Math.toRadians(x + degrees)) * constant);
                    g.drawLine(x, height / 2, x, height / 2 - y);
                }
                break;

            case COTANGENS:
                g.setColor(Color.GREEN);
                for (int x = 0; x < width; x++) {
                    int y = (int) (amplitude / Math.tan(Math.toRadians(x + degrees)) * constant);
                    g.drawLine(x, height / 2, x, height / 2 - y);
                }
                break;
        }
    }
}
