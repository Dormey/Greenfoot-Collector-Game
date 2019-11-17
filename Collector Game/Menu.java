import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main menu/title screen for game.
 * Has button to proceed to Menu2.
 * 
 * Also has some pictures of items and
 * brief explanations of what they do and text explaining 
 * how to move around
 * 
 * @author Dante Romey 
 * @version 2019/11/15
 */
public class Menu extends Menus
{
    //Button for proceeding to next menu
    private Buttons SB;
    /**
     * Creates, scales, and sets the image for
     * the menu background
     * 
     * Adds in the button needed
     * 
     * Adds in the hepful objects and text that breifly explain
     * what certain objects do and also how to move
     */
    public Menu()
    {  
        //Create, scale, and set background
        GreenfootImage BG = new GreenfootImage("MenuFile.png");
        BG.scale(getWidth(), getHeight());
        setBackground(BG);

        //Add start and help buttons
        SB = new Buttons(new GreenfootImage("StartButton.png"),240,80);
        addObject(SB, 480, 395);
        
        showText(" P1 moves with WASD ",220,390);
        showText("P2 moves with ← → ↑ ↓",740,390);
        
        addObject(new Boost(),115,480);
        showText("= Speeds you up",230,480);
        addObject(new Slower(),115,600);
        showText("= Slows you down",235,600);
        
        addObject(new Rubies(),360,480);
        showText("= Gives you points",480,480);
        addObject(new Spike(270),360,600);
        showText("= Chases and steals",480,600);
        
        addObject(new Ghost("f"),630,480);
        showText("= Patrols and kills",760,480);
        addObject(new Trap(),630,600);
        showText("= Waits and takes",760,600);
    }
    /**
     * Detects if the mouse has clicked the start button, 
     * and then it sets the world to the next menu screen
     */
    public void detectClick()
    {
        //Detect is start button is pressed and if so go to menu 2
        if(Greenfoot.mouseClicked(SB))
        {
            Greenfoot.setWorld(new Menu2());
        }
    }
    /**
     * Calls methods needed for Menu to function
     */
    public void act()
    {
        detectClick();
    }
}
