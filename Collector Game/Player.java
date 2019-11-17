import greenfoot.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This is the player class for the game.
 * 
 * It takes an int in the constructor as a parameter for 
 * determining whether the player is player 1 or player 2
 * 
 * Certain things such as control keys and imgs change
 * between player 1 and 2
 * 
 * It has all the necessary variables and methods for the
 * proper functioning of the player(s)
 * 
 * @author Dante Romey
 * @version 2019/11/16
 */
public class Player extends Actor
{    
    //The player identification number
    //For having differences between P1 and P2
    private int pnum;
    
    //The number of rubies a player has collected
    private int rubies;
    
    //The change in p-coordinates, for player movement
    private int cx;
    private int cy; 
    
    //Speed variable, speed at which player will move
    private int speed;
    
    //Array of images for player's animation
    private GreenfootImage[] pimgs =  new GreenfootImage[9]; 
    /**
     * Sets pnum = n, rubies = 0, cx & cy = 0
     * Sets speed to normal value (6)
     * Creates pimg array of player's imgs for animation 
     * using a for-loop, and also scales the images
     * 
     * @param int n
     */
    public Player(int n)
    {
        pnum = n;
        rubies = 0;
        
        //This for loop is used to create the images for
        //the players's image array. I gave the images special
        //file names so that I could do this
        //It creates the img array based off the player's number
        //(because each player has different images)
        //and then scales the images
        for(int i=1;i<9;i++)
        {
            pimgs[i] = new GreenfootImage(pnum+"-"+i+".png");
            pimgs[i].scale(45,65);
        }
        
        setImage(pimgs[1]);
        speed = 5;
        int cx = 0, cy = 0;
    }
    /**
     * Detects key-presses for player movement and
     * moves player accordingly. It does movement by changing the cx / cy
     * variables to either -speed or speed, and then setting the 
     * location of the Player to it's current location + cx and cy. 
     * This is useful because we can use it to easily do collision and
     * other things
     * 
     * Also calls the methods for player animation
     * and collision
     */
    public void movement() 
    {
        if((Greenfoot.isKeyDown("d")&&pnum==0)||(Greenfoot.isKeyDown("right")&&pnum==1))
        {
            cx = speed;
            cy = 0;
            setLocation(getX() +cx, getY() +cy);
            anime(pimgs[1],pimgs[2]);
        }
        else if((Greenfoot.isKeyDown("a")&&pnum==0)||(Greenfoot.isKeyDown("left")&&pnum==1))
        {
            cx = -speed;
            cy = 0;
            setLocation(getX() +cx, getY() +cy);
            anime(pimgs[5],pimgs[6]);
        }
        else if((Greenfoot.isKeyDown("w")&&pnum==0)||(Greenfoot.isKeyDown("up")&&pnum==1))
        {
            cy = -speed;
            cx = 0;
            setLocation(getX() +cx, getY() +cy);
            anime(pimgs[7],pimgs[8]);
        } 
        else if((Greenfoot.isKeyDown("s")&&pnum==0)||(Greenfoot.isKeyDown("down")&&pnum==1))
        {
            cy = speed;
            cx = 0;
            setLocation(getX() +cx, getY() +cy);
            anime(pimgs[3],pimgs[4]);
        }
        collision();
    }
    /**
     * Checks if player is running into a
     * wall and if so, prevents them from walking through it
     * by moving them backwards to their x and y minus cx and cy
     */
    public void collision()
    {
        if(isTouching(Walls.class)||
           isTouching(WallsEvil.class))
        {
            setLocation(getX()-cx,getY()-cy);
        }
    }
    /**
     * Checks if the player has "picked up"
     * eiher a speed-boost or speed-slower,
     * and if so, changes the player's speed.
     */
    public void checkSpeedItem()
    {
        if(isTouching(Boost.class))
        {
            speed = 7;
            removeTouching(Boost.class);
        }
        else if(isTouching(Slower.class))
        {
            speed = 3;
            removeTouching(Slower.class);
        }
    }
    /**
     * Checks if the player has been killed by a ghost.
     * If so, then it checks the player's rubies to see 
     * how many should be taken away (so as not to screw over
     * players with less rubies), takes away the rubies, and respawns
     * the player at the starting position.
     * 
     * Also resets the players speeds, negating
     * any speed buffs or debuffs previously obtained
     */
    public void checkDeath()
     {
        if(isTouching(Ghost.class))
        {
            if(rubies > 5)
            {
                rubies -= 3;
            }
            else
            {
                rubies -= 2;
            }
            setLocation(107, 625);
            speed = 5;
        }
    }
    /**
     * Checks if the player is touching a 
     * trap, spike, or ruby/megaRuby, and adds or takes away 
     * rubies accordingly.
     * 
     * It then removes the object hit, I did it this way 
     * to avoid a bug where if the object removed itself, 
     * it would be removed before the player had a chance
     * to detect it and decrease its ruby score
     */
    public void checkTouching()
    {
        if(isTouching(Trap.class)||isTouching(Spike.class))
        {
            rubies -= 1;
            removeTouching(Trap.class);
            removeTouching(Spike.class);
        }
        else if(isTouching(Rubies.class))
        {
            rubies++;
            removeTouching(Rubies.class);
        }
        else if(isTouching(megaRuby.class))
        {
            rubies += 8;
            removeTouching(megaRuby.class);
        }
    }
    /**
     * Takes the image parameters and swaps between them
     * to create an animation effect. Used in movement to
     * make the player look like he is walking.
     */
    public void anime(GreenfootImage img1,GreenfootImage img2)
    {
        if(getImage()==img1)
        {
            setImage(img2);
        }
        else
        {
            setImage(img1);
        }
    }
    /**
     * Gets the integer value of the variable specified
     * by the String parameter. It is more efficient
     * than creating an accessor method for each individual variable
     * 
     * @return int (variable value)
     */
    public int getVar(String name)
    {
        if(name == "rubies")
        {
            return rubies;
        }
        else if(name == "pnum")
        {
            return pnum;
        }
        else if(name == "speed")
        {
            return speed;
        }
        else
        {
           return 404;
        }
    }
    /**
     * Gets changes the integer value of the variable specified
     * by the String parameter. It is more efficient
     * than creating a mutator method for each individual variable
     */
    public void setVar(String name, int newv)
    {
        if(name == "rubies")
        {
            rubies = newv;
        }
        else if(name == "pnum")
        {
            pnum = newv;
        }
        else if(name == "speed")
        {
            speed = newv;  
        }
    }
    /**
     * Calls the methods required for the player
     * class to function properly
     */
    public void act()
    {
        movement();
        checkDeath();
        checkTouching();
        checkSpeedItem();
    }    
} 