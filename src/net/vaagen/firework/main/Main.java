package net.vaagen.firework.main;

import net.vaagen.firework.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Magnus on 04/10/2014.
 */
public class Main {

    public static int SCREEN_WIDTH = 1920;
    public static int SCREEN_HEIGHT = 1080;

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    public Main(){
        SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
        SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
        JFrame frame = new JFrame("Firework Show");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.add(new Screen());
        /*frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                Screen.RUNNING = false;
                System.exit(0);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            int mouseX;
            int mouseY;
            @Override
            public void mouseMoved(MouseEvent e) {
                if(mouseX == 0)
                    mouseX = e.getX();

                if(mouseY == 0)
                    mouseY = e.getY();

                if(mouseX != e.getX() || mouseY != e.getY()) {
                    Screen.RUNNING = false;
                    System.exit(0);
                }
            }
        });*/
        frame.setCursor(frame.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null"));
        frame.setVisible(true);
    }

}
