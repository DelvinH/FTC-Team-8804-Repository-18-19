package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;


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
    /*public DcMotor intakeMotor;
    public DcMotor intakeRoller;
    public Servo intakeBucket;

    //Lifter
    public DcMotor lifterMotor;

    //Scorer
    public DcMotor scorerMotor;

    //Marker
    public Servo markerPusher;*/

    void init(HardwareMap hardwareMap)
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
        /*intakeMotor = hardwareMap.get(DcMotor.class, "im");
        intakeRoller = hardwareMap.get(DcMotor.class, "ir");
        intakeBucket = hardwareMap.get(Servo.class, "ib");

        //Lifter
        lifterMotor = hardwareMap.get(DcMotor.class, "lm");

        //Scorer
        scorerMotor = hardwareMap.get(DcMotor.class, "sm");

        //Marker
        markerPusher = hardwareMap.get(Servo.class, "mp");*/
    }
}
