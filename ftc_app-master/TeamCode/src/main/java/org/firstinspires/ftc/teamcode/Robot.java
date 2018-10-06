package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;


public class Robot
{
    /*Motors*/
    //Drive
    private DcMotor driveFrontRight;
    private DcMotor driveFrontLeft;
    private DcMotor driveBackRight;
    private DcMotor driveBackLeft;

    /*private Encoder encoderRight;
    private Encoder encoderLeft;
    private Encoder encoderStrafe
     */

    //Intake
    private DcMotor intakeMotor;
    private DcMotor intakeRoller;
    private Servo intakeBucket;

    //Lifter
    private DcMotor lifterMotor;

    //Scorer
    private DcMotor scorerMotor;

    //Marker
    private Servo markerPusher;

    void initialize(HardwareMap hardwareMap)
    {
        //Drive
        driveFrontRight = hardwareMap.get(DcMotor.class, "dfr");
        driveFrontLeft = hardwareMap.get(DcMotor.class, "dfl");
        driveBackRight = hardwareMap.get(DcMotor.class, "dbr");
        driveBackLeft = hardwareMap.get(DcMotor.class, "dbl");

        //Intake
        intakeMotor = hardwareMap.get(DcMotor.class, "im");
        intakeRoller = hardwareMap.get(DcMotor.class, "ir");
        intakeBucket = hardwareMap.get(Servo.class, "ib");

        //Lifter
        lifterMotor = hardwareMap.get(DcMotor.class, "lm");

        //Scorer
        scorerMotor = hardwareMap.get(DcMotor.class, "sm");

        //Marker
        markerPusher = hardwareMap.get(Servo.class, "mp");
    }
}
