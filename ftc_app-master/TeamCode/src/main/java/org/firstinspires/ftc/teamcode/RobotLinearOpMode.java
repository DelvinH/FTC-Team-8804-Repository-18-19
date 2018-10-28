package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "PlayerControl", group = "LinearOpMode")
public class RobotLinearOpMode extends LinearOpMode
{
    Robot robot = new Robot();
    DriveTrain driveTrain = new DriveTrain();
    Intake intake = new Intake();
    Lifter lifter = new Lifter();

    @Override
    public void runOpMode()
    {
        robot.initialize(hardwareMap);
        driveTrain.initialize();
        intake.initialize();

        waitForStart();

        while (opModeIsActive()) {
            double turnInput = gamepad1.left_stick_x;
            double driveInput = gamepad1.left_stick_y;
            double strafeInput = gamepad1.right_stick_x;

            boolean extenderOut = gamepad1.dpad_up;
            boolean extenderIn = gamepad1.dpad_down;
            boolean rollerIn = gamepad1.right_bumper;
            boolean rollerOut = gamepad1.left_bumper;
            boolean bucketToggle = gamepad1.y;
            boolean lifterToggle = gamepad1.a;//available buttons: r/l trigger, rsticky, r/lstick down, dpad r/l, x, b

            driveTrain.Move(turnInput, driveInput, strafeInput);

            intake.Extender(extenderIn, extenderOut);
            intake.Lifter(lifterToggle);
            intake.Roller(rollerIn, rollerOut);
            intake.Bucket(bucketToggle);
        }
    }
}
