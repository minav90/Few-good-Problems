import robocode.Robot;
import robocode.ScannedRobotEvent;

public class MyFirstRobo extends Robot{

	public void run()
	{
		while(true)
		{
			 ahead(500);
       	     turnGunLeft(300);
       	     getGunHeading();
               
            	 
            	 turnGunLeft(300);
            	 turnGunRight(300);
            	 fireBullet(30);
            	 fireBullet(20);
     			fire(1);
             
			 ahead(100);
             turnLeft(100);
             turnGunLeft(200);
             back(100);
             turnRight(200);
             turnGunRight(300);
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e)
	{
		     fireBullet(20);
			fire(1);
			fireBullet(20);
			fire(1);
		
	}

}
