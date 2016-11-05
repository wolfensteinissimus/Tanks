package Game;


import io.Input;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;


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

        protected BufferedImage texture(Graphics.TextureAtlas atlas)
        {
             return atlas.cut(x, y , w, h);
        }
    }

    private Heading heading;
    private Map<Heading, Sprite> spriteMap;
    private float scale;
    private float speed;

    protected Player(float x , float y, float scale, Graphics.TextureAtlas atlas)
    {
        super(EntityType.Player, x , y);

        heading = Heading.NORTH;
        spriteMap = new HashMap<Heading, Sprite>();
        this.scale = scale;
        this.speed = speed;

        for (Heading h : Heading.values())
        {
            Graphics.SpriteSheet sheet = new Graphics.SpriteSheet(h.texture(atlas), 1 , SPRITE_PER_HEADING, SPRITE_SCALE);
            Sprite sprite = new Sprite(sheet,scale);
            spriteMap.put(h, sprite);
        }
    }

    @Override
    protected void update(Input input)
    {
        float newX = x;
        float newY = y;

        if(input.getKey(KeyEvent.VK_UP)){
            newY -=
        }
    }

    @Override
    protected void render(Graphics2D g) {

    }
}
