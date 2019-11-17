import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boost class is an item that
 * makes the player walk faster if the player
 * touches it
 * 
 * @author Dante Romey
 * @version 2019/11/13
 */
public class Boost extends Actor
{
    /**
     * Sets the image for the Boost item.
     * 
     * All the actual code for speeding up the player
     * is located in the player class because it makes
     * more sense and it avoids code for stuff being 
     * all over the place.
     * 
     * I also made the player remove the boost when it 
     * touched it instead of the boost doing that itself,
     * this was to avoid the bug where the object would remove
     * itself before the player could sense it had touched it
     * and change its speed.
     */
    public Boost()
    {
        GreenfootImage img = new GreenfootImage("SpeedBoost.png");
        img.scale(30,35);
        setImage(img);
    }
}
