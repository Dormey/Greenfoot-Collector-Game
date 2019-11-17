import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Menus is just a class to hold the subclasses which will 
 * actually be menu screens
 * 
 * Honestly I only have this class to be able to have the 2 menus
 * as subclasses because I like the way it looks in the program(more
 * organized)      
 * 
 * Also I don't have to specify world size for each menu
 * because it does it here in the parent class
 * 
 * @author Dante Romey 
 * @version 2019/11/15
 */
public class Menus extends World
{
    /**
     * Constructor for objects of class Menus.
     * 
     * All it does is set the world size to 960x720
     */
    public Menus()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 720, 1); 
    }
}
