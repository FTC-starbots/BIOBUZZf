package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.OptionalDouble;

public class Constants {

    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("lf");
        c.frontRightName.set("rf");
        c.backLeftName.set("lr");
        c.backRightName.set("rr");
        c.frontLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backRightDirection.set(DcMotorSimple.Direction.REVERSE);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.ticksPerUnit.set(OptionalDouble.of(1850.467344375));
        c.xPodOffset.set(-3.033058);
        c.yPodOffset.set(-4.114173);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.537183990506415);
                Controller secondaryTranslationalForward = Controller.proportional(0.19847513067153588);
                Controller primaryTranslationalLateral = Controller.proportional(0.2879217532157309);
                Controller secondaryTranslationalLateral = Controller.proportional(0.10637939440227506);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.011342470931715544));
                c.brake.set(Controller.proportionalFeedforward(0.009641100291958212));

                c.headingFeedback.set(Controller.proportional(3.5438955116184836));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.03704243680662433, 0.006029321792822635));

                c.linearBrakeCoefficients.set(Matrix.diag(0.08789569180487235, 0.027942441512325663));
                c.quadraticBrakeCoefficients.set(Matrix.diag(6.792415102383797E-4, 0.0018346166155369693));

                c.maxAchievableForwardVelocity.set(85.87150766238129);
                c.maxAchievableStrafeVelocity.set(69.564355386295);
                c.naturalForwardDeceleration.set(53.00177322598841);
                c.naturalStrafeDeceleration.set(66.56985598764987);
            }
    );

    public static Follower create(HardwareMap h) {
        // return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }



}