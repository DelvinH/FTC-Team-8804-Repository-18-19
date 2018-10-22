package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "OddQuadAutonomousOpMode", group ="Autonomous")
public class OddAutonomousOpMode extends LinearOpMode {
    Robot robot = new Robot();
    AutonomousDriveTrain aDriveTrain = new AutonomousDriveTrain();
    //Intake intake = new Intake();
    Lifter lifter = new Lifter();


    public static double RIGHT_TRAIN_SPEED = 0.9;//calibrate
    public static double LEFT_TRAIN_SPEED = 1.0;//calibrate

    public int step = 1;

    @Override
    public void runOpMode() {
        robot.initialize(hardwareMap);
        //aDriveTrain.initialize();

        waitForStart();

        /*while (opModeIsActive()) {
            if (step1) {//land and score
                runStep1();
            } else if (step2) {//go to jewel and knock jewel
                runStep2();
            } else if (step3) {//go to depot and score
                runStep3();
            } else if (step4) {//go to crater and park
                runStep4();
            }
        }*/
    }

    public void runStep1() {
        lifter.Lift(true); //Lower yourself from hook
    }

    public void runStep2() {

    }

}
