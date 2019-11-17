import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is the 2nd Menu screen after the title screen.
 * It has 2 buttons for selecting 1 or 2 player mode for the game
 * 
 * @author Dante Romey
 * @version 2019/11/15
 */
public class Menu2 extends Menus
{
    //Button for choosing 1 player mode
    private Buttons P1;
    
    //Button for choosing 2 player mode
    private Buttons P2;
    /**
     * Creates, scales, and sets the image for
     * the menu's background
     * 
     * Also adds in the 2 buttons
     */
    public Menu2()
    {    
        GreenfootImage BG = new GreenfootImage("MenuFile.png"); 
        BG.scale(getWidth(), getHeight());
        setBackground(BG);
          
        P1 = new Buttons(new GreenfootImage("P1Button.png"),240,80);
        P2 = new Buttons(new GreenfootImage("P2Button.png"),240,80);
        addObject(P1,480,400);
        addObject(P2,480, 525);
    }
    /**
     * Detects if the mouse has clicked a button
     * and if so, initializes level 1 with the correct
     * number of players corresponding to the button clicked
     */
    public void detectClick()
    {
        //Detect if P1 button is clicked and if so initialize level1 with 1 player
        if(Greenfoot.mouseClicked(P1)) 
        {
            Greenfoot.setWorld(new Level1(1));
        }
        //Detect if P2 button is clicked and if so initialize level1 with 2 players
        else if(Greenfoot.mouseClicked(P2)) 
        {
            Greenfoot.setWorld(new Level1(2));   
        }
    }
    /**
     * Calls methods required for the level to function
     */
    public void act()
    {
        detectClick();
    }   
}
