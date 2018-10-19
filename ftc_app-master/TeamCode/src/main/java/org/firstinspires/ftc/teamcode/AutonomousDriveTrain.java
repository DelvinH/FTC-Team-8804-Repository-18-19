package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class AutonomousDriveTrain extends DriveTrain {

    private ElapsedTime runtime = new ElapsedTime();

    static final double PPR                     = 90;
    static final double WHEEL_DIAMETER_INCHES   = 4.0;
    static final double COUNTS_PER_INCH         = PPR * 1 / (WHEEL_DIAMETER_INCHES * Math.PI);

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

    public void encoderDrive(double power, double distance, double timeout) {//distance must be positive; goes forward distance inches
        if (distance < 0) {
            throw new IllegalArgumentException("Distance must be negative");
        }

        int targetEncoderPosition = (int) (distance * COUNTS_PER_INCH);

        initialize();//resets encoders

        while (Math.abs(leftEncoder.getCurrentPosition()) < targetEncoderPosition || Math.abs(rightEncoder.getCurrentPosition()) < targetEncoderPosition) {
            if (leftEncoder.getCurrentPosition() - rightEncoder.getCurrentPosition() > 0) {
                runMotor(driveFrontRight, power);
                runMotor(driveFrontLeft, power * (1 - .01 * leftEncoder.getCurrentPosition() - rightEncoder.getCurrentPosition()));
                runMotor(driveBackRight, power);
                runMotor(driveBackLeft, power * (1 - .01 * leftEncoder.getCurrentPosition() - rightEncoder.getCurrentPosition()));
            } else if (rightEncoder.getCurrentPosition() - leftEncoder.getCurrentPosition() > 0) {
                runMotor(driveFrontRight, power * (1 - .01 * rightEncoder.getCurrentPosition() - leftEncoder.getCurrentPosition()));
                runMotor(driveFrontLeft, power);
                runMotor(driveBackRight, power * (1 - .01 * rightEncoder.getCurrentPosition() - leftEncoder.getCurrentPosition()));
                runMotor(driveBackLeft, power);
            } else {
                runMotor(driveFrontRight,power);
                runMotor(driveFrontLeft, power);
                runMotor(driveBackRight, power);
                runMotor(driveBackLeft, power);
            }
        }

        runMotor(driveFrontLeft,0);
        runMotor(driveFrontRight,0);
        runMotor(driveBackLeft, 0);
        runMotor(driveBackRight, 0);



        /*int newLeftTarget = leftEncoder.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);
        int newRightTarget = rightEncoder.getCurrentPosition() + (int)(distance * COUNTS_PER_INCH);

        leftEncoder.setTargetPosition(newLeftTarget);
        rightEncoder.setTargetPosition(-newRightTarget);

        leftEncoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightEncoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        /*driveFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        driveFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        driveBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        driveBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);*/

        /*runtime.reset();
        driveFrontLeft.setPower(Math.abs(power));
        driveFrontRight.setPower(-Math.abs(power));
        driveBackLeft.setPower(Math.abs(power));
        driveBackRight.setPower(-Math.abs(power));

        while (leftEncoder.isBusy() && rightEncoder.isBusy()){
            if(leftEncoder.getCurrentPosition()-rightEncoder.getCurrentPosition() > 10) {
                driveFrontLeft.setPower(Math.abs(power) * 0.95);
                driveFrontRight.setPower(-Math.abs(power) * 1.05);
                driveBackLeft.setPower(Math.abs(power) * 0.95);
                driveBackRight.setPower(-Math.abs(power) * 1.05);
            } else if (rightEncoder.getCurrentPosition() - leftEncoder.getCurrentPosition() > 10) {
                driveFrontLeft.setPower(Math.abs(power) * 1.05);
                driveFrontRight.setPower(-Math.abs(power) * 0.95);
                driveBackLeft.setPower(Math.abs(power) * 1.05);
                driveBackRight.setPower(-Math.abs(power) * 0.95);
            }
        }

        driveFrontLeft.setPower(0);
        driveFrontRight.setPower(0);
        driveBackLeft.setPower(0);
        driveBackRight.setPower(0);

        leftEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/

    }
}
