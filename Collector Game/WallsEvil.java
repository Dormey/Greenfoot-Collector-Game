import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Walls evil are basically just the same thing as walls
 * but they look cooler. Players and actors cannot walk through evil walls
 * 
 * I just use them in the last level because I wanted
 * the last one with the mega ruby to be different
 * 
 * @author Dante Romey 
 * @version 2019/11/16
 */
public class WallsEvil extends Actor
{
    //Length of wall
    private int length; 
    
    //Rotation of wall
    private int rotation; 
    /**
     * 
     * Creates the image for the wall and scales it
     * using the length param. 
     * 
     * Sets the wall's rotation using the rotation param.
     * 
     * @param int length
     * @param int rotation
     */
    public WallsEvil(int length, int rotation)
    {
        GreenfootImage img = new GreenfootImage("EvilWall.png");
        img.scale(20,length);
        setRotation(rotation);
        setImage(img);
    }  
}
