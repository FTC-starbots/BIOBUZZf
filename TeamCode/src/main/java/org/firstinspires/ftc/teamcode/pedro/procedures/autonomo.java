package org.firstinspires.ftc.teamcode.pedro.procedures;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous
public class autonomo
        extends OpMode {

    private DcMotorEx outtake_1;
    private DcMotorEx outtake_2;
    private static final double OUTTAKE_VELOCITY = 1000;



    @Override
    public void init() {
        outtake_1 = hardwareMap.get(DcMotorEx.class, "outtake_1");
        outtake_2 = hardwareMap.get(DcMotorEx.class, "outtake_2");
        outtake_1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        outtake_2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }



    @Override
    public void loop() {
        if (gamepad1.a) {
            outtake_1.setVelocity(OUTTAKE_VELOCITY);
            outtake_2.setVelocity(OUTTAKE_VELOCITY);
        } else {
            outtake_1.setVelocity(0);
            outtake_2.setVelocity(0);
        }

        telemetry.addData ("velociade1",outtake_1.getVelocity() );
        telemetry.addData ("velociade2",outtake_2.getVelocity() );

    }
}
