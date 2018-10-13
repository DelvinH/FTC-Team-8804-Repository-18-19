package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class Intake extends Robot
{
    private static double MAX_EXTENDER_SPEED = 0.5;
    private static double MAX_LIFTER_SPEED   = 0.3;
    private static double MAX_ROLLER_SPEED   = 1.0;
    private static double SERVO_POSITION_UP   = 0.7;
    private static double SERVO_POSITION_DOWN = 0.3;
    private boolean toggleHelper = true;
    private boolean servoStatus = true;//true = down

    void initialize()
    {
        intakeExtender = hardwareMap.get(DcMotor.class, "ie");
        intakeLifter = hardwareMap.get(DcMotor.class, "il");
        intakeRoller = hardwareMap.get(DcMotor.class, "ir");
        intakeBucket = hardwareMap.get(Servo.class, "ib");

        intakeExtender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeLifter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeRoller.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    void Extender (boolean in, boolean out)
    {
        if (in)
        {
            intakeExtender.setPower(MAX_EXTENDER_SPEED);
        } else if (out) {
            intakeExtender.setPower(-MAX_EXTENDER_SPEED);
        } else {
            intakeExtender.setPower(0);
        }
    }

    void Lifter (boolean up, boolean down)//cheese coroutine
    {
        if (up)
        {
            intakeLifter.setPower(MAX_LIFTER_SPEED);
        } else if (down) {
            intakeLifter.setPower(-MAX_LIFTER_SPEED);
        } else {
            intakeLifter.setPower(0);
        }
    }

    void Roller (boolean in, boolean out)
    {
        if (in)
        {
            intakeRoller.setPower(MAX_ROLLER_SPEED);
        } else if (out) {
            intakeRoller.setPower(-MAX_ROLLER_SPEED);
        } else {
            intakeRoller.setPower(0);
        }
    }

    void Bucket (boolean toggle)//make roller spin when bucket goes up
    {
        if (toggle && toggleHelper)
        {
            toggleHelper = false;
            if (servoStatus)
            {
                intakeBucket.setPosition(SERVO_POSITION_UP);
                servoStatus = !servoStatus;
            } else if (!servoStatus)
            {
                intakeBucket.setPosition(SERVO_POSITION_DOWN);
                servoStatus = !servoStatus;
            }
        }

        if (!toggle && !toggleHelper)
        {
            toggleHelper = true;
        }

    }
}
