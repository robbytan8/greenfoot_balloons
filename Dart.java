import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dart here.
 * 
 * @author Robby Tan
 * @version 1.0
 */
public class Dart extends Actor {
    
    public Dart() {
        this.setImage("dart.png");
    }
    
    /**
     * Act - do whatever the Dart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }

        if(Greenfoot.mousePressed(null)) {
            int x = getImage().getWidth() / 2;
            int y = getImage().getHeight() / 2;
            Actor baloon = this.getOneObjectAtOffset(-x, y, Actor.class);
            if (baloon instanceof RedBalloon) {
                ((RedBalloon) baloon).pop();
            } else if (baloon instanceof YellowBalloon) {
                ((YellowBalloon) baloon).pop();
            }
        }
    }    
}
