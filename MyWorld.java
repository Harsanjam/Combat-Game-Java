import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    HealthBar healthbar = new HealthBar();
    HealthBar2 healthbar2 = new HealthBar2();
    public HealthBar getHealthBar() {
        return healthbar;
    }
    public HealthBar2 getHealthBar2() {
        return healthbar2;
    }
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1); 
        addObject(healthbar,175,22);
        addObject(healthbar2,1426,22);
        person char1 = new person();
        addObject(char1,150,812);
        person2 char2 = new person2();
        addObject(char2,1450,812);
        Ground ground = new Ground();
        addObject(ground,1408,869);
        Ground ground2 = new Ground();
        addObject(ground2,1026,869);
        Ground ground3 = new Ground();
        addObject(ground3,644,869);
        Ground ground4 = new Ground();
        addObject(ground4,263,869);
        Ground ground5 = new Ground();
        addObject(ground5,5,869);
        Ground ground6 = new Ground();
        addObject(ground6,818,707);
        Ground ground7 = new Ground();
        addObject(ground7,296,526);
        Ground ground8 = new Ground();
        addObject(ground8,1333,526);
        Ground ground9 = new Ground();
        addObject(ground9,818,356);
        Spawner spawner = new Spawner();
        addObject(spawner,1600,1600);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
