package com.vvftc.ninevolt.core.hw;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.vvftc.ninevolt.util.DcMotorPair;

/**
 * Created by VVMS FTC teams on 2/23/2017.
 */

public class Hardware {
  public enum MotorMode {
    TWO_MOTORS, FOUR_MOTORS, HOLONOMIC
  }
  public enum MotorType {
    TETRIX_PITSCO, ANDYMARK
  }
  private MotorMode motorMode;
  private MotorType motorType;
  private DcMotor.ZeroPowerBehavior dfZeroPowerBehavior;


  // Motor hardware members
  public DcMotor motorFL;
  public DcMotor motorFR;
  public DcMotor motorBL;
  public DcMotor motorBR;

  public DcMotorPair motorL;
  public DcMotorPair motorR;

  // Lot to do, decide, getters and setters or public members (usually bad practice but used by
  // HW PushBot FTC sample class)

  // TODO: Write hardware class

  public Hardware() {
    dfZeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE;
  }

  public void init() throws Exception {
    if (motorMode == MotorMode.HOLONOMIC) {
      if(motorType == MotorType.ANDYMARK) {
        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.REVERSE);
        motorFR.setDirection(DcMotor.Direction.REVERSE);
        motorBR.setDirection(DcMotor.Direction.REVERSE);
      } else if (motorType == MotorType.TETRIX_PITSCO) {
        motorFL.setDirection(DcMotor.Direction.FORWARD);
        motorBL.setDirection(DcMotor.Direction.FORWARD);
        motorFR.setDirection(DcMotor.Direction.FORWARD);
        motorBR.setDirection(DcMotor.Direction.FORWARD);
      } else {
        throw new Exception("Must specify motor type");
      }
    } else if (motorMode == MotorMode.FOUR_MOTORS) {
      if(motorType == MotorType.ANDYMARK) {
        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.REVERSE);
        motorFR.setDirection(DcMotor.Direction.FORWARD);
        motorBR.setDirection(DcMotor.Direction.FORWARD);
      } else if (motorType == MotorType.TETRIX_PITSCO) {
        motorFL.setDirection(DcMotor.Direction.FORWARD);
        motorBL.setDirection(DcMotor.Direction.FORWARD);
        motorBR.setDirection(DcMotor.Direction.REVERSE);
        motorFR.setDirection(DcMotor.Direction.REVERSE);
      } else {
        throw new Exception("Must specify motor type");
      }
      motorL = new DcMotorPair(motorFL, motorBL);
      motorR = new DcMotorPair(motorFR, motorBR);
    } else if(motorMode == MotorMode.TWO_MOTORS) {
      if(motorType == MotorType.ANDYMARK) {
        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorFR.setDirection(DcMotor.Direction.FORWARD);
      } else if (motorType == MotorType.TETRIX_PITSCO) {
        motorFL.setDirection(DcMotor.Direction.FORWARD);
        motorFR.setDirection(DcMotor.Direction.REVERSE);
      } else {
        throw new Exception("Must specify motor type");
      }
      motorL = new DcMotorPair(motorFL);
      motorR = new DcMotorPair(motorFR);
    } else {
      throw new Exception("Must specify motor mode");
    }
    if (motorFL != null) {
      motorFL.setZeroPowerBehavior(dfZeroPowerBehavior);
      motorFR.setZeroPowerBehavior(dfZeroPowerBehavior);
    }
    if (motorBL != null) {
      motorBL.setZeroPowerBehavior(dfZeroPowerBehavior);
      motorBR.setZeroPowerBehavior(dfZeroPowerBehavior);
    }
  }

  public void setMotorMode(MotorMode motorMode) {
    this.motorMode = motorMode;
  }

  public void setMotorType(MotorType motorType) {
    this.motorType = motorType;
  }

  public void setMotorFL(DcMotor motorFL) {
    this.motorFL = motorFL;
  }

  public void setMotorFR(DcMotor motorFR) {
    this.motorFR = motorFR;
  }

  public void setMotorBL(DcMotor motorBL) {
    this.motorBL = motorBL;
  }

  public void setMotorBR(DcMotor motorBR) {
    this.motorBR = motorBR;
  }

  public void setDfZeroPowerBehavior(DcMotor.ZeroPowerBehavior dfZeroPowerBehavior) {
    this.dfZeroPowerBehavior = dfZeroPowerBehavior;
  }
}
