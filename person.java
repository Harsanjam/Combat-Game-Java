import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class person extends Actor
{
    private int jumpspeed = 0;
    private int jumpheight = -20;
    private int acceleration = 1;
    private int bulletspeed = 5;
    private int bdelay = 0;
    public boolean right = true;
    public static int weapon = 0;
    public static int damage = 10;
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("d")) {
            move(8);
            right = true;
        }
        if(Greenfoot.isKeyDown("a")) {
            move(-8);
            right = false;
        }
        if(Greenfoot.isKeyDown("w") && onGround()) {
            jump();
        }
        if (!onGround()) {
            fall();
        }
        if (Greenfoot.isKeyDown("q")) {
            shoot();
        }
        if (bdelay > 0) {
            bdelay -= 1;
        }
        if (onRoof()== true){
            jumpspeed = 1;
        }
        World myWorld = getWorld();
        MyWorld world = (MyWorld)myWorld;
        HealthBar healthbar = world.getHealthBar();
        if (this.isTouching(Bullet2.class)) {
            healthbar.loseHealth();
        }
        else if (healthbar.health == 0) {
            getWorld().removeObject(this);
        }
        else if (this.isTouching(Healthbooster.class))
        {
            if (healthbar.health <= 100) {
                healthbar.gainHealth();
            }
        }
    }
    // jump from https://www.youtube.com/watch?v=VAHDrJ069sI
    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);
        return under != null;
    }
    public boolean onRoof() {
        Actor under = getOneObjectAtOffset(0, -getImage().getHeight()/2, Ground.class);
        return under != null;
    }
    public void jump() {
        jumpspeed = jumpheight;
        fall();
    }
    public void fall(){
        setLocation(getX(), getY() + jumpspeed);
        jumpspeed += acceleration;
    }
    public void checkFall() {
        if (onGround()) {
            jumpspeed = 0;
        }
    }
    public void shoot() {
        if (bdelay == 0) {
            if (weapon == 0) {
                damage = 5;
                getWorld().addObject(new Bullet(right), getX(), getY()-10);
                bdelay = 20;
            }
            if (weapon == 1) {
                damage = 10;
                getWorld().addObject(new Bullet(right), getX(), getY()-10);
                bdelay = 10;
            }
            if (weapon == 2) {
                damage = 5;
                getWorld().addObject(new Bullet(right), getX(), getY()-10);
                bdelay = 5;
            }
            if (weapon == 3) {
                damage = 20;
                getWorld().addObject(new Bullet(right), getX(), getY()-10);
                bdelay = 20;
            }
        }
    }
}
