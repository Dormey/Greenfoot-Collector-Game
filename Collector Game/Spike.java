
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The spike class is an enemy that follows
 * the player if it gets to close. The player loses 
 * rubies if it gets caught by a spike
 * 
 * If the player runs out of the spikes range the spike will deactivate
 * until a player gets back in range and then continue
 * to track. This is unlikely though, because the spikes range
 * becomes very large
 * 
 * You can use spikes to your advantage sometimes by
 * by making them run into traps and ghosts to kill them.
 * 
 * You can get rid of spikes by running them into walls or 
 * doing as mentioned above
 * 
 * @author Dante Romey 
 * @version 2019/11/16
 */
public class Spike extends Actor
{
    //The image for an inactive spike
    private GreenfootImage spike;
    
    //The image for an activated spike
    private GreenfootImage spikeatck;
    
    //Controls the range at which a spike can detect a target
    private int range;
    
    //Boolean for determining whether the spike is active or not
    private boolean active;
    /**
     * Creates two images for the spike (active & inactive)
     * and scales them.
     * 
     * Initializes range to the range chosen.
     * 
     * Initializes active to false
     * 
     * It also uses the int rot param to set the initial 
     * rotation of the spike.
     * 
     * @param int rot 
     */
    public Spike(int rot)
    {
        spike = new GreenfootImage("Spike.png");
        spike.scale(30,15);
        
        spikeatck = new GreenfootImage("SpikeAttack.png");
        spikeatck.scale(30,15);
        
        setImage(spike);
        
        range = 200;
        
        active = false;
        turn(rot);
    }
    /**
     * Detects if a player has entered into range,
     * and if so, activates the spike causing it
     * to turn towards the player and move to it.
     * 
     * It also changes the range to stretch across a large
     * area, so that the spike doesn't deactivate and activate
     * continuously, because when it did that before it was boring.
     */
    public void track()
    {
        if(getObjectsInRange(range, Player.class).size()!=0)
        {
            range = 700;
            active = true;
            setImage(spikeatck);
            Player target = getObjectsInRange(range,Player.class).get(0);
            turnTowards(target.getX(),target.getY());
            move(3);
        }
        else if(getObjectsInRange(200, Player.class).size()==0)
        {
            setImage(spike);
        }
    }
    /**
     * Detects if a spike has run into a wall,another spike, a trap, or a ghost.
     * 
     * If it has and it is active (active ==true) then it will remove itself from the
     * world.
     * 
     * In the case of other spikes, traps, and ghosts
     * the spike will remove the objects its touching as well.
     * 
     * I made the spike remove the objects to avoid a bug where,
     * if all objects removed themselves individually, some objects
     * would be removed before other objects could detect collision
     * and react.
     */
    public void checkHit()
    {
        if((isTouching(Walls.   class) ||
           isTouching(WallsEvil.class) ||
           isTouching(Spike.    class) ||
           isTouching(Ghost.    class) ||
           isTouching(Trap.     class))
           &&(active == true))
        {
            removeTouching(Spike.class);
            removeTouching(Trap.class);
            removeTouching(Ghost.class);
            getWorld().removeObject(this);
        }
    }
    /**
     * Calls the methods required for the spike
     * class to function properly.
     */
    public void act() 
    {
        track();
        checkHit();
    }    
} 
