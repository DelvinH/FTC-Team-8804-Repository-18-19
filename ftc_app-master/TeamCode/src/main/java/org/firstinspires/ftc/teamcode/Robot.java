package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;
import com.sun.tools.javac.tree.DCTree;


public class Robot
{
    /*Motors*/
    //Drive

    public DcMotor driveFrontRight;
    public DcMotor driveFrontLeft;
    public DcMotor driveBackRight;
    public DcMotor driveBackLeft;

    /*public Encoder encoderRight;
    public Encoder encoderLeft;
    public Encoder encoderStrafe
     */

    //Intake
    public DcMotor intakeExtender;
    public DcMotor intakeRoller;
    public DcMotor intakeLifter;
    public Servo intakeBucket;

    /*//Lifter
    public DcMotor lifterMotor;

    //Scorer
    public DcMotor scorerMotor;

    //Marker
    public Servo markerPusher;*/

    void initialize(HardwareMap hardwareMap)
    {
        //Drive
        driveFrontRight = hardwareMap.get(DcMotor.class, "dfr");
        driveFrontLeft = hardwareMap.get(DcMotor.class, "dfl");
        driveBackRight = hardwareMap.get(DcMotor.class, "dbr");
        driveBackLeft = hardwareMap.get(DcMotor.class, "dbl");

        driveFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Intake
        //intakeExtender = hardwareMap.get(DcMotor.class, "ie");
        //intakeLifter = hardwareMap.get(DcMotor.class, "il");
        //intakeRoller = hardwareMap.get(DcMotor.class, "ir");
        //intakeBucket = hardwareMap.get(Servo.class, "ib");

        //intakeExtender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //intakeLifter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //intakeRoller.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /*//Lifter
        lifterMotor = hardwareMap.get(DcMotor.class, "lm");

        //Scorer
        scorerMotor = hardwareMap.get(DcMotor.class, "sm");

        //Marker
        markerPusher = hardwareMap.get(Servo.class, "mp");*/
    }
}
