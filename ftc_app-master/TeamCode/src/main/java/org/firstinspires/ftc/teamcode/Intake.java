package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Intake extends Robot
{
    private ElapsedTime elapsedTime = new ElapsedTime();

    private static double MAX_EXTENDER_SPEED = 0.5;
    private static double MAX_LIFTER_SPEED   = 0.3;
    private static double MAX_ROLLER_SPEED   = 1.0;

    private static double SERVO_POSITION_UP   = 0.7;
    private static double SERVO_POSITION_DOWN = 0.3;

    private boolean lifterHelper = true;
    private boolean lifterStatus = true;//true = down
    private double lifterStartTime = 0;
    private static double LIFTER_TIME_UP = 500;
    private static double LIFTER_TIME_DOWN = 400;

    private boolean bucketHelper = true;
    private boolean bucketStatus = true;//true = down
    private double bucketStartTime = 0;
    private static double BUCKET_TIME_UP = 500;
    private static double ROLLER_BUCKET_SPEED = 0.3;

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
            runMotor(intakeExtender, MAX_EXTENDER_SPEED);
        } else if (out) {
            runMotor(intakeExtender, -MAX_EXTENDER_SPEED);
        } else {
            runMotor(intakeExtender, 0);
        }
    }

    void Lifter (boolean toggle)
    {
        if (toggle & lifterHelper && intakeLifter.getPower() == 0)
        {
            lifterHelper = false;
            lifterStartTime = elapsedTime.milliseconds();
            if (lifterStatus) {
                runMotor(intakeLifter, MAX_LIFTER_SPEED);
                lifterStatus = !lifterStatus;
            } else if (!lifterStatus) {
                runMotor(intakeLifter, -MAX_LIFTER_SPEED);
                lifterStatus = !lifterStatus;
            }
        }
        if (!toggle && !lifterHelper)
        {
             lifterHelper = true;
        }
        if (!lifterStatus && elapsedTime.milliseconds() - lifterStartTime > LIFTER_TIME_UP && intakeLifter.getPower() != 0)
        {
            runMotor(intakeLifter, 0);
        } else if (lifterStatus && elapsedTime.milliseconds() - lifterStartTime > LIFTER_TIME_DOWN && intakeLifter.getPower() != 0)
        {
            runMotor(intakeLifter, 0);
        }
    }


    void Roller (boolean in, boolean out)
    {
        if (in)
        {
            runMotor(intakeRoller, MAX_ROLLER_SPEED);
        } else if (out) {
            runMotor(intakeRoller, MAX_ROLLER_SPEED);
        } else {
            runMotor(intakeRoller, 0);
        }
    }

    void Bucket (boolean toggle)//make roller spin when bucket goes up
    {
        if (toggle && bucketHelper)
        {
            bucketHelper = false;
            bucketStartTime = elapsedTime.milliseconds();
            if (bucketStatus)
            {
                intakeBucket.setPosition(SERVO_POSITION_UP);
                runMotor(intakeRoller, ROLLER_BUCKET_SPEED);
                bucketStatus = !bucketStatus;
            } else if (!bucketStatus)
            {
                intakeBucket.setPosition(SERVO_POSITION_DOWN);
                runMotor(intakeRoller, -ROLLER_BUCKET_SPEED);
                bucketStatus = !bucketStatus;
            }
        }
        if (!toggle && !bucketHelper)
        {
            bucketHelper = true;
        }
        if (elapsedTime.milliseconds() - bucketStartTime > BUCKET_TIME_UP && intakeRoller.getPower() != 0)
        {
            runMotor(intakeRoller, 0);
        }
    }
}
