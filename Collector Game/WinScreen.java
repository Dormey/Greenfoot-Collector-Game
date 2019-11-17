import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A screen to display a message saying who won
 * once the game has been completed
 * 
 * @author Dante Romey
 * @version 2019/11/15
 */
public class WinScreen extends LevelBase
{
    /**
     * Takes the string param and shows it as text
     * (The string param is a message from Level5 class 
     * telling who won and how many rubies they collected).
     * Also sets the background image for the screen
     * 
     * @param String C
     */
    public WinScreen(String c)
    {
        //Create, scale, and set background
        GreenfootImage BG = new GreenfootImage("WinScreen.png");
        BG.scale(getWidth(), getHeight());
        setBackground(BG);
        
        showText(c,480,360);
        
        addObject(new megaRuby(),850,598);
        addObject(new megaRuby(),850,122);
        addObject(new megaRuby(),110,598);
        addObject(new megaRuby(),110,122);
    }
}
