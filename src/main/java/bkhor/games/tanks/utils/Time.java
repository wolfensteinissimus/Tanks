package bkhor.games.tanks.utils;


public class Time
{
    public static final long  SECOND = 10000000000l;

    public static long get()
    {
        return System.nanoTime();
    }
}
