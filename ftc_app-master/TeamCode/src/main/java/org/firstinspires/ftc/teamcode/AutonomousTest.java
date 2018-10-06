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

        }
    }
}
