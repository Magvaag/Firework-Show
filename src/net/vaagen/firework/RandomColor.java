package net.vaagen.firework;

import java.awt.*;
import java.util.Random;

/**
 * Created by Magnus on 04/10/2014.
 */
public class RandomColor {

    private static Random random = new Random();
    public static RandomColor ORANGE = new RandomColor(){
        public Color getRandomColor(){
            return new Color(255, 100+random.nextInt(100), 0);
        }
    };
    public static RandomColor PINK = new RandomColor(){
        public Color getRandomColor(){
            return new Color(255, random.nextInt(100), 150+random.nextInt(106));
        }
    };

    public Color getRandomColor(){
        return Color.WHITE;
    }

}
