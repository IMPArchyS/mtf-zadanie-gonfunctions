package sk.stuba.mtf.oop.gui;

import sk.stuba.mtf.oop.controls.Logic;

import javax.swing.*;
import java.awt.*;

public class Window {
    public Window() {
        JFrame frame = new JFrame("Goniometric functions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 900);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.requestFocusInWindow();

        Logic logic = new Logic();
        JPanel menu = new JPanel();
        JLabel labels = new JLabel("Aplitude  |   Constant   |   Degrees");

        menu.setLayout(new BorderLayout());
        menu.add(labels, BorderLayout.NORTH);
        menu.add(logic.getAmplitudeSlider(), BorderLayout.WEST);
        menu.add(logic.getConstantSlider(), BorderLayout.CENTER);
        menu.add(logic.getDegreeSlider(), BorderLayout.EAST);
        menu.add(logic.getFunctionBox(), BorderLayout.SOUTH);

        frame.add(logic.getCanvas(), BorderLayout.CENTER);
        frame.add(menu, BorderLayout.WEST);
        
        frame.setVisible(true);
    }

}
