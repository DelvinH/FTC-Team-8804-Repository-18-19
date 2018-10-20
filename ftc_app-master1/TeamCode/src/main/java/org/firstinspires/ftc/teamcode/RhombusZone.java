package org.firstinspires.ftc.teamcode;

import android.location.Location;

public class RhombusZone {
    public double slope1;
    public double intercept12;
    public double slope2;
    public double slope3;
    public double intercept34;
    public double slope4;

    public RhombusZone(double s1, double i12, double s2, double s3, double i34, double s4){
        slope1 = s1;
        intercept12 = i12;
        slope2 = s2;
        slope3 = s3;
        intercept34 = i34;
        slope4 = s4;

    }

    public boolean isEntered(LocationPoint robot){
        double x = robot.getX();
        double y = robot.getY();
        double newY;

        if (y < intercept12 && y > 0){
            if (x > 0 && x < -intercept12/slope1){ //Quadrant 1
                return testSlope(slope1, intercept12, robot);
            }
            else if (x > -intercept12/slope2 && x < 0){ //Quadrant 2
                return testSlope(slope2,intercept12,robot);
            }
        }
        else if (y > intercept34 && y < 0){
            if (x < 0 && x > -intercept34/slope1) { //Quadrant 3
                return testSlope(slope3, intercept34, robot);
            }
            else if (x > 0 && x < -intercept34/slope4){ //Quadrant 4
                return testSlope(slope4, intercept34, robot);
            }
        }
        return false;
    }

    public boolean testSlope(double slope, double intercept, LocationPoint robot){
        double newY = slope1 * robot.getX() + intercept12;
        if (robot.getY() < newY){
            return true;
        }
        else{
            return false;
        }
    }
}
