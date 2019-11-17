import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Buttons is just a class to make button objects,
 * there is really not much else to it
 * 
 * It takes an image and some params and scales it
 * to make a button
 * 
 * I only have 3 buttons so I made custom sprite images 
 * instead of just using regular fonts. They are kind of
 * ugly, but what can I say lol.
 * 
 * @author Dante Romey
 * @version 2019/11/16
 */
public class Buttons extends Actor
{
    /**
     * Creates the image for the button with the image param 
     * and scales it by using the integer parameters provided  
     * 
     * @param GreenfootImage img
     * @param int scaleX
     * @param int scaleY
     */
    public Buttons(GreenfootImage img, int scaleX, int scaleY)
    {
       img.scale(scaleX, scaleY);
       setImage(img); 
    }
}
