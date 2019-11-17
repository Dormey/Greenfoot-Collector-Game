import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is used to create and contain 
 * methods that all the sub-classes (levels)
 * will use to build themselves.
 * 
 * @author Dante Romey
 * @version 2019/11/13
 */
public class LevelBase extends World
{  
    /**
     * Sets the size of the worlds / levels 
     * (super), and sets the background image
     * 
     * @param 
     * @return 
     */
    public LevelBase()
    {    
        super(960, 720, 1);
        Greenfoot.setSpeed(42);
        setBackground(new GreenfootImage("Stone.png"));
    }
    /**
     * Looks at the number of players to spawn and then
     * spawns in either one or both players.
     * 
     * By passing the players as params instead of making
     * new ones each time, the players keep their score through the levels.
     * 
     * Spawning in a player also removes any previously obtained
     * speed buffs or debuffs.
     * 
     * @param Player p1
     * @param Player p2, 
     * @param int n
     * @return 
     * 
     */
    public void spawnPlayers(Player p1, Player p2, int n)
    {
        if(n==1)
        {
            addObject(p1, 107, 625);
        }
        else if(n==2)
        {
            addObject(p1,60, 625);
            addObject(p2,135, 625);
        }
        p1.setVar("speed",5);
        p2.setVar("speed",5);
    }
    /**
     * Spawns in the correct amount of rubies (numRubies) 
     * in random locations while also checking if the 
     * rubies can even be placed at the randomly chosen location. It
     * does this by using the canPlace() method from the ruby class.
     * 
     * If a ruby cannot be placed in a location than it
     * is removed and respawned in a different random 
     * location
     * 
     * @param int numRubies
     * @return 
     * 
     */
    public void spawnRubies(int numRubies)
    {
        for(int i = 0; i < numRubies; i++)
        {
            int x = Greenfoot.getRandomNumber(900) + 35;
            int y = Greenfoot.getRandomNumber(670) + 30;
            Rubies ruby = new Rubies();
            addObject(ruby,x,y);
            if(!ruby.canPlace())
            {
                removeObject(ruby);
                i--;
            }
        }
    }
    /**
     * Randomly spawns the correct amount of traps (numTraps)
     * in random locations while also checking if the traps can 
     * be placed at the chosen location. It does this by using the canPlace()
     * method from the trap class
     * 
     * If a trap cannot be placed in a location than it
     * is removed and respawned in a different random 
     * location
     * 
     * 
     * @param int numTraps
     * @return
     */
    public void spawnTraps(int numTraps)
    {
        for(int i = 0; i < numTraps; i++){
            int x = Greenfoot.getRandomNumber(740) + 186;
            int y = Greenfoot.getRandomNumber(670) + 30;
            Trap trap = new Trap();
            addObject(trap,x,y);
            if(!trap.canPlace())
            {
                removeObject(trap);
                i--;
            }
        }
    }
    /**
     * Spawns in the border for the level.
     * The border is just a bunch of walls
     * that stop the player from walking off the edge
     */
    public void spawnBorder()
    {
        addObject(new Walls(720,0),10,360);
        addObject(new Walls(960, 90),480,710);
        addObject(new Walls(720,0),950,360);
        addObject(new Walls(960, 90),480,10);
    }
    /**
     * Spawns in a scoreboard displaying
     * the scores of the player(s). Uses the numplyrs param to 
     * determine whether to display scores for 1 or 2 players
     * 
     * @params int numplyrs
     * @return 
     * 
     */
    public void spawnSB(int numplyrs)
    {
        if(numplyrs == 1)
        {
            addObject(new ScoreBoard(1),480,35);
        }
        else if(numplyrs == 2)
        {
            addObject(new ScoreBoard(2),480, 46);
        }
    }
    /**
     * Deletes all the rubies on the current level.
     * I used this for skipping over levels while testing,
     * because once the level detcts that there are no
     * rubies remaining, it advances to the next one
     */
    public void deleteRubies()
    {
        removeObjects(getObjects(Rubies.class));
    }
} 
