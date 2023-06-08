import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Healthbooster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healthbooster extends Actor
{
    /**
     * Act - do whatever the Healthbooster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     int health;
    public void act() {
        if (this.isTouching(person.class)) {
            getWorld().removeObject(this);
        }
        else if(this.isTouching(person2.class)){
            getWorld().removeObject(this);
        }
    }
    public void gainHealth()
    {
        health++;
    }
}
