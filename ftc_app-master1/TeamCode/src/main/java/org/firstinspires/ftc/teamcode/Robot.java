package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class Robot
{
    public HardwareMap hardwareMap;
    public DriveTrain driveTrain;
    public AutonomousDriveTrain autoDriveTrain;
    /*Motors*/
    //Drive

    /*public DcMotor driveFrontRight;
    public DcMotor driveFrontLeft;
    public DcMotor driveBackRight;
    public DcMotor driveBackLeft;*/

    /*public Encoder encoderRight;
    public Encoder encoderLeft;
    public Encoder encoderStrafe
     */

    //Intake
    /*
    public DcMotor intakeExtender;
    public DcMotor intakeRoller;
    public DcMotor intakeLifter;
    public Servo intakeBucket;
    */

    //Lifter
    public DcMotor lifterMotor;

    /*//Scorer
    public DcMotor scorerMotor;

    //Marker
    public Servo markerPusher;*/

    //Encoders


    void initialize(HardwareMap hardwareMap)
    {
        this.hardwareMap = hardwareMap;

        driveTrain = new DriveTrain();
        driveTrain.initialize(hardwareMap);

        autoDriveTrain = new AutonomousDriveTrain();
        autoDriveTrain.initialize(driveTrain);



        //Drivetrain


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
