import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author Robby Tan
 * @version 1.0
 */
public class YellowBaloon extends Actor {

    public YellowBaloon() {
        this.setImage("balloon3.png");
    }
    
    /**
     * Act - do whatever the YellowBaloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        this.setLocation(this.getX(), this.getY() - 2);
        //  Remove this object from world if y == 0
        if (this.getY() == 0) {
            this.getWorld().removeObject(this);
        }
    }

    public void pop() {
        //  Play pop sound
        Greenfoot.playSound("Baloon Pop.wav");
        //  get instance of world with casting and call addScoreForYellowBaloon
        ((MyWorld) this.getWorld()).addScoreForYellowBaloon();
        //  Remove this object from world
        this.getWorld().removeObject(this);
    }   
}
