import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is just a ruby but its a mega, giant one!
 * 
 * Its the only ruby in the last level and its worth 10
 * rubies
 * 
 * Just used it in last level to make last level
 * special and cool
 * 
 * @author (Dante Romey) 
 * @version (1.0)
 */
public class megaRuby extends Actor
{
    /**
     * @name: Constructor
     * @params: none
     * @return: none
     * 
     * Creates the image for the mega ruby and scales it 
     */
    public megaRuby()
    {
        GreenfootImage rubyimg = new GreenfootImage("Ruby.png"); 
        rubyimg.scale(80,100);
        setImage(rubyimg);
    }
}
