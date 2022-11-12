// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private final CANSparkMax armMotor = new CANSparkMax(Constants.kArmPort, MotorType.kBrushless);
  private RelativeEncoder armEncoder;

  public Arm() {
    armMotor.restoreFactoryDefaults();
    armMotor.setInverted(Constants.kArmInvert);
    armEncoder = armMotor.getEncoder();
    armEncoder.setPosition(0);
  }

  public void arm(double speed) {
    armMotor.set(speed);
  }

  public void stop() {
    armMotor.stopMotor();
  }

  public double getPosition() {
    return armEncoder.getPosition();
  }

  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
