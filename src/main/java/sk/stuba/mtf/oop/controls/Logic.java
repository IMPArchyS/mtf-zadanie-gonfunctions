package sk.stuba.mtf.oop.controls;

import lombok.Getter;
import sk.stuba.mtf.oop.canvas.DrawingCanvas;
import sk.stuba.mtf.oop.canvas.GonFunction;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

import java.awt.event.*;



public class Logic extends UniversalAdapter {
    @Getter
    private JSlider amplitudeSlider;
    @Getter
    private JSlider constantSlider;
    @Getter
    private JSlider degreeSlider;
    @Getter
    private DrawingCanvas canvas;
    @Getter
    private JComboBox<String> functionBox;

    private String currentFunction;
    private GonFunction function;

    private int amplitude;
    private int constant;
    private int degrees;

    private static final int INITIAL_AMPLITUDE = 20;
    private static final int INITIAL_CONSTANT = 1;
    private static final int INITIAL_DEGREES = 90;
    private static final String INITIAL_FUNCTION = "Sinus";
    public Logic() {
        this.currentFunction = INITIAL_FUNCTION;
        this.amplitude = INITIAL_AMPLITUDE;
        this.constant = INITIAL_CONSTANT;
        this.degrees = INITIAL_DEGREES;

        this.amplitudeSlider = new JSlider(JSlider.VERTICAL, 0, 20, INITIAL_AMPLITUDE);
        this.amplitudeSlider.setMinorTickSpacing(1);
        this.amplitudeSlider.setMajorTickSpacing(1);
        this.amplitudeSlider.setPaintTicks(true);
        this.amplitudeSlider.setSnapToTicks(true);
        this.amplitudeSlider.setPaintLabels(true);
        this.amplitudeSlider.setFocusable(false);
        this.amplitudeSlider.addChangeListener(this);

        this.constantSlider = new JSlider(JSlider.VERTICAL, 0, 10, INITIAL_CONSTANT);
        this.constantSlider.setMinorTickSpacing(1);
        this.constantSlider.setMajorTickSpacing(1);
        this.constantSlider.setPaintTicks(true);
        this.constantSlider.setSnapToTicks(true);
        this.constantSlider.setPaintLabels(true);
        this.constantSlider.setFocusable(false);
        this.constantSlider.addChangeListener(this);

        this.degreeSlider = new JSlider(JSlider.VERTICAL, 0, 180, INITIAL_DEGREES);
        this.degreeSlider.setMinorTickSpacing(5);
        this.degreeSlider.setMajorTickSpacing(5);
        this.degreeSlider.setPaintTicks(true);
        this.degreeSlider.setSnapToTicks(true);
        this.degreeSlider.setPaintLabels(true);
        this.degreeSlider.setFocusable(false);
        this.degreeSlider.addChangeListener(this);

        String[] functions = {"Sinus", "Cosinus", "Tangens", "Cotangens"};
        this.functionBox = new JComboBox<>(functions);
        this.functionBox.setSelectedIndex(0);
        this.functionBox.addItemListener(this);

        this.canvas = new DrawingCanvas(this.amplitude, this.constant, this.degrees);
        this.resolveFunction();
        this.canvas.repaint();
    }
    
    private void resolveFunction() {
        switch (this.currentFunction) {
            case "Sinus":
                this.function = GonFunction.SINUS;
                break;

            case "Cosinus":
                this.function = GonFunction.COSINUS;
                break;

            case "Tangens":
                this.function = GonFunction.TANGENS;
                break;

            case "Cotangens":
                this.function = GonFunction.COTANGENS;
                break;
        }
        this.canvas.setFunction(function);
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        this.currentFunction = (String) ((JComboBox<?>) (e.getSource())).getSelectedItem();
        this.resolveFunction();
        this.canvas.repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (((JSlider) e.getSource()).equals(this.amplitudeSlider)) {
            this.amplitude = ((JSlider) e.getSource()).getValue();
            this.canvas.setAmplitude(this.amplitude);
            this.canvas.repaint();
        }
        if (((JSlider) e.getSource()).equals(this.constantSlider)) {
            this.constant = ((JSlider) e.getSource()).getValue();
            this.canvas.setConstant(this.constant);
            this.canvas.repaint();

        }
        if (((JSlider) e.getSource()).equals(this.degreeSlider)) {
            this.degrees = ((JSlider) e.getSource()).getValue();
            this.canvas.setDegrees(this.degrees);
            this.canvas.repaint();
        }
    }
}
