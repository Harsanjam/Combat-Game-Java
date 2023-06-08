import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet2 extends Actor
{
    boolean left;
    public Bullet2(boolean direction){
        left = direction;
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if (this.isTouching(Ground.class)) {
            getWorld().removeObject(this);
        }
        else if (this.isAtEdge()) {
            getWorld().removeObject(this);
        }
        else if (this.isTouching(person.class)) {
            getWorld().removeObject(this);
        }
        if (left == true) {
            move(50);
        }
        else if (left == false) {
            move(-50);
        }
    }
}    
