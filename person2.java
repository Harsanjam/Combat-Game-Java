import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class person2 extends Actor
{
    private int jumpspeed = 0;
    private int jumpheight = -20;
    private int acceleration = 1;
    private int bulletspeed = 5;
    private int bdelay = 0;
    public boolean left = true;
    public static int damage2 = 5;
    public static int weapon2 = 0;
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("right")) {
            move(8);
            left = true;
        }
        if(Greenfoot.isKeyDown("left")) {
            move(-8);
            left = false;
        }
        if(Greenfoot.isKeyDown("up") && onGround()) {
            jump();
        }
        if (!onGround()) {
            fall();
        }
        if (Greenfoot.isKeyDown("space")) {
            shoot();
        }
        if (bdelay > 0) {
            bdelay -= 1;
        }
        World myWorld = getWorld();
        MyWorld world = (MyWorld)myWorld;
        HealthBar2 healthbar2 = world.getHealthBar2();
        if (this.isTouching(Bullet.class)) {
            healthbar2.loseHealth2();
        }
        else if (healthbar2.health2 == 0) {
            getWorld().removeObject(this);
        }
        else if (this.isTouching(Healthbooster.class))
        {
            if (healthbar2.health2 <= 100) {
                healthbar2.gainHealth();
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
        if (weapon2 == 0) {
            if (bdelay == 0) {
                getWorld().addObject(new Bullet2(left), getX(), getY()-10);
                bdelay = 20;
                damage2 = 5;
            }
        }
        else if (weapon2 == 1) {
            if (bdelay == 0) {
                getWorld().addObject(new Bullet2(left), getX(), getY()-10);
                bdelay = 10;
                damage2 = 10;
            }
        }
        else if (weapon2 == 2) {
            if (bdelay == 0) {
                getWorld().addObject(new Bullet2(left), getX(), getY()-10);
                bdelay = 5;
                damage2 = 5;
            }
        }
        else if (weapon2 == 3) {
            if (bdelay == 0) {
                getWorld().addObject(new Bullet2(left), getX(), getY()-10);
                bdelay = 50;
                damage2 = 20;
            }
        }
    }
}
