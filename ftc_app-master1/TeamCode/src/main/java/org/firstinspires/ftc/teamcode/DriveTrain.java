package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DriveTrain
{
    private static double MAX_DRIVE_SPEED  = 1.0;
    private static double MAX_TURN_SPEED   = 1.0;
    private static double MAX_STRAFE_SPEED = 0.5;//maximize w/o slippage

    public DcMotor driveFrontRight;
    public DcMotor driveFrontLeft;
    public DcMotor driveBackRight;
    public DcMotor driveBackLeft;

    void initialize(HardwareMap hardwareMap)
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

    void Move(double xPower,double yPower,double strafePower)//should work
    {
        if (Math.abs(xPower) >= Math.abs(yPower) && Math.abs(strafePower) < 0.1){
            driveFrontRight.setPower(-xPower * MAX_TURN_SPEED);
            driveFrontLeft.setPower(-xPower * MAX_TURN_SPEED);
            driveBackRight.setPower(-xPower * MAX_TURN_SPEED);
            driveBackLeft.setPower(-xPower * MAX_TURN_SPEED);
        } else if (Math.abs(yPower) > Math.abs(xPower) && Math.abs(strafePower) < 0.1){
            driveFrontRight.setPower(yPower * MAX_DRIVE_SPEED);
            driveFrontLeft.setPower(-yPower * MAX_DRIVE_SPEED);
            driveBackRight.setPower(yPower * MAX_DRIVE_SPEED);
            driveBackLeft.setPower(-yPower * MAX_DRIVE_SPEED);
        } else {
            driveFrontRight.setPower(-strafePower * MAX_STRAFE_SPEED);
            driveFrontLeft.setPower(strafePower * MAX_STRAFE_SPEED);
            driveBackRight.setPower(strafePower * MAX_STRAFE_SPEED);
            driveBackLeft.setPower(-strafePower * MAX_STRAFE_SPEED);
        }
    }
}