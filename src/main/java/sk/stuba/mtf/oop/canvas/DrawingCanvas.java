package sk.stuba.mtf.oop.canvas;

import javax.swing.*;

import lombok.Setter;

import java.awt.*;

public class DrawingCanvas extends JPanel { 
    @Setter
    private int amplitude;
    @Setter
    private int constant;
    @Setter
    private int degrees;
    @Setter
    private GonFunction function;
    
    public DrawingCanvas(int amplitude, int constant, int degrees) {
        this.setBackground(Color.LIGHT_GRAY);
        this.amplitude = amplitude;
        this.constant = constant;
        this.degrees = degrees;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        function.draw(g, this.amplitude, this.constant, this.degrees);
    }
}
