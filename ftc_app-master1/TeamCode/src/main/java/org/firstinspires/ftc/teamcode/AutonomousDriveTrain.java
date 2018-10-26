package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class AutonomousDriveTrain {

    public DriveTrain drivetrain;
    public DcMotor rightEncoder;
    public DcMotor leftEncoder;
    public DcMotor strafeEncoder;

    public LocationPoint location;
    public double orientation;

    public LocationPoint originalLocation;
    public double originalOrientation;

    private ElapsedTime runtime = new ElapsedTime();

    static final double PPR = 1440;
    static final double WHEEL_DIAMETER_INCHES = 4.0;
    static final double COUNTS_PER_INCH = PPR * 1 / (WHEEL_DIAMETER_INCHES * Math.PI);
    static final double COUNTS_PER_DEGREE = 0;

    static final double DRIVE_SPEED = 0.05;
    static final double TURN_SPEED = 0.5;
    static final double STRAFE_SPEED = 0.3;

    void initialize(DriveTrain drivetrain) {
        this.drivetrain = drivetrain;

        leftEncoder = drivetrain.driveFrontLeft;
        rightEncoder = drivetrain.driveFrontRight;
        //strafeEncoder = driveBackRight;

        leftEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //strafeEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //strafeEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    void driveTo(LocationPoint target, double power) {//called once, not in loop
        originalLocation = new LocationPoint(location.getX(), location.getY());
        double targetDistance = originalLocation.getDistanceTo(target);
        double targetOrientation = originalLocation.getAngleTo(target);//may not work

        turnTo(targetOrientation, power); //turn toward target
        encoderDrive(power * DRIVE_SPEED, targetDistance, 10);//drive toward target
    }

    void turnTo(double target, double power) {
        originalOrientation = orientation;
        int turn_direction = (target - originalOrientation > 0)? 1:-1;
        encoderTurn(turn_direction * power * TURN_SPEED, Math.abs(target - originalOrientation), 10); //counterclockwise is neg
    }


    void updateLocation() {
        int avg_encoder = (Math.abs(leftEncoder.getCurrentPosition()) + Math.abs(rightEncoder.getCurrentPosition())) / 2;
        double avg_distance = avg_encoder / COUNTS_PER_INCH;
        location.setX(originalLocation.x + avg_distance * Math.cos(orientation));
        location.setY(originalLocation.y + avg_distance * Math.sin(orientation));
    }

    void updateOrientation() {
        int avg_encoder = (Math.abs(leftEncoder.getCurrentPosition()) + Math.abs(rightEncoder.getCurrentPosition()))/2;
        double avg_degrees = avg_encoder / COUNTS_PER_DEGREE;
        orientation += avg_degrees;
    }
    
    public void encoderDrive(double power, double distance, double timeout) {//distance must be positive; goes forward distance inches
        if (distance < 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }

        int targetEncoderPosition = (int) (distance * COUNTS_PER_INCH);

        leftEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //strafeEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int absLeftEncoderPos = Math.abs(leftEncoder.getCurrentPosition());
        int absRightEncoderPos = Math.abs(rightEncoder.getCurrentPosition());

        runtime.reset();

        while (absLeftEncoderPos < targetEncoderPosition && absRightEncoderPos < targetEncoderPosition && runtime.seconds() < timeout) {
            if (absLeftEncoderPos - absRightEncoderPos > 0) {
                drivetrain.driveFrontRight.setPower(-power * DRIVE_SPEED);
                drivetrain.driveFrontLeft.setPower(power * DRIVE_SPEED * (1 - .01 * (absLeftEncoderPos - absRightEncoderPos)));
                drivetrain.driveBackRight.setPower(-power * DRIVE_SPEED);
                drivetrain.driveBackLeft.setPower(power * DRIVE_SPEED * (1 - .01 * (absLeftEncoderPos - absRightEncoderPos)));
            } else if (absRightEncoderPos - absLeftEncoderPos > 0) {
                drivetrain.driveFrontRight.setPower(-power * DRIVE_SPEED * (1 - .01 * (absRightEncoderPos - absLeftEncoderPos)));
                drivetrain.driveFrontLeft.setPower(power * DRIVE_SPEED);
                drivetrain.driveBackRight.setPower(-power * DRIVE_SPEED * (1 - .01 * (absRightEncoderPos - absLeftEncoderPos)));
                drivetrain.driveBackLeft.setPower(power * DRIVE_SPEED);
            } else {
                drivetrain.driveFrontRight.setPower(-power * DRIVE_SPEED);
                drivetrain.driveFrontLeft.setPower(power * DRIVE_SPEED);
                drivetrain.driveBackRight.setPower(-power * DRIVE_SPEED);
                drivetrain.driveBackLeft.setPower(power * DRIVE_SPEED);
            }
            absLeftEncoderPos = Math.abs(leftEncoder.getCurrentPosition());
            absRightEncoderPos = Math.abs(rightEncoder.getCurrentPosition());
            updateLocation();
        }
        drivetrain.driveFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drivetrain.driveFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drivetrain.driveBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drivetrain.driveBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        drivetrain.driveFrontLeft.setPower(0);
        drivetrain.driveFrontRight.setPower(0);
        drivetrain.driveBackLeft.setPower(0);
        drivetrain.driveBackRight.setPower(0);



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

    public void encoderTurn(double power, double degrees, double timeout) { //Negative power for left turn
        if (degrees < 0) {
            throw new IllegalArgumentException("Angle must be positive");
        }

        int targetEncoderPosition = (int) (degrees * COUNTS_PER_DEGREE);

        leftEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //strafeEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int absLeftEncoderPos = Math.abs(leftEncoder.getCurrentPosition());
        int absRightEncoderPos = Math.abs(rightEncoder.getCurrentPosition());

        runtime.reset();

        while (absLeftEncoderPos < targetEncoderPosition && absRightEncoderPos < targetEncoderPosition && runtime.seconds() < timeout) {
            /*if (absLeftEncoderPos - absRightEncoderPos > 0) {
                drivetrain.driveFrontRight.setPower(-power * DRIVE_SPEED);
                drivetrain.driveFrontLeft.setPower(-power * DRIVE_SPEED * (1 - .01 * (absLeftEncoderPos - absRightEncoderPos)));
                drivetrain.driveBackRight.setPower(-power * DRIVE_SPEED);
                drivetrain.driveBackLeft.setPower(-power * DRIVE_SPEED * (1 - .01 * (absLeftEncoderPos - absRightEncoderPos)));
            } else if (absRightEncoderPos - absLeftEncoderPos > 0) {
                drivetrain.driveFrontRight.setPower(-power * DRIVE_SPEED * (1 - .01 * (absRightEncoderPos - absLeftEncoderPos)));
                drivetrain.driveFrontLeft.setPower(-power * DRIVE_SPEED);
                drivetrain.driveBackRight.setPower(-power * DRIVE_SPEED * (1 - .01 * (absRightEncoderPos - absLeftEncoderPos)));
                drivetrain.driveBackLeft.setPower(-power * DRIVE_SPEED);
            } else {*/
            drivetrain.driveFrontRight.setPower(power * TURN_SPEED);
            drivetrain.driveFrontLeft.setPower(power * TURN_SPEED);
            drivetrain.driveBackRight.setPower(power * TURN_SPEED);
            drivetrain.driveBackLeft.setPower(power * TURN_SPEED);
                //}
                absLeftEncoderPos = Math.abs(leftEncoder.getCurrentPosition());
                absRightEncoderPos = Math.abs(rightEncoder.getCurrentPosition());
                updateOrientation();
            }

            drivetrain.driveFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            drivetrain.driveFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            drivetrain.driveBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            drivetrain.driveBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            drivetrain.driveFrontLeft.setPower(0);
            drivetrain.driveFrontRight.setPower(0);
            drivetrain.driveBackLeft.setPower(0);
            drivetrain.driveBackRight.setPower(0);
        }

    /*public void encoderStrafe(double power, double distance, double timeout) { //Positive for right
        if (distance < 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }

        int targetEncoderPosition = (int) (distance * COUNTS_PER_INCH);

        //leftEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //rightEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        strafeEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //leftEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //rightEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        strafeEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //int absLeftEncoderPos = Math.abs(leftEncoder.getCurrentPosition());
        //int absRightEncoderPos = Math.abs(rightEncoder.getCurrentPosition());
        int absStrafeEncoderPos = Math.abs(strafeEncoder.getCurrentPosition());

        runtime.reset();

        while (absStrafeEncoderPos < targetEncoderPosition && runtime.seconds() < timeout) {
            /*if (absLeftEncoderPos - absRightEncoderPos > 0) {
                drivetrain.driveFrontRight.setPower(-power * DRIVE_SPEED);
                drivetrain.driveFrontLeft.setPower(-power * DRIVE_SPEED * (1 - .01 * (absLeftEncoderPos - absRightEncoderPos)));
                drivetrain.driveBackRight.setPower(-power * DRIVE_SPEED);
                drivetrain.driveBackLeft.setPower(-power * DRIVE_SPEED * (1 - .01 * (absLeftEncoderPos - absRightEncoderPos)));
            } else if (absRightEncoderPos - absLeftEncoderPos > 0) {
                drivetrain.driveFrontRight.setPower(-power * DRIVE_SPEED * (1 - .01 * (absRightEncoderPos - absLeftEncoderPos)));
                drivetrain.driveFrontLeft.setPower(-power * DRIVE_SPEED);
                drivetrain.driveBackRight.setPower(-power * DRIVE_SPEED * (1 - .01 * (absRightEncoderPos - absLeftEncoderPos)));
                drivetrain.driveBackLeft.setPower(-power * DRIVE_SPEED);
            } else {*/
            /*drivetrain.driveFrontRight.setPower(-power * STRAFE_SPEED);
            drivetrain.driveFrontLeft.setPower(-power * STRAFE_SPEED);
            drivetrain.driveBackRight.setPower(-power * STRAFE_SPEED);
            drivetrain.driveBackLeft.setPower(-power * STRAFE_SPEED);
            //}
            //absLeftEncoderPos = Math.abs(leftEncoder.getCurrentPosition());
            //absRightEncoderPos = Math.abs(rightEncoder.getCurrentPosition());
            absStrafeEncoderPos = Math.abs(strafeEncoder.getCurrentPosition());
        }
        drivetrain.driveFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drivetrain.driveFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drivetrain.driveBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drivetrain.driveBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        drivetrain.driveFrontLeft.setPower(0);
        drivetrain.driveFrontRight.setPower(0);
        drivetrain.driveBackLeft.setPower(0);
        drivetrain.driveBackRight.setPower(0);
    }

    public LocationPoint updateLocation() {
        return location;
    }

    public double updateOrientation() {
        return orientation;
    }*/
    //}
}
