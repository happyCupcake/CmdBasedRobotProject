// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hood;
import frc.robot.Constants;

public class MoveHood extends CommandBase {
  /** Creates a new MoveHood. */
  private final Hood hood;
  double target;
  double tolerance;

  public MoveHood(Hood hood, double target, double tolerance) {
    this.hood = hood;
    this.target = target;
    this.tolerance = tolerance;
    addRequirements(this.hood);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hood.resetEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    hood.setHoodPosition(target, tolerance);
    //System.out.println(hood.getPosition());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hood.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}