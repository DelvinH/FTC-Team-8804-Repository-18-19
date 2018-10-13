package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DriveTrain extends Robot
{
    private DcMotor driveFrontRight;
    private DcMotor driveFrontLeft;
    private DcMotor driveBackRight;
    private DcMotor driveBackLeft;

    private static double MAX_DRIVE_SPEED  = 1.0;
    private static double MAX_TURN_SPEED   = 1.0;
    private static double MAX_STRAFE_SPEED = 0.3;

    void initialize(DcMotor driveFrontRight, DcMotor driveFrontLeft, DcMotor driveBackRight, DcMotor driveBackLeft)
    {
        this.driveFrontRight = driveFrontRight;
        this.driveFrontLeft = driveFrontLeft;
        this.driveBackRight = driveBackRight;
        this.driveBackLeft = driveBackLeft;
    }

    void Move(double xPower,double yPower,double strafePower)
    {
        if (Math.abs(xPower) >= Math.abs(yPower) && Math.abs(strafePower) < 0.1){
            driveFrontRight.setPower(xPower * MAX_TURN_SPEED);
            driveFrontLeft.setPower(xPower * MAX_TURN_SPEED);
            driveBackRight.setPower(xPower * MAX_TURN_SPEED);
            driveBackLeft.setPower(xPower * MAX_TURN_SPEED);
        } else if (Math.abs(yPower) > Math.abs(xPower) && Math.abs(strafePower) < 0.1){
            driveFrontRight.setPower(yPower * MAX_DRIVE_SPEED);
            driveFrontLeft.setPower(yPower * MAX_DRIVE_SPEED);
            driveBackRight.setPower(-yPower * MAX_DRIVE_SPEED);
            driveBackLeft.setPower(-yPower * MAX_DRIVE_SPEED);
        } else {
            driveFrontRight.setPower(strafePower * MAX_STRAFE_SPEED);
            driveFrontLeft.setPower(strafePower * MAX_STRAFE_SPEED);
            driveBackRight.setPower(strafePower * MAX_STRAFE_SPEED);
            driveBackLeft.setPower(strafePower * MAX_STRAFE_SPEED);
        }
    }
}