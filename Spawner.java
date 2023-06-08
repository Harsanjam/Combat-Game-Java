import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    int delay = 1600;
    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (delay > 0) {
            delay--;
        }
        else if (delay == 0) {
            Random rand = new Random();
            int weapon = rand.nextInt(4);
            if (weapon == 0) {
                Random rand1 = new Random();
                int location = rand1.nextInt(5);
                if (location == 0) {
                    getWorld().addObject(new Weapons(),818,657);
                    delay = 1400;
                }
                else if (location == 1) {
                    getWorld().addObject(new Weapons(),296,476);
                    delay = 1400;
                }
                else if (location == 2) {
                    getWorld().addObject(new Weapons(),1333,476);
                    delay = 1400;
                }
                else if (location == 3) {
                    getWorld().addObject(new Weapons(),818,306);
                    delay = 1400;
                }
                else if (location == 4) {
                    getWorld().addObject(new Weapons(),818,819);
                    delay = 1400;
                }
            }
            else if (weapon == 1) {
                Random rand1 = new Random();
                int location = rand1.nextInt(5);
                if (location == 0) {
                    getWorld().addObject(new Weapons2(),818,657);
                    delay = 1400;
                }
                else if (location == 1) {
                    getWorld().addObject(new Weapons2(),296,476);
                    delay = 1400;
                }
                else if (location == 2) {
                    getWorld().addObject(new Weapons2(),1333,476);
                    delay = 1400;
                }
                else if (location == 3) {
                    getWorld().addObject(new Weapons2(),818,306);
                    delay = 1400;
                }
                else if (location == 4) {
                    getWorld().addObject(new Weapons2(),818,819);
                    delay = 1400;
                }
            }
            else if (weapon == 2) {
                Random rand1 = new Random();
                int location = rand1.nextInt(5);
                if (location == 0) {
                    getWorld().addObject(new Weapons3(),818,657);
                    delay = 1400;
                }
                else if (location == 1) {
                    getWorld().addObject(new Weapons3(),296,476);
                    delay = 1400;
                }
                else if (location == 2) {
                    getWorld().addObject(new Weapons3(),1333,476);
                    delay = 1400;
                }
                else if (location == 3) {
                    getWorld().addObject(new Weapons3(),818,306);
                    delay = 1400;
                }
                else if (location == 4) {
                    getWorld().addObject(new Weapons3(),818,819);
                    delay = 1400;
                }
            }
                else if (weapon == 3) {
                    Random rand1 = new Random();
                    int location = rand1.nextInt(5);
                    if (location == 0) {
                        getWorld().addObject(new Healthbooster(),836,640);
                        delay = 1000;
                    }
                    else if (location == 1) {
                        getWorld().addObject(new Healthbooster(),819,290);
                        delay = 500;
                    }
                    else if (location == 2) {
                        getWorld().addObject(new Healthbooster(),1321,462);
                        delay = 250;
                    }
                    else if (location == 3) {
                        getWorld().addObject(new Healthbooster(),292,464);
                        delay = 250;
                    }
            }
        }
    }    
}
