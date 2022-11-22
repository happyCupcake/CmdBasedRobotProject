// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.*;


public class Hood extends SubsystemBase {
  /** Creates a new Hood. */

  private final CANSparkMax hoodMotor = new CANSparkMax(Constants.hoodMotorPort, MotorType.kBrushless);
  RelativeEncoder hoodEncoder;

  public Hood() {
    hoodEncoder = hoodMotor.getEncoder();
    hoodEncoder.setPosition(0);
    hoodMotor.restoreFactoryDefaults();
  }

  public void setSpeed(double speed){
    hoodMotor.set(speed);
  }

  public double getPosition(){
    return hoodEncoder.getPosition();
  }

  public void setHoodPosition(double target, double tolerance){
    double error = target - getPosition();
    if(Math.abs(error)> tolerance){
      setSpeed(MathUtil.clamp((error * Constants.hoodkP), -0.3, 0.3));
      if(target>0 && getPosition()> target){
        setSpeed(0);
      }else if(target<0 && getPosition() < target){
        setSpeed(0);
      }
    }else{
      setSpeed(0);
    }
  }

  public void resetEncoder(){
    hoodEncoder.setPosition(0);
  }

  public void stopMotor(){
    setSpeed(0);
  }
    

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}