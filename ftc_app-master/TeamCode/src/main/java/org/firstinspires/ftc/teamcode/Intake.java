package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class Intake
{
    private DcMotor intakeExtender;
    private DcMotor intakeLifter;
    private DcMotor intakeRoller;
    private Servo intakeBucket;

    private static double MAX_EXTENDER_SPEED = 0.5;
    private static double MAX_LIFTER_SPEED   = 0.3;
    private static double MAX_ROLLER_SPEED   = 1.0;
    private static double SERVO_POSITION_UP   = 0.7;
    private static double SERVO_POSITION_DOWN = 0.3;
    private boolean toggleHelper = true;
    private boolean servoStatus = true;//true = down

    void initialize(DcMotor intakeExtender, DcMotor intakeLifter, DcMotor intakeRoller, Servo intakeBucket)
    {
        this.intakeExtender = intakeExtender;
        this.intakeLifter = intakeLifter;
        this.intakeRoller = intakeRoller;
        this.intakeBucket = intakeBucket;
    }

    void Extender (boolean in, boolean out)
    {
        if (in)
        {
            intakeExtender.setPower(MAX_EXTENDER_SPEED);
        } else if (out) {
            intakeExtender.setPower(MAX_EXTENDER_SPEED);
        } else {
            intakeExtender.setPower(0);
        }
    }

    void Lifter (boolean in, boolean out)
    {
        if (in)
        {
            intakeLifter.setPower(MAX_LIFTER_SPEED);
        } else if (out) {
            intakeLifter.setPower(MAX_LIFTER_SPEED);
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
            intakeRoller.setPower(MAX_ROLLER_SPEED);
        } else {
            intakeRoller.setPower(0);
        }
    }

    void Bucket (boolean toggle)
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
