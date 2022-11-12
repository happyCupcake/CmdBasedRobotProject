package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;

public class DrivewithJoystick extends CommandBase {
    /** Creates a new DrivewithJoystick. */
    private final DriveTrain dt;
    private final XboxController controller;
    public DrivewithJoystick(DriveTrain drivetrain, XboxController c) {
        // Use addRequirements() here to declare subsystem dependencies.
        dt = drivetrain;
        controller = c;
        addRequirements(dt);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        dt.arcadeDrive(controller.getRawAxis(Constants.kLeftY)*Constants.arcadeDriveSpeed, controller.getRawAxis(Constants.kLeftX)*Constants.arcadeDriveSpeed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        dt.stop();
        return false;
    }
}
