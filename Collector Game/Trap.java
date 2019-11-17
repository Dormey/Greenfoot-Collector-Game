import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The trap class is an object that is what it sounds
 * like, a trap.
 * 
 * If the player runs into a trap they will lose a ruby,
 * and the trap will get deleted
 * 
 * If a spike is maneuvered to run into a trap it will remove
 * the trap and itself.
 * 
 * @author Dante Romey
 * @version 2019/11/16
 */
public class Trap extends Actor
{
    /**
     * Creates, scales and sets the trap's image.
     * 
     * Note that most of the code for the trap's functions
     * is in other classes.
     */
    public Trap()
    {
        GreenfootImage traptrig = new GreenfootImage("TrapTrig.png");
        traptrig.scale(50,50);
        setImage(traptrig);
    }
    /**
     * Checks whether or not a trap can be placed in 
     * a specific location, depending on if there are 
     * other objects intersecting it or too close by.
     * 
     * @return boolean
     */
    public boolean canPlace()
    {
        return (
                getOneIntersectingObject(Walls.class)     ==null && 
                getOneIntersectingObject(Slower.class)    ==null &&
                getOneIntersectingObject(Boost.class)     ==null &&
                getObjectsInRange(50,ScoreBoard.class).size()==0 &&
                getObjectsInRange(150, Trap.class)  .size()==0   &&
                getObjectsInRange(100, Spike.class) .size()==0   &&
                getObjectsInRange(135, Player.class).size()==0
                );
    }   
}
