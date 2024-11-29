package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.functions;

@TeleOp(name = "main", group = "Main Drive Function")
public class main extends OpMode {

    // Timer to track elapsed time during the OpMode
    private ElapsedTime runtime = new ElapsedTime();

    DcMotor frontL, frontR, backR, backL; // Motors for the drivetrain
    DcMotor elevatorL, elevatorR;        // Motors for the elevator mechanism
    DcMotor armL, armR;                  // Motors for the arm mechanism
    Servo clawArmL, clawArmR, clawL, clawR; // Servos for claw and arm control

    double ticks = 537.7;
    double newTarget = 0;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        try {
            frontL = hardwareMap.get(DcMotor.class, "frontL");
            frontR = hardwareMap.get(DcMotor.class, "frontR");
            backR = hardwareMap.get(DcMotor.class, "backR");
            backL = hardwareMap.get(DcMotor.class, "backL");
            elevatorL = hardwareMap.get(DcMotor.class, "elevatorL");
            elevatorR = hardwareMap.get(DcMotor.class, "elevatorR");
            armL = hardwareMap.get(DcMotor.class, "armL");
            armR = hardwareMap.get(DcMotor.class, "armR");
            clawArmL = hardwareMap.get(Servo.class, "clawArmL");
            clawArmR = hardwareMap.get(Servo.class, "clawArmR");
            clawL = hardwareMap.get(Servo.class, "clawL");
            clawR = hardwareMap.get(Servo.class, "clawR");

            if (frontL == null || frontR == null || backL == null || backR == null) {
                telemetry.addData("Error", "Motors not initialized correctly!");
            }
        } catch (Exception e) {
            telemetry.addData("Error", "Initialization Failed: " + e.getMessage());
        }
    }

    public void loop() {
        updateTelemetry();

        private static final double DEAD_ZONE = 0.1;

        double x = Math.abs(gamepad1.right_stick_x) > DEAD_ZONE ? gamepad1.right_stick_x : 0.0;
        double y = Math.abs(gamepad1.right_stick_y) > DEAD_ZONE ? -gamepad1.right_stick_y : 0.0;
        double rot = Math.abs(gamepad1.left_stick_x) > DEAD_ZONE ? gamepad1.left_stick_x : 0.0;

        double elevatorPower = -gamepad2.right_stick_y;
        double armPower = -gamepad2.left_stick_y;

        // Calculate power for each drivetrain motor using mecanum wheel equations
        double frontRPower = y - x - rot;
        double frontLPower = y + x + rot;
        double backRPower = y + x - rot;
        double backLPower = y - x + rot;

        // Ensure the motor power is between -1.0 and 1.0
        frontRPower = Range.clip(frontRPower, -1.0, 1.0);
        frontLPower = Range.clip(frontLPower, -1.0, 1.0);
        backRPower = Range.clip(backRPower, -1.0, 1.0);
        backLPower = Range.clip(backLPower, -1.0, 1.0);

        frontL.setPower(frontLPower);
        frontR.setPower(frontRPower);
        backL.setPower(backLPower);
        backR.setPower(backRPower);

        frontL.setPower(1.0);
        sleep(1000);
        frontL.setPower(0.0);
    }
}

private void updateTelemetry() {
    telemetry.addData("left arm Ticks:", armL.getCurrentPosition());
    telemetry.addData("right arm Ticks:", armR.getCurrentPosition());
    telemetry.update();
}