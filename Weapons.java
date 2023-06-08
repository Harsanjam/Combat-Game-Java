import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapons extends Actor
{
    /**
     * Act - do whatever the Weapons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (this.isTouching(person.class)) {
            getWorld().removeObject(this);
            person p = new person();
            p.weapon = 1;
        }
        else if (this.isTouching(person2.class)) {
            getWorld().removeObject(this);
            person2 p2 = new person2();
            p2.weapon2 = 1;
        }
    }
}
