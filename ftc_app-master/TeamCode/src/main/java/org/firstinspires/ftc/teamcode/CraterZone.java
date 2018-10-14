package org.firstinspires.ftc.teamcode;

public class CraterZone {
    public double slope;
    public double intercept;
    public double minX;

    public CraterZone(double smallX, double slop, double inter){
        minX = smallX;
        slope = slop;
        intercept = inter;
    }

    public isEntered(LocationPoint robot){
        double y = robot.getY();
        double x = robot.getX();

        if (y > slope * minX){
    }
}
