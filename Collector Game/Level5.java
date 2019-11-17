import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This builds the level 5 world. 
 * Uses methods from LevelBase to build the level.
 * 
 * This level is kind of a troll level as it just has 
 * a bunch of ghosts and one giant ruby.
 * 
 * I just wanted the last level to be funny and stand out
 * 
 * @author Dante Romey
 * @version 2019/11/15
 */
public class Level5 extends LevelBase
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
    
    //The string that will be displayed on the win screen
    private String winningS;
    /**
     * Calls the methods from levelbase that are 
     * required to build the level.
     * 
     * The int n parameter is used for spawning in
     * the correct number of players.
     * 
     * The players for the level are passed as 
     * parameters so that they keep their
     * score when advancing to the next level.
     * 
     * This level is different from the others, as it only
     * has one giant ruby and the only enemies are
     * a swarm of ghosts
     * 
     * I also gave this level some cool looking walls
     * that have red accents
     * 
     * @param int n
     * @param Player p1
     * @param Player p2
     * @return 
     */
    public Level5(Player p1, Player p2, int n)
    {
        numPlyrs = n;
        player1 = p1;
        player2 = p2;
        spawnPlayers(player1, player2, numPlyrs);
        spawnSB(numPlyrs);
        spawnWalls();
        spawnGhosts(4);
        addObject(new megaRuby(),883,77);
    }
    /**
     * Spawns in the wall obstacles for each level.
     * 
     * @param
     * @return 
     */
    public void spawnWalls()
    {
        addObject(new WallsEvil(720,0),10,360);
        addObject(new WallsEvil(960, 90),480,710);
        addObject(new WallsEvil(720,0),950,360);
        addObject(new WallsEvil(960, 90),480,10);
    }
    /**
     * Spawns in swarms of ghosts in random locations,
     * this is the only level that does this.
     * 
     * Since I have no other objects in the world except
     * the big ruby, scoreboard, and player(s), I can just
     * change the area that the ghosts can spawn. By doing
     * this I avoid the need for a boolean method
     * that checks if the ghosts can be spawned in a location
     * 
     * @params: int numg
     * @return: none
     */
    public void spawnGhosts(int numg)
    {
        for(int i = 0; i < numg; i++)
        {
            int x = Greenfoot.getRandomNumber(670) + 200;
            int y = Greenfoot.getRandomNumber(450) + 100;
            addObject(new Ghost("right"),x,y);
            addObject(new Ghost("left"),x,y);
            addObject(new Ghost("up"),x,y);
            addObject(new Ghost("down"),x,y);
        }
    }
    /**
     * If in 1 player mode, creates a message stating the 
     * number of rubies that you got away with
     * 
     * If in 2 player mode checks which player got more rubies
     * and creates a message for them, if its a tie it justs creates a 
     * message for all players
     * 
     */
    public void getWinner()
    {
        if(numPlyrs == 1)
        {
            int p1s = getObjects(Player.class).get(0).getVar("rubies");
            winningS = "You got away with " +p1s+ "/40 rubies...";
        }
        else if(numPlyrs == 2)
        {
            int p1s = getObjects(Player.class).get(0).getVar("rubies");
            int p2s = getObjects(Player.class).get(1).getVar("rubies");
            if(p1s > p2s)
            { 
                winningS = "P1 Got away with " +p1s+ "/40 rubies...";
            }
            else if(p1s < p2s)
            {
                winningS = "P2 Got away with " +p2s+ "/40 rubies...";
            }
            else if(p1s == p2s)
            {
                winningS = "Everyone got away with " +p1s+ "/40 rubies...";
            }
        }
    }
    /**
     * Detects if the megaRuby has been collected and then
     * creates the message string. Then sets the world to the winScreen
     */
    public void detectLevelEnd()
    {
        if(getObjects(megaRuby.class).size()==0)
        {
            Greenfoot.delay(2);
            getWinner();
            Greenfoot.setWorld(new WinScreen(winningS));
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
        detectLevelEnd();
    }
}
