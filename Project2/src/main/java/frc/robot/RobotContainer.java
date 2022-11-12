// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Arm arm;
  private final Climber climber;
  private final Indexer indexer;
  private final Intake intake;
  private final DriveTrain dt;
  private final Shooter shooter;
  private final Hood hood;

  private final DriveForDistance driveDistance;
  private final DrivewithJoystick driveJoystick;
  private final SetShooterSpeed shooterSpeed;
  private final MoveHood moveHood;

  //private final IndexBall indexBall;
  //private final MoveArmtoPosition movearmtoPosition;

  private final XboxController controller1;
  private final XboxController controller2;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    arm = new Arm();
    climber = new Climber();
    indexer = new Indexer();
    intake = new Intake();
    dt = new DriveTrain();
    shooter = new Shooter();
    hood = new Hood();

    controller1 = new XboxController(Constants.kController1Port);
    controller2 = new XboxController(Constants.kController2Port);

    driveDistance = new DriveForDistance(dt, Constants.dist);
    driveJoystick = new DrivewithJoystick(dt, controller2);
    shooterSpeed = new SetShooterSpeed(shooter);
    moveHood = new MoveHood(hood, Constants.target, Constants.tolerance);

    //indexBall = new IndexBall(indexer);
    //movearmtoPosition = new MoveArmtoPosition(arm, Constants.armtarget, Constants.armkP, Constants.armtolerance);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton armUpButton = new JoystickButton(controller2, XboxController.Button.kA.value);
    armUpButton.whenPressed(new MoveArmtoPosition(arm, Constants.armUptarget, Constants.armkP, Constants.armtolerance));

    JoystickButton armDownButton = new JoystickButton(controller2, XboxController.Button.kB.value);
    armDownButton.whenPressed(new MoveArmtoPosition(arm, Constants.armDowntarget, Constants.armkP, Constants.armtolerance));

    JoystickButton indexButton = new JoystickButton(controller2, XboxController.Button.kX.value);
    indexButton.whenPressed(new IndexBall(indexer));

    JoystickButton hoodButton = new JoystickButton(controller2, XboxController.Button.kY.value);
    hoodButton.whenPressed(new MoveHood(hood, 3, 0.3));

    JoystickButton shooterButton = new JoystickButton(controller2, XboxController.Button.kLeftBumper.value);
    shooterButton.whenPressed(new SetShooterSpeed(shooter));

    /*
    new JoystickButton(controller1, Button.kRightBumper.value).whenPressed(
    new InstantCommand(() -> climber.rotate(0.3)));

    new JoystickButton(controller1, Button.kLeftBumper.value).whenPressed(
    new InstantCommand(() -> climber.rotate(-0.3)));

    new JoystickButton(controller2, Button.kRightBumper.value).whenPressed(
    new InstantCommand(() -> intake.on()));

    new JoystickButton(controller2, Button.kLeftBumper.value).whenPressed(
    new InstantCommand(() -> intake.off()));

    */
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    return driveDistance;
  }
}
