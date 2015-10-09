import java.awt.geom.Point2D;

import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class MyFirstRobo extends AdvancedRobot {

	private AdvancedEnemyBot enemy = new AdvancedEnemyBot();
	private byte scanDirection = 1;
	private byte moveDirection = 1;
	private int wallMargin = 60; 

	public void run() {
		enemy.reset();
		setAdjustRadarForRobotTurn(true);
		setAdjustGunForRobotTurn(true);
		int i = 0;
		while (true) {
			turnRadarRight(360);
			//turnRadarLeft(180);
			setAhead(100 * moveDirection);
			setBack(100 * moveDirection);
			
			scanDirection *= -1; // changes value from 1 to -1
			
		}
	}
	
	

	public void onHitWall(HitWallEvent e) { moveDirection *= -1; }
	public void onHitRobot(HitRobotEvent e) { moveDirection *= -1; }
	
	public void onScannedRobot(ScannedRobotEvent e) {
		if (enemy.none() || e.getName().equals(enemy.getName())) {
			enemy.update(e);
		}
		if (enemy.none() || e.getDistance() < enemy.getDistance() - 70  || e.getName().equals(enemy.getName())) {
			enemy.update(e,this);
		}
		scanDirection *= -1; // changes value from 1 to -1
		double direction = getHeading() - getRadarHeading() + e.getBearing();
		turnRadarRight(direction);
		turnGunRight(direction);
		if (getGunHeat() == 0 && Math.abs(getGunTurnRemaining()) < 10)
			setFire(Math.min(400 / enemy.getDistance(), 3));
		
		double firePower = Math.min(500 / enemy.getDistance(), 3);
		double bulletSpeed = 20 - firePower * 3;
		long time = (long)(enemy.getDistance() / bulletSpeed);
		double futureX = enemy.getFutureX(time);
		double futureY = enemy.getFutureY(time);
		double absDeg = absoluteBearing(getX(), getY(), futureX, futureY);
		// turn the gun to the predicted x,y location
		setTurnGunRight(normalizeBearing(absDeg - getGunHeading()));
		doMoveCir();

	}
	
	double absoluteBearing(double x1, double y1, double x2, double y2) {
		double xo = x2-x1;
		double yo = y2-y1;
		double hyp = Point2D.distance(x1, y1, x2, y2);
		double arcSin = Math.toDegrees(Math.asin(xo / hyp));
		double bearing = 0;

		if (xo > 0 && yo > 0) { // both pos: lower-Left
			bearing = arcSin;
		} else if (xo < 0 && yo > 0) { // x neg, y pos: lower-right
			bearing = 360 + arcSin; // arcsin is negative here, actuall 360 - ang
		} else if (xo > 0 && yo < 0) { // x pos, y neg: upper-left
			bearing = 180 - arcSin;
		} else if (xo < 0 && yo < 0) { // both neg: upper-right
			bearing = 180 - arcSin; // arcsin is negative here, actually 180 + ang
		}

		return bearing;
	}

	
	double normalizeBearing(double angle) {
		while (angle >  180) angle -= 360;
		while (angle < -180) angle += 360;
		return angle;
	}

	public void doMoveStraf() {

		// always square off against our enemy
		setTurnRight(normalizeBearing(enemy.getBearing() + 90 - (15 * moveDirection)));
		// strafe by changing direction every 20 ticks
		if (getTime() % 20 == 0) {
			moveDirection *= -1;
			setAhead(150 * moveDirection);
		}
	}
	
	public void doMoveCir() {

		// switch directions if we've stopped
		if (getVelocity() == 0)
			moveDirection *= -1;

		// circle our enemy
		setTurnRight(enemy.getBearing() + 90);
		setAhead(1000 * moveDirection);
	}

}
