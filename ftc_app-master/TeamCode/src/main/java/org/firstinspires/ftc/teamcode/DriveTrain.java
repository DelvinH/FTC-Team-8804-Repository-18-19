package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DriveTrain extends Robot
{
    private static double MAX_DRIVE_SPEED  = 1.0;
    private static double MAX_TURN_SPEED   = 1.0;
    private static double MAX_STRAFE_SPEED = 0.3;


    void initialize()
    {
        driveFrontRight = hardwareMap.get(DcMotor.class, "dfr");
        driveFrontLeft = hardwareMap.get(DcMotor.class, "dfl");
        driveBackRight = hardwareMap.get(DcMotor.class, "dbr");
        driveBackLeft = hardwareMap.get(DcMotor.class, "dbl");

        driveFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    void Move(double xPower,double yPower,double strafePower)
    {
        if (Math.abs(xPower) >= Math.abs(yPower) && Math.abs(strafePower) < 0.1){
            runMotor(driveFrontRight, xPower * MAX_TURN_SPEED);
            runMotor(driveFrontLeft, xPower * MAX_TURN_SPEED);
            runMotor(driveBackRight, xPower * MAX_TURN_SPEED);
            runMotor(driveBackLeft, xPower * MAX_TURN_SPEED);
        } else if (Math.abs(yPower) > Math.abs(xPower) && Math.abs(strafePower) < 0.1){
            runMotor(driveFrontRight, -yPower * MAX_DRIVE_SPEED);
            runMotor(driveFrontLeft, yPower * MAX_DRIVE_SPEED);
            runMotor(driveBackRight, -yPower * MAX_DRIVE_SPEED);
            runMotor(driveBackLeft, yPower * MAX_DRIVE_SPEED);
        } else {
            runMotor(driveFrontRight, strafePower * MAX_STRAFE_SPEED);
            runMotor(driveFrontLeft, strafePower * MAX_STRAFE_SPEED);
            runMotor(driveBackRight, -strafePower * MAX_STRAFE_SPEED);
            runMotor(driveBackLeft, -strafePower * MAX_STRAFE_SPEED);
        }
    }
}