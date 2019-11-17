import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ghost class is an enemy.
 * Ghosts automatically move around the world, and
 * if a player gets touched by one, they lose rubies and have to respawn
 * at the starting location.
 * 
 * If a player comes to close then the ghosts will get mad,
 * they will take on a reddish tint and their speed will increase
 * 
 * @author Dante Romey 
 * @version 2019/11/16
 */
public class Ghost extends Actor
{
    //For determining what direction the ghost will travel in
    private String direction;
    
    //The change in g-coordinates, for ghost movement
    private int cx;
    private int cy;
    
    //Speed variable, speed at which ghost will move
    private int speed;
    
    //Array of images for different directions ghosts face
    private GreenfootImage[] gimgs =  new GreenfootImage[8]; 
    /**
     *Sets the ghost's direction with the string parameter.
     *Initiates the array of images, speed, and cx / cy, and 
     *gives them values if applicable.
     *
     *It also scales the images properly so that they look good.
     *
     *Also checks if the ghost is frozen (for that one ghost on the menu screen)
     *
     * @param Sting dir
     */
    public Ghost(String dir)
    {
        direction = dir;
        
        //This for loop is used to create the images for
        //the ghost's image array. I gave the images special
        //file names so that I could do this
        //It creates the img, then scales it and sets the transparency
        for(int i=0;i<8;i++)
        {
            gimgs[i] = new GreenfootImage("G"+i+".png");
            gimgs[i].scale(43,44);
            gimgs[i].setTransparency(170);
        }
        //These change the scale for 3 of the imgs
        //because the normal scale looked weird on them
        gimgs[4].scale(36,44);
        gimgs[5].scale(36,44);
        gimgs[6].scale(36,45);
        gimgs[7].scale(36,45);
        
        freeze();
        
        speed = 4;
        cx = 0;
        cy = 0;
    }
    /**
     * Detects if a ghost has hit a wall and then
     * changes the ghost's direction to go the
     * opposite way.
     * 
     * Also moves the ghost back a bit to avoid a bug where
     * the ghost gets stuck in a wall just changing directions
     * repeatedly
     */
    public void changeDir()
    {
        if(isTouching(Walls.class)||
           isTouching(WallsEvil.class))
        {
            if (direction == "up")
            {
                direction = "down";
                setLocation(getX(), getY()+4);
            }
            else if(direction == "down")
            {
                direction = "up";
                setLocation(getX(), getY()-4);
            }
            else if(direction == "left")
            {
                direction = "right";
                setLocation(getX()+4, getY());
            }
            else if(direction == "right")
            {
                direction = "left";
                setLocation(getX()-4, getY());
            }
        }
    }
    /**
     * Checks the ghost's direction and makes
     * it move accordingly. It does movement by changing the cx / cy
     * variables to either -speed or speed, and then setting the 
     * location of the Ghost to it's current location + cx and cy. 
     * This is useful because we can use it to easily do collision and
     * other things.
     * 
     * Also changes the ghost's image depending
     * on what direction they are facing.
     */
    public void movement()
    {
        if (direction == "up")
        {
            setImage(gimgs[6]);
            cy = -speed;
            cx = 0;
        }
        else if(direction == "down")
        {
            setImage(gimgs[4]);
            cy = speed;
            cx = 0;
        }
        else if(direction == "left")
        {
            setImage(gimgs[0]);
            cy = 0;
            cx = -speed;
        }
        else if(direction == "right")
        {
            setImage(gimgs[2]);
            cy = 0;
            cx = speed;
        }
        setLocation(getX() +cx, getY() +cy);
    }
    /**
     * Detects if a player has gotten too close
     * to a ghost and then makes the ghost mad.
     * 
     * When a ghost gets mad their eyesm, mouth, and body 
     * become red and their speed increases
     */
    public void checkMad()
    {
        if(getObjectsInRange(150,Player.class).size()!=0)
        {
            if (direction == "right")
            {
                setImage(gimgs[3]);
            }
            else if(direction == "down")
            {
                setImage(gimgs[5]);
            }
            else if(direction == "left")
            {
                setImage(gimgs[1]);
            }
            else if(direction == "up")
            {
                setImage(gimgs[7]);
            }
            speed = 7;
        }
        else if(getObjectsInRange(175,Player.class).size()==0)
        {
            speed = 5;
        }
    }
    /**
     * Checks if the ghost's direction is set to "f"
     * and then sets its image and chanegs its speed to 0.
     * 
     * I just used this so I could have an unmoving Ghost
     * on the menu screen.
     */
    public void freeze()
    {
        if(direction == "f")
        {
            setImage(gimgs[1]);
            speed = 0;
        }
    }
    /**
     * Calls the methods required for the ghost
     * class to function properly
     */
    public void act() 
    {
        changeDir();
        movement();
        checkMad();
    }    
}
