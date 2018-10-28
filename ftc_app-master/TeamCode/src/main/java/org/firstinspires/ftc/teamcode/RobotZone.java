package org.firstinspires.ftc.teamcode;

public class RobotZone {
    LocationPoint bottomLeftCorner;
    public double width;
    public double length;
    public double theta;

    public RobotZone(double wid, double len)
    {
        width = wid;
        length = len;
    }

    public void updateZone(double x, double y, double angle){
        bottomLeftCorner = new LocationPoint(x, y);
        theta = angle;
    }

}
