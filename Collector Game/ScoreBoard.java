import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class for the scoreboard.
 * The scoreboard automatically displays
 * and updates the player(s) score / number of rubies
 * in real time.
 * 
 * @author Dante Romey
 * @version 2019/11/16
 */
public class ScoreBoard extends Actor
{
    //The string to store the score values
    //that will be displayed on the scoreboard
    private String scores;
    
    //The int to determine the size of the text
    //that will be displayed on the scoreboard
    private int txtsize;
    
    //The scoreboards image
    private GreenfootImage img;
    
    //An int to determine whether or not
    //to display a scoreboard for 1 player or 2
    private int sbn;
    /**
     * Sets the scoreboard sbn to be the s parameter,
     * which will be equal to the number of players that are
     * playing the game.
     * 
     * This is so that if there is only one player playing,
     * the scoreboard will only display "P1 Score: (score) ". If there were
     * 2 players, it would display "P1 Score: (score) \n P2 Score: (score).
     * 
     * @param int sbn
     */
    public ScoreBoard(int s)
    {
        sbn = s;
    }
    /**
     * Updates the scores string that 
     * the scoreboard image displays with the correct values for the 
     * player(s) rubies.
     * 
     * Also changes the textsize that will be used depending
     * on how much text needs to fit into the image.
     * 
     * It then sets the scoreboard image and makes it a little
     * transparent.
     */
    public void updateScore()
    {
        if(sbn == 1)
        {
            scores = ("Player 1: "+getWorld().getObjects(Player.class).get(0).getVar("rubies"));
            txtsize = 30;
        }
        else if(sbn == 2)
        {
            scores =  (
                        "Player 1: "  +getWorld().getObjects(Player.class).get(0).getVar("rubies")+
                        "\nPlayer 2: "+getWorld().getObjects(Player.class).get(1).getVar("rubies")
                      );
                      
            txtsize = 26;
        }
        img = new GreenfootImage(scores,txtsize,Color.WHITE,Color.BLACK);
        img.setTransparency(190);
        setImage(img);
    }
    /**
     * Calls the updateScore method so that the scoreboard can continuously update
     * and display the correct scores
     */
    public void act() 
    {
        updateScore();
    }    
}
