package sk.stuba.mtf.oop.gui;

import sk.stuba.mtf.oop.controls.Logic;

import javax.swing.*;
import java.awt.*;

public class Window {
    public Window() {
        JFrame frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.requestFocusInWindow();
        
        Logic logic = new Logic();
        JPanel menu = new JPanel();
        
        //menu.setLayout(new GridLayout(1, 6));
        
        frame.add(menu, BorderLayout.PAGE_START);

        frame.setVisible(true);
    }

}