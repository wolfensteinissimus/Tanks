package bkhor.games.tanks.graphics;

import java.awt.image.BufferedImage;

import bkhor.games.tanks.utils.ResLoader;

public class TextureAtlas
{
    BufferedImage image;

    public TextureAtlas(String imageName) {
        image = ResLoader.loadImage(imageName);
    }

    public BufferedImage cut (int x , int y , int w , int h){
        return image.getSubimage(x, y, w, h);
    }
}
