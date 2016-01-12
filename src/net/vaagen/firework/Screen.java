package net.vaagen.firework;

import net.vaagen.firework.main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Magnus on 04/10/2014.
 */
public class Screen extends JPanel implements Runnable {

    public static boolean RUNNING;
    public Thread thread;

    public List<Firework> fireworkList = new CopyOnWriteArrayList<Firework>();

    public int FPS;
    public int UPS;

    public Screen(){
        RUNNING = true;

        fireworkList.add(new Firework());

        thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g){
        g.clearRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);

        for(Firework firework : fireworkList) {
            firework.render(g);
        }
    }

    public void update(){
        for(Firework firework : fireworkList) {
            firework.tick();
            if (firework.isDead()) {
                fireworkList.remove(firework);
                fireworkList.add(new Firework());
            }
        }
    }

    long MAX_FRAMESKIP = 5;
    public void run(){
        // The wait time in milliseconds before next update/render
        long GAME_SKIP_TICKS = 1000 / References.UPDATES_PER_SECOND;
        long FRAME_SKIP_TICKS = 1000 / References.FRAMES_PER_SECOND;

        // Schedules the updates and repaints
        long next_game_tick = System.currentTimeMillis();
        long next_frame_tick = System.currentTimeMillis();
        long time = System.currentTimeMillis();

        // Counts the amount of time the game updates without rendering
        int loops;

        // Variables to update the UPS & FPS variables
        int frames = 0;
        int updates = 0;

        while(RUNNING){
            loops = 0;
            while(System.currentTimeMillis() > next_game_tick && loops < MAX_FRAMESKIP){
                update();

                next_game_tick += GAME_SKIP_TICKS;
                updates++;
                loops++;
            }

            if(System.currentTimeMillis() > next_frame_tick){
                next_frame_tick += FRAME_SKIP_TICKS;
                repaint();
                frames++;
            }

            if(time+1000 <= System.currentTimeMillis()){
                time+=1000;

                FPS = frames;
                UPS = updates;
                updates = 0;
                frames = 0;
            }
        }
    }

}
