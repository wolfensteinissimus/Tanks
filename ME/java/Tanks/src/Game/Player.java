package Game;


import io.Input;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import Graphics.TextureAtlas;


public class Player extends Entity
{
    public static final int SPRITE_SCALE = 16;
    public static final int SPRITE_PER_HEADING = 1;

    private enum Heading
    {
        NORTH(0 * SPRITE_SCALE,  0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        EAST(6 * SPRITE_SCALE,  0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        SOUTH(4 * SPRITE_SCALE,  0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        WEST(2 * SPRITE_SCALE,  0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE);

        private int x, y, h, w;

        Heading(int x, int y, int h , int w)
        {
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;

        }

        protected BufferedImage texture(TextureAtlas atlas)
        {
             return atlas.cut(x, y , w, h);
        }
    }

    private Heading heading;
    private Map<Heading, Sprite> spriteMap;
    private float scale;
    private float speed;

    protected Player(float x , float y, float scale, TextureAtlas atlas)
    {
        super(EntityType.Player, x , y);

        heading = Heading.NORTH;
        spriteMap = new HashMap<Heading, Sprite>();
        this.scale = scale;
        this.speed = speed;

        for (Heading h : Heading.values())
        {
            SpriteSheet sheet = new SpriteSheet(h.texture(atlas), 1 ,SPRITE_SCALE);
            Sprite sprite = new Sprite(sheet,scale);
            spriteMap.put(h, sprite);
        }
    }

    @Override
    protected void update(Input input)
    {
        float newX = x;
        float newY = y;


    }

    @Override
    protected void render(Graphics2D g) {

    }
}
