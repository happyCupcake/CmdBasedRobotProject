package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;

public class DriveForDistance extends CommandBase {
    /** Creates a new DriveForDistance. */
    private final DriveTrain dt;
    double prevError;
    double dist;

    public DriveForDistance(DriveTrain drivetrain, double dist) {
        // Use addRequirements() here to declare subsystem dependencies.
        this.dist = dist;
        dt = drivetrain;
        prevError = dist;
        addRequirements(dt);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        dt.resetEncoders();
        System.out.println("init");
    }


    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double error = dist - dt.getLeftEncoderPosition()/Constants.EncoderTicks;
        double errorRate = (prevError - error)/20;
        double speed = Constants.kP * error + Constants.kD * errorRate;
        prevError = error;

        if(dist > 0 && speed>0.5){
        speed = 0.5;
        }else if(dist <0 && speed<-0.5){
        speed = -0.5;
        }

        if(Math.abs(error)>0){
            dt.arcadeDrive(speed, 0);
            //System.out.println("speed: " +speed + "   error: "+ error);
        }
    } 

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        dt.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {     
        return false;
    }
}
