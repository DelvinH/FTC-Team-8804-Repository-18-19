package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

/**
 * Created by Delvin Huang on 10/12/2018.
 */

public class Lifter extends Robot
{
    public static final double MAX_LIFT_SPEED = 1.0;

    void initialize()
    {
        lifterMotor = hardwareMap.get(DcMotor.class, "lm");
    }

    void Lift(boolean up, boolean down)
    {

    }
}
