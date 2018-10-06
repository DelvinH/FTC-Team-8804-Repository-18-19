
import com.qualcomm.robotcore.hardware.*;

public class DriveTrain
{
    private DcMotor driveFrontRight = Robot.driveFrontRight;
    private DcMotor driveFrontLeft = Robot.driveFrontLeft;
    private DcMotor driveBackRight = Robot.driveBackRight;
    private DcMotor driveBackLeft = Robot.driveBackLeft;

    private static double MAX_DRIVE_SPEED = 1;
    void Move(double xPower,double yPower,double strafePower)
    {
        if (Math.abs(xPower) >= Math.abs(yPower) && Math.abs(strafePower) < 0.1){
            driveFrontRight.setPower(xPower * MAX_DRIVE_SPEED);
            driveFrontLeft.setPower(xPower * MAX_DRIVE_SPEED);
            driveBackRight.setPower(xPower * MAX_DRIVE_SPEED);
            driveBackLeft.setPower(xPower * MAX_DRIVE_SPEED);
        } else if (Math.abs(yPower) > Math.abs(xPower) && Math.abs(strafePower) < 0.1){
            driveFrontRight.setPower(yPower * MAX_DRIVE_SPEED);
            driveFrontLeft.setPower(yPower * MAX_DRIVE_SPEED);
            driveBackRight.setPower(-yPower * MAX_DRIVE_SPEED);
            driveBackLeft.setPower(-yPower * MAX_DRIVE_SPEED);
        } else {
            driveFrontRight.setPower(strafePower * MAX_DRIVE_SPEED);
            driveFrontLeft.setPower(strafePower * MAX_DRIVE_SPEED);
            driveBackRight.setPower(strafePower * MAX_DRIVE_SPEED);
            driveBackLeft.setPower(strafePower * MAX_DRIVE_SPEED);
        }
    }
}