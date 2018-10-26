package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "OddQuadAutonomousOpMode", group ="Autonomous")
public class OddAutonomousOpMode extends LinearOpMode {
    Robot robot = new Robot();
    //AutonomousDriveTrain aDriveTrain = new AutonomousDriveTrain();
    //Intake intake = new Intake();
    //Lifter lifter = new Lifter();


    public static double DRIVE_SPEED = 0.5;//calibrate
    public static double STRAFE_SPEED = 0.5;
    public static double TURN_SPEED = 0.5;
    //public static double LEFT_TRAIN_SPEED = 1.0;//calibrate

    //FILL IN CONSTANTS
    public static double vuf_turn = 0;

    public LocationPoint view_minerals;
    public double view_minerals_orien;

    public int step = 1;

    @Override
    public void runOpMode() {
        robot.initialize(hardwareMap);
        //aDriveTrain.initialize();

        waitForStart();

        while (opModeIsActive()) {
            if (step == 1) {//land and locate position
                runStep1();
            } else if (step == 2) {//go to jewel and knock jewel
                runStep2();
            } else if (step == 3) {//go to depot and score
                runStep3();
            } else if (step == 4) {//go to crater and park
                runStep4();
            }
        }
    }

    public void runStep1() {
        lifter.Lift(true); //Lower yourself from hook
        robot.autoDriveTrain.encoderDrive(DRIVE_SPEED,3,2); //Disengage from the hook
        robot.autoDriveTrain.encoderStrafe(STRAFE_SPEED,3,2);
        robot.autoDriveTrain.encoderTurn(TURN_SPEED, vuf_turn, 2);
        //Vuforia locate orientation
        step = 2;
    }

    public void runStep2() {
        robot.autoDriveTrain.driveTo(view_minerals, DRIVE_SPEED);
        robot.autoDriveTrain.turnTo(view_minerals_orien, TURN_SPEED);
        //Scan minerals logic
        //Hit mineral
    }

    public void runStep3() {
        //Navigate to depot
        //Drop off marker
    }

    public void runStep4() {
        //Navigate to crater
        //Drive into crater
    }

}
