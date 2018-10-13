package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "PlayerControl", group = "LinearOpMode")
public class RobotLinearOpMode extends LinearOpMode
{
    Robot robot = new Robot();
    DriveTrain driveTrain = new DriveTrain();
    //Intake intake = new Intake();

    @Override
    public void runOpMode()
    {
        robot.initialize(hardwareMap);
        driveTrain.initialize(robot.driveFrontRight, robot.driveFrontLeft, robot.driveBackRight, robot.driveBackLeft);
        //intake.initialize(robot.intakeExtender, robot.intakeLifter, robot.intakeRoller, robot.intakeBucket);

        waitForStart();

        while (opModeIsActive()) {
            double turnInput = gamepad1.left_stick_x;
            double driveInput = gamepad1.left_stick_y;
            double strafeInput = gamepad1.right_stick_x;
            boolean extenderOut = gamepad1.dpad_up;
            boolean extenderIn = gamepad1.dpad_down;
            boolean intakeLifterUp = gamepad1.dpad_right;
            boolean intakeLifterDown = gamepad1.dpad_left;
            boolean rollerIn = gamepad1.right_bumper;
            boolean rollerOut = gamepad1.left_bumper;

            driveTrain.Move(turnInput, driveInput, strafeInput);
        }
    }
}
