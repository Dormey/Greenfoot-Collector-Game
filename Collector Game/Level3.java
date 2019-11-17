import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This builds the level 3 world.
 * Uses methods from LevelBase to build the level
 * 
 * @author Dante Romey
 * @version 2019/11/14
 */
public class Level3 extends LevelBase
{
    //The num of plyrs playing 
    private int numPlyrs;
    
    //The player 1 player
    private Player player1;
    
    //The player 2 player
    private Player player2;
    
    //NOTE: Although each level has 2 players
    //the spawn players method will only spawn in
    //the correct number of players
    /**
     * Calls the methods from levelbase that are 
     * required to build the level.
     * 
     * Also calls spawnOthers and spawnWalls
     * because those are specific to each level.
     * 
     * The int n parameter is used for spawning in
     * the correct number of players.
     * 
     * The players for the level are passed as 
     * parameters so that they keep their
     * score when advancing to the next level.
     * 
     * @param int n
     * @param Player p1
     * @param Player p2
     * @return 
     */
    public Level3(Player p1, Player p2, int n)
    {
        numPlyrs = n;
        player1 = p1;
        player2 = p2;
        spawnPlayers(player1, player2, numPlyrs);
        spawnSB(numPlyrs);
        spawnWalls();
        spawnBorder();
        spawnOthers();
        spawnTraps(3);
        spawnRubies(8);
    }
    /**
     * Spawns in other objects for the level
     * such as ghosts, spikes, and speed items.
     * 
     * @param 
     * @return
     */
    public void spawnOthers()
    {
        addObject(new Ghost("down"),303,306);
        addObject(new Ghost("right"),682,642);
        addObject(new Ghost("up"),590,415);
        addObject(new Ghost("left"),460,129);
        addObject(new Spike(90),407,225);
        addObject(new Spike(270),843,682);
        addObject(new Spike(180),921,444);
        addObject(new Boost(),679,64);
        addObject(new Slower(),514,423);
    }
    /**
     * Spawns in the wall obstacles for each level.
     * 
     * @param
     * @return 
     */
    public void spawnWalls()
    {
        addObject(new Walls(400,90),215,198);
        addObject(new Walls(300,0),395,554);
        addObject(new Walls(360,0),724,197);
        addObject(new Walls(200,90),502,570);
    }
    /**
     * Detects if there are no more rubies in the world and 
     * then advances the world to the next level / screen
     * 
     * @param
     * @return
     */
    public void levelAdvance()
    {
        if(getObjects(Rubies.class).size()==0)
        {
            Greenfoot.delay(2);
            Greenfoot.setWorld(new Level4(player1, player2, numPlyrs));
        }
    }
    /**
     * Calls the methods needed for the level
     * to function properly
     * 
     * @params
     * @return
     */
    public void act()
    {
        levelAdvance();
    }
}
