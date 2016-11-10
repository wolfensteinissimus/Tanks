package bkhor.games.tanks.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResLoader {
    public static BufferedImage loadImage(String fileName) {
        BufferedImage image = null;

        try {

            image = ImageIO.read(new File(ResLoader.class.getResource(fileName).getFile()));

        }catch (IOException e) {
            System.out.println("Cannot read file " + fileName);
             e.printStackTrace();
        }

        return image;
    }
}
