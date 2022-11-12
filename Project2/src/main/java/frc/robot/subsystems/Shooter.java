// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;


public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private final WPI_TalonFX left = new WPI_TalonFX(Constants.ShooterMotorPortLeft);
  private final WPI_TalonFX right = new WPI_TalonFX(Constants.ShooterMotorPortRight);

  public Shooter() {
    right.follow(left);

    left.configFactoryDefault();
    right.configFactoryDefault();

    left.setInverted(Constants.ShooterInvert);
    right.setInverted(InvertType.OpposeMaster);

    left.setNeutralMode(NeutralMode.Coast);
    right.setNeutralMode(NeutralMode.Coast);

  }

  public void setShooterSpeed(double speed){
    left.set(ControlMode.PercentOutput, speed);
    right.set(ControlMode.PercentOutput, speed);
  }

  public void stopShooter(){
    left.set(ControlMode.PercentOutput, 0);
    //don't need to do set right? it's following left
    right.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}