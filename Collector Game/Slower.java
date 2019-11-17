import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The slower class is an item that
 * makes the player walk slowly if the player
 * touches it
 * 
 * @author Dante Romey
 * @version 2019/11/16
 */
public class Slower extends Actor
{
    /**
     * Sets the image for the slower item.
     * 
     * All the actual code for slowing the player
     * is located in the player class because it makes
     * more sense.
     * 
     * I also made the player remove the slower when it 
     * touched it instead of the slower doing that itself,
     * this was to avoid the same bug where the object would remove itself
     * before the player could sense that it was touching the object and react.
     */
    public Slower()
    {
        GreenfootImage img = new GreenfootImage("Slower.png");
        img.scale(33,35);
        setImage(img);
    }
}
