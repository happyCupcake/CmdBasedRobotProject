// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.MathUtil;

public class MoveArmtoPosition extends CommandBase {
  private Arm arm;
  private double targetPosition;
  private double kP;
  private double tolerance;


  public MoveArmtoPosition(Arm arm, double targetPosition, double kP, double tolerance) {
    this.arm = arm;
    this.targetPosition = targetPosition;
    this.kP = kP;
    this.tolerance = tolerance;

    addRequirements(this.arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double dif = targetPosition - arm.getPosition();
    double speed = MathUtil.clamp(kP*dif, -0.3, 0.3);
    arm.arm(speed);
    System.out.println(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(targetPosition - arm.getPosition()) < tolerance;
  }
}
