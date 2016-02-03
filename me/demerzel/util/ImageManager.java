package me.demerzel.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by Darth on 2/2/2016.
 */
public class ImageManager {

    public BufferedImage loadImage(String path){
        try{
            return ImageIO.read(getClass().getResource(path));
        } catch (Exception e) {
        }
        return null;
    }

}
