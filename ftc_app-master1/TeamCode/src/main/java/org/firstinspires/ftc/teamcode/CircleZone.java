package org.firstinspires.ftc.teamcode;

public class CircleZone extends Zone{

    public double radius;
    public LocationPoint center;

    public CircleZone(double rad, LocationPoint cent){
        radius = rad;
        center = cent;
    }

    public boolean overlapZone(Zone robot){
        /*if (center.getDistance(robot) < radius){
            return true;
        }
        else {
            return false;
        }*/
        return false;
    }
}
