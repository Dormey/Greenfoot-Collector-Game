import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This builds the level 1 world.
 * Uses methods from LevelBase to build the level
 * 
 * @author Dante Romey
 * @version 2019/11/13
 */
public class Level1 extends LevelBase
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
     * the correct number of players
     * 
     * @param int n
     * @return none
     */
    public Level1(int n)
    {
        numPlyrs = n;
        player1 = new Player(0);
        player2 = new Player(1);
        spawnPlayers(player1, player2, numPlyrs); //Spawn in the plyrs
        spawnWalls(); //Spawn in the walls
        spawnBorder(); //Spawn in the border
        spawnSB(numPlyrs);
        spawnOthers();
        spawnTraps(1);
        spawnRubies(8); //Spawn rubies (7)
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
        addObject(new Ghost("down"),385, 300);
        addObject(new Ghost("right"),320, 186);
        addObject(new Ghost("right"),758, 484);
        addObject(new Spike(0),36,254);
        addObject(new Spike(90),575,196);
        addObject(new Boost(), 730, 89);
        addObject(new Slower(), 350, 259);
    }
    /**
     * Spawns in the wall obstacles for each level.
     * 
     * @param
     * @return 
     */
    public void spawnWalls()
    {
        addObject(new Walls(360,0),504, 525);
        addObject(new Walls(300,0),216, 420);
        addObject(new Walls(250,90),687, 170);
        addObject(new Walls(150,0),803, 93);
    }
    /**
     * Detects if there are no more rubies in the world and 
     * then advances the world to the next level / screen
     * 
     * @param
     * @return
     * 
     */
    public void levelAdvance()
    {
        if(getObjects(Rubies.class).size()==0)
        {
            Greenfoot.delay(2);
            Greenfoot.setWorld(new Level2(player1, player2,numPlyrs));
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
