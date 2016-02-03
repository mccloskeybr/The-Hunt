package me.demerzel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mccloskeybr on 2/2/2016.
 */
public class Window {

    private JFrame frame;

    public static final int WINDOW_SIZE = 320;

    public Window(){
        frame = new JFrame();
        frame.setTitle("The Hunt");
        frame.setSize(WINDOW_SIZE, WINDOW_SIZE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
    }
    
    public void addComponent(Component component){
        frame.add(component);
    }

}
