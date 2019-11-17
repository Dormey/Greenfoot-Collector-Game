import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
                                                
/**      
 * This builds the level 4 world.
 * Uses methods from LevelBase to build the level
 * 
 * @author Dante Romey
 * @version 2019/11/14                        
 */
public class Level4 extends LevelBase
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
    public Level4(Player p1, Player p2, int n)
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
        addObject(new Ghost("right"),256,216);
        addObject(new Ghost("down"),302,89);
        addObject(new Ghost("left"),759,661);
        addObject(new Ghost("down"),659,330);
        addObject(new Ghost("right"),635,94);
        addObject(new Spike(0),37,57);
        addObject(new Spike(180),576,448);
        addObject(new Spike(270),904,419);
        addObject(new Spike(90),678,37);
        addObject(new Slower(),349,67);
        addObject(new Slower(),499,458);
        addObject(new Boost(),91,52);
    }
    /**
     * Spawns in the wall obstacles for each level.
     * 
     * @param
     * @return 
     */
    public void spawnWalls()
    {
        addObject(new Walls(300,0),180,116);
        addObject(new Walls(200,135),81,382);
        addObject(new Walls(100,45),289,673);
        addObject(new Walls(100,135),360,686);
        addObject(new Walls(100,135),388,443);
        addObject(new Walls(300,0),394,301);
        addObject(new Walls(350,90),769,447);
        addObject(new Walls(50,0),605,432);
        addObject(new Walls(300,45),864,92);
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
            Greenfoot.setWorld(new Level5(player1, player2, numPlyrs));
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
