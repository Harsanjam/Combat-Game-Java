import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class healthbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar2 extends Actor
{
    public int health2 = 100;
    int healthBarWidth = 300;
    int healthBarHeight = 20;
    int pixelsPerHealthPoint = healthBarWidth/health2;
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HealthBar2()
    {
        update();
    }
    public void act() 
    {
        // Add your action code here.
        update();
    }  
    public void update()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1,1, health2*pixelsPerHealthPoint, healthBarHeight);
    }
    public void loseHealth2()
    {
       person p = new person();
       health2-=p.damage;
    }
    public void gainHealth()
    {
        if (health2 + 25 > 99) {
            health2+=(100-health2);
        }
        else {
            health2+=25;
        }
    }
}

