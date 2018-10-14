package org.firstinspires.ftc.teamcode;

public class SquareZone {
    public double X_LEFT_BOUNDARY;
    public double X_RIGHT_BOUNDARY;
    public double Y_LOWER_BOUNDARY;
    public double Y_UPPER_BOUNDARY;

    public SquareZone(double lowX, double highX, double lowY, double highY){
        X_LEFT_BOUNDARY = lowX;
        X_RIGHT_BOUNDARY = highX;
        Y_LOWER_BOUNDARY = lowY;
        Y_UPPER_BOUNDARY = highY;
    }

    public boolean isEntered(LocationPoint robot){
        if (robot.getX() < X_RIGHT_BOUNDARY && robot.getY() > X_LEFT_BOUNDARY &&
                robot.getY() < Y_UPPER_BOUNDARY && robot.getY() > Y_LOWER_BOUNDARY){
            return true;
        }
        else{
            return false;
        }
    }
}
