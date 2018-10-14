package org.firstinspires.ftc.teamcode;

public class CraterZone {
    public double slope;
    public double intercept;

    public CraterZone(double slop, double inter){
        slope = slop;
        intercept = inter;
    }

    public isEntered(LocationPoint robot){
        double y = robot.getY();
        double x = robot.getX();
        if (y > intercept)
    }
}
