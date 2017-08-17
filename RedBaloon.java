import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Robby Tan 
 * @version 1.0
 */
public class RedBaloon extends Actor {
    
    public RedBaloon() {
        this.setImage("balloon1.png");
    }
    
    /**
     * Act - do whatever the RedBaloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        this.setLocation(this.getX(), this.getY() - 1);
        if (this.getY() == 0) {
            ((MyWorld) this.getWorld()).gameOver();
        }
    }
    
    public void pop() {
        //  Play pop sound
        Greenfoot.playSound("Baloon Pop.wav");
        //  get instance of world with casting and call addScoreForRedBaloon
        ((MyWorld) this.getWorld()).addScoreForRedBaloon();
        //  Remove this object from world
        this.getWorld().removeObject(this);
    }
}
