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
    functions.init();

    public void loop() {

    }
}