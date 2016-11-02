package display.Display;


import com.sun.corba.se.spi.orbutil.fsm.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.lang.reflect.Array;
import java.util.Arrays;


public abstract class Display {
    private static boolean created = false;
    private static JFrame window;
    private static Canvas content;

    private static BufferedImage buffer;
    private static int[] bufferdata;
    private static Graphics bufferGraphics;
    private static int clearColor;

    private static BufferStrategy bufferStrategy;


    public static void create(int width, int height, String title, int _clearColor, int numBuffers) {
        if (created)
            return;

        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = new Canvas();


        Dimension size = new Dimension(width, height);
        content.setPreferredSize(size);

        content.setBackground(Color.green);
        window.setResizable(false);
        window.getContentPane().add(content);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setTitle("Tanks");

        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        bufferdata = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
        bufferGraphics = buffer.getGraphics();
        ((Graphics2D) bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        clearColor = _clearColor;


        content.createBufferStrategy(numBuffers);
        bufferStrategy = content.getBufferStrategy();

        created = true;
    }

    public static void clear() {
        Arrays.fill(bufferdata, clearColor);
    }


    public static void swapBuffers() {
        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(buffer, 0, 0, null);
        bufferStrategy.show();
    }

    public static Graphics2D getGraphics() {
        return (Graphics2D) bufferGraphics;
    }

    public static void destroy() {
        if (!created)
            return;

        window.dispose();
    }

    public static void setTitle(String Title) {
        window.setTitle(Title);
    }


    public static void addInputListener(io.Input inputListener) {
        window.add(inputListener);
    }

}