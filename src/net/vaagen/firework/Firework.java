package net.vaagen.firework;

import net.vaagen.firework.main.Main;

import java.awt.*;
import java.util.Random;

/**
 * Created by Magnus on 10/15/2015.
 */
public class Firework {

    private int width = 4, height = 10;
    private float x = Main.SCREEN_WIDTH / 2, y = Main.SCREEN_HEIGHT + height;
    private float rotation = (new Random().nextFloat() - 0.5F) * 5F;
    private float rotationWeight = 1.02F;
    private float speed = 9F + new Random().nextFloat() * 3;
    private float speedWeight = 0.9875F;
    private boolean dead = false;
    private int fuse = 150;

    public void render(Graphics g) {
        if (!dead) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.rotate(Math.toRadians(rotation), x, y);
            g2d.setColor(Color.RED);
            g2d.fillRect((int) x - width / 2, (int) y - height / 2, width, height);
            g2d.rotate(-Math.toRadians(rotation), x, y);
            g2d.dispose();
        }
    }

    public void tick() {
        rotation *= rotationWeight;
        speed *= speedWeight;
        x += Math.cos(Math.toRadians(rotation - 90)) * speed;
        y += Math.sin(Math.toRadians(rotation - 90)) * speed;

        if (fuse <= 0) {
            explode();
        } else
            fuse--;
    }

    private void explode() {
        System.out.println("Explode");
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }

}
