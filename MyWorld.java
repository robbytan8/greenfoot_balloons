import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Robby Tan
 * @version 1.0
 */
public class MyWorld extends World {

    //  Declare object for GreenfootSound
    private GreenfootSound bgSound;
    //  Declare object for counter
    private Counter scoreCounter;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {
        //  Create a 480*800 world with density 1 px
        super(480, 800, 1);
        //  Set background for this world (needed if this app wants to be ported)
        this.setBackground("recycpap.jpg");
        prepare();
    }

    public void act() {
        /*
         *  Auto generate red baloon if random number less than 3
         */
        if (Greenfoot.getRandomNumber(100) < 2) {
            this.addObject(new RedBaloon(), getBaloonRandomXPosition(), 
                getHeight());
        }
        /*
         *  Auto generate yellow baloon if random number equals to 99
         */
        if (Greenfoot.getRandomNumber(200) == 99) {
            this.addObject(new YellowBaloon(), getBaloonRandomXPosition(), 
                getHeight());
        }
    }

    private int getBaloonRandomXPosition() {
        int randomNumber = Greenfoot.getRandomNumber(getWidth());
        if (randomNumber >= getWidth() - 25) {
            randomNumber -= 25;
        }
        return randomNumber;
    }

    /**
     *  Add 10 to scoreCounter
     */
    public void addScoreForRedBaloon() {
        scoreCounter.add(10);
    }

    /**
     *  Add 20 to scoreCounter
     */
    public void addScoreForYellowBaloon() {
        scoreCounter.add(20);
    }

    /**
     *  This method is used to show a game over to user and stop the gameplay.
     */
    public void gameOver() {
        Label labelGameOver = new Label("Game Over", 80);
        this.addObject(labelGameOver, getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        //  Add dart object to world
        this.addObject(new Dart(), getWidth() / 2, getHeight() / 2);
        //  Create a background sound
        bgSound = new GreenfootSound("Jenga.mp3");
        bgSound.setVolume(50);
        bgSound.playLoop();
        //  Create a score counter and add it to world
        scoreCounter = new Counter("Score: ");
        this.addObject(scoreCounter, 80, 780);
    }
}
