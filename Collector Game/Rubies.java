import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class for the rubies
 * Rubies are the item that the player(s) are 
 * trying to pick up in each level.
 * 
 * Rubies can check if they can spawn
 * in a location to enable efficient 
 * random location spawning
 * 
 * @author Dante Romey 
 * @version 2019/11/16
 */
public class Rubies extends Actor
{
    /**
     * Creates, scales, and sets 
     * the rubies class image 
     * 
     * Note that all the code for the rubies functions
     * are in the player class
     */
    public Rubies()
    {
        //Create, scale and set image for ruby
        GreenfootImage rubyimg = new GreenfootImage("Ruby.png"); 
        rubyimg.scale(20,28);
        setImage(rubyimg);
    }
    /**
     * Checks whether or not a ruby can be placed in 
     * a specific location, depending on if there are 
     * other objects intersecting it or too close by
     * 
     * @return boolean
     */
    public boolean canPlace()
    {
        return (
                  (getOneIntersectingObject(Walls  .class) ==null)   && 
                  (getOneIntersectingObject(Slower .class) ==null)   &&
                  (getOneIntersectingObject(Boost  .class) ==null)   &&
                  (getOneIntersectingObject(Trap   .class) ==null)   &&
                  (getOneIntersectingObject(Spike  .class) ==null)   &&
                  (getObjectsInRange(135,ScoreBoard.class).size()==0)&&
                  (getObjectsInRange(130, Rubies   .class).size()==0)&& 
                  (getObjectsInRange(135, Player   .class).size()==0) 
               );    
    }
}