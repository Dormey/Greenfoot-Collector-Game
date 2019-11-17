import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This builds the level 2 world.
 * Uses methods from LevelBase to build the level
 * 
 * @author Dante Romey
 * @version 2019/11/14
 */
public class Level2 extends LevelBase
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
    public Level2(Player p1, Player p2, int n)
    {
        numPlyrs = n;
        player1 = p1;
        player2 = p2;
        spawnPlayers(player1, player2, numPlyrs);
        spawnSB(numPlyrs);
        spawnWalls();
        spawnBorder();
        spawnOthers();
        spawnTraps(1);
        spawnRubies(8);
    }
    /**
     *Spawns in other objects for the level
     * such as ghosts, spikes, and speed items.
     * 
     * @param 
     * @return
     */
    public void spawnOthers()
    {
        addObject(new Ghost("down"),439,309);
        addObject(new Ghost("right"),731,650);
        addObject(new Ghost("right"),284,173);
        addObject(new Ghost("up"),726,315);
        addObject(new Spike(0),36,112);
        addObject(new Spike(180),646,405);
        addObject(new Spike(270),667,682);
        addObject(new Boost(),855,73);
        addObject(new Slower(),363,288);
    }
    /**
     * Spawns in the wall obstacles for each level.
     * 
     * @param
     * @return 
     */
    public void spawnWalls()
    {
        addObject(new Walls(360,90),192, 415);
        addObject(new Walls(100,0),363, 358);
        addObject(new Walls(150,0),519, 651);
        addObject(new Walls(100,90),726, 404);
        addObject(new Walls(400,0),673, 214);
    }
    /**
     *Detects if there are no more rubies in the world and 
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
            Greenfoot.setWorld(new Level3(player1, player2, numPlyrs));
        }
    }
    /**
     *Calls the methods needed for the level
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
