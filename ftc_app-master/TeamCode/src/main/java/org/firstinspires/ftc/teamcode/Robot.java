package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class Robot
{
    public HardwareMap hardwareMap;
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

    //Lifter
    public DcMotor lifterMotor;

    /*//Scorer
    public DcMotor scorerMotor;

    //Marker
    public Servo markerPusher;*/

    //Encoders
    public DcMotor rightEncoder;
    public DcMotor leftEncoder;
    public DcMotor strafeEncoder;

    void initialize(HardwareMap hardwareMap)
    {
        this.hardwareMap = hardwareMap;




        /*//Lifter
        lifterMotor = hardwareMap.get(DcMotor.class, "lm");

        //Scorer
        scorerMotor = hardwareMap.get(DcMotor.class, "sm");

        //Marker
        markerPusher = hardwareMap.get(Servo.class, "mp");*/
    }

    void runMotor(DcMotor dcMotor, double speed)
    {
        dcMotor.setPower(speed);
    }
}
