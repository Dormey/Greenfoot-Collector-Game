import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class for the walls that I use in the game,
 * Players and actors cannot walk through walls
 * 
 * It allows you to add in new walls with parameters 
 * to select the length and rotation
 * 
 * @author Dante Romey 
 * @version 2019/11/16
 */
public class Walls extends Actor
{
    /**
     * Creates the image for the wall and scales it
     * using the length param. 
     * 
     * Sets the wall's rotation using the rotation param.
     * 
     * @param int length
     * @param int rotation
     */
    public Walls(int length, int rotation)
    {
        GreenfootImage img = new GreenfootImage("Barrier1.png");
        img.scale(20,length);
        setRotation(rotation);
        setImage(img);
    }
}
