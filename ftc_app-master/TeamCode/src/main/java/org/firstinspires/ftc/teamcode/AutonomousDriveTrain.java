package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class AutonomousDriveTrain extends DriveTrain {

    private ElapsedTime runtime = new ElapsedTime();

    static final double COUNT_PER_MOTOR_REV     = 1680;
    static final double GEAR_REDUCTION          = 0.5;
    static final double WHEEL_DIAMETER_INCHES   = 4.0;
    static final double COUNTS_PER_INCH         = (COUNT_PER_MOTOR_REV * GEAR_REDUCTION /
            WHEEL_DIAMETER_INCHES / Math.PI);

    static final double DRIVE_SPEED             = 0.3;
    static final double TURN_SPEED              = 0.5;

    void initialize() {
        leftEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        strafeEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        strafeEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void encoderDrive(double power, double distance, double timeout) {

        int newLeftTarget = leftEncoder.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        int newRightTarget = rightEncoder.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

        leftEncoder.setTargetPosition(newLeftTarget);
        rightEncoder.setTargetPosition(-newRightTarget);

        leftEncoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightEncoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        /*driveFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        driveFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        driveBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        driveBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);*/

        runtime.reset();
        driveFrontLeft.setPower(Math.abs(power));
        driveFrontRight.setPower(-Math.abs(power));
        driveBackLeft.setPower(Math.abs(power));
        driveBackRight.setPower(-Math.abs(power));

        while (leftEncoder.isBusy() && rightEncoder.isBusy()){
            if(leftEncoder.getCurrentPosition()-rightEncoder.getCurrentPosition() > 10) {
                driveFrontLeft.setPower(Math.abs(power) * 0.9);
                driveFrontRight.setPower(-Math.abs(power) * 1.1);
                driveBackLeft.setPower(Math.abs(power) * 0.9);
                driveBackRight.setPower(-Math.abs(power) * 1.1);
            } else if (rightEncoder.getCurrentPosition() - leftEncoder.getCurrentPosition() > 10) {
                driveFrontLeft.setPower(Math.abs(power) * 1.1);
                driveFrontRight.setPower(-Math.abs(power) * 0.9);
                driveBackLeft.setPower(Math.abs(power) * 1.1);
                driveBackRight.setPower(-Math.abs(power) * 0.9);
            }
        }

        driveFrontLeft.setPower(0);
        driveFrontRight.setPower(0);
        driveBackLeft.setPower(0);
        driveBackRight.setPower(0);

        leftEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
}
