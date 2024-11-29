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

@TeleOp(name="main", group="Main Drive Function")
public class main extends OpMode
{
    private ElapsedTime runtime = new ElapsedTime();

    DcMotor frontL;
    DcMotor frontR;
    DcMotor backR;
    DcMotor backL;
    DcMotor elevatorL;
    DcMotor elevatorR;
    DcMotor armL;
    DcMotor armR;
    Servo clawArmL;
    Servo clawArmR;
    Servo clawL;
    Servo clawR;

    double ticks = 537.7;
    double newTarget = 0;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

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

        frontL.setDirection(DcMotor.Direction.REVERSE);
        elevatorL.setDirection(DcMotor.Direction.REVERSE);

        runtime.reset();
    }

    public void loop() {

        telemetry.addData("left arm Ticks:", armL.getCurrentPosition());
        telemetry.addData("right arm Ticks:", armR.getCurrentPosition());

        double x = gamepad1.right_stick_x; // left stick x is responsible for the robots horizontal movement
        double y = - gamepad1.right_stick_y; // left stick y is responsible for the robots forward and backward movement
        double rot = gamepad1.left_stick_x; // right stick yx is responsible for the rotation of the robot
        double elevatorPower = - gamepad2.right_stick_y; // reponsible for the elevation of the elvator
        double armPower = - gamepad2.left_stick_y; // responsible for the movement of the arm

        double frontRPower = y - x - rot;
        double frontLPower = y + x + rot;
        double backRPower = y + x - rot;
        double backLPower = y - x + rot;

        frontL.setPower(1.0);
        sleep(1000);
        frontL.setPower(0.0);

    }
}