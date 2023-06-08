import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class healthbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    // code borrowed from https://www.youtube.com/watch?reload=9&v=oJHP18bhLT0
    public int health = 100;
    int healthBarWidth = 300;
    int healthBarHeight = 20;
    int pixelsPerHealthPoint = (int)healthBarWidth/health;
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HealthBar()
    {
        update();
    }

    public void act() 
    {
        update();
    }  

    public void update()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1,1, health*pixelsPerHealthPoint, healthBarHeight);
    }
    public void loseHealth()
    {
        person2 p2 = new person2();
        health-=p2.damage2;
    }
    public void gainHealth()
    {
        if (health + 25 > 99) {
            health+=(100-health);
        }
        else {
            health+=25;
        }
    }
}

