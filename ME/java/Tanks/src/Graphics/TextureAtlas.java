package Graphics;


import Utils.ResLoader;

import java.awt.image.BufferedImage;

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
