package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

/**
 * Created by Richik SC on 3/21/2017.
 */

@TeleOp(name = "Learn Robotics Teleop", group = "After-school Club")
public class ClubStdTeleOpMode extends OpMode {
  private Hardware hardware;
  private Movement movement;

  @Override
  public void init() {
    try {
      HardwareBuilder hb = new HardwareBuilder(hardwareMap);
      hb.setMotorConfig(Hardware.MotorMode.TWO_MOTORS, Hardware.MotorType.TETRIX_PITSCO);
      hb.addMotorFL("motorL").addMotorFR("motorR");
      hardware = hb.build();
      hb = null;
      hardware.init();
      movement = new Movement(hardware, this);
    } catch (Exception ex) {
      ExceptionHandling.standardExceptionHandling(ex, this);
    }
  }

  @Override
  public void loop() {
    movement.directTankDrive(gamepad1.left_stick_y, gamepad1.right_stick_y);
  }
}
