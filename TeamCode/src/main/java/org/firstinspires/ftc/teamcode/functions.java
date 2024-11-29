package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

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