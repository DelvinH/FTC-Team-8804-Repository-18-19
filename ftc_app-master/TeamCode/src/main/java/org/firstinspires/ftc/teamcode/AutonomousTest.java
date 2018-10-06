package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.*;


@Autonomous(name="Encoder: Drive Test", group = "Autonomous")
public class AutonomousTest {
    Robot robot = new Robot();
    private ElapsedTime runtime = new ElapsedTime();

    static final double COUNT_PER_MOTOR_REV     = 1680;
    static final double GEAR_REDUCTION          = 1.0;
    static final double WHEEL_DIAMETER_INCHES   = 4.0;
    static final double COUNTS_PER_INCH         = (COUNT_PER_MOTOR_REV * GEAR_REDUCTION /
                                                    WHEEL_DIAMETER_INCHES * Math.PI);

    static final double DRIVE_SPEED             = 0.5;
    static final double TURN_SPEED              = 0.5;

    @Override
    public void runOpMode()
    {
        robot.init(hardwareMap);
    }

    public void encoderDrive(double speed, double distance, double timeout)
    {
        int newTarget;

        if (opModeIsActive())
        {
<<<<<<< HEAD
            newFrontLeftTarget = robot.driveFrontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
            newFrontRightTarget = robot.driveFrontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
            newBackLeftTarget = robot.driveFrontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
            newBackRightTarget = robot.driveFrontRight.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

            robot.driveFrontLeft.setTargetPosition(newFrontLeftTarget);
            robot.driveFrontRight.setTargetPosition(newFrontRightTarget);
            robot.driveBackLeft.setTargetPosition(newBackLeftTarget);
            robot.driveBackRight.setTargetPosition(newBackRightTarget);

            robot.driveFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.driveFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.driveBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.driveBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            robot.driveFrontLeft.setPower(Math.abs(speed));
            robot.driveFrontRight.setPower(Math.abs(speed));
            robot.driveBackLeft.setPower(Math.abs(speed));
            robot.driveBackRight.setPower(Math.abs(speed));

            while (opModeIsActive() && runtime.seconds() < timeout &&
                    robot.driveFrontLeft.isBusy() && robot.driveFrontRight.isBusy() &&
                    robot.driveBackLeft.isBusy() && robot.driveBackRight.isBusy())
            {
                telemetry.addData("Path1",  "Running to %7d :%7d %7d :%7d", newFrontLeftTarget,
                                newFrontRightTarget, newBackLeftTarget, newBackRightTarget);
                telemetry.addData("Path2",  "Running at %7d :%7d :%7d :%7d",
                        robot.driveFrontLeft.getCurrentPosition(),
                        robot.driveFrontRight.getCurrentPosition(),
                        robot.driveBackLeft.getCurrentPosition(),
                        robot.driveBackRight.getCurrentPosition());
                telemetry.update();
            }

            robot.driveFrontLeft.setPower(0);
            robot.driveFrontRight.setPower(0);
            robot.driveBackLeft.setPower(0);
            robot.driveBackRight.setPower(0);

            robot.driveFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.driveFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.driveBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.driveBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
=======
>>>>>>> acc81bea11fd0861d85892bc3fb87ada6fa52c39

        }
    }
}
