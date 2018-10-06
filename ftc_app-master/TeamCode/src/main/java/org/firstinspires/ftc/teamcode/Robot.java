package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;


public class Robot
{
    /*Motors*/
    //Drive
    DcMotor driveFrontRight;
    DcMotor driveFrontLeft;
    DcMotor driveBackRight;
    DcMotor driveBackLeft;

    /*private Encoder encoderRight;
    private Encoder encoderLeft;
    private Encoder encoderStrafe
     */

    //Intake
    DcMotor intakeMotor;
    DcMotor intakeRoller;
    Servo intakeBucket;

    //Lifter
    DcMotor lifterMotor;

    //Scorer
    DcMotor scorerMotor;

    //Marker
    private Servo markerPusher;

    void init(HardwareMap hardwareMap)
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
