package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.*;

public class DriveTrain extends SubsystemBase {
    WPI_TalonFX talonLFront;
    WPI_TalonFX talonRFront;
    WPI_TalonFX talonLBack;
    WPI_TalonFX talonRBack;

    MotorControllerGroup leftMotors;
    MotorControllerGroup rightMotors;

    private final DifferentialDrive drive;

    public DriveTrain() {
        talonLFront = new WPI_TalonFX(Constants.leftMaster);
        talonRFront = new WPI_TalonFX(Constants.rightMaster);
        talonLBack = new WPI_TalonFX(Constants.leftFollower);
        talonRBack = new WPI_TalonFX(Constants.rightFollower);
    
        leftMotors = new MotorControllerGroup(talonLBack, talonLFront);
        rightMotors = new MotorControllerGroup(talonRBack, talonRFront);
    
        drive = new DifferentialDrive(leftMotors, rightMotors);
    
        talonLFront.configFactoryDefault();
        talonLBack.configFactoryDefault();
        talonRFront.configFactoryDefault();
        talonRBack.configFactoryDefault();talonLFront.setNeutralMode(NeutralMode.Brake);
        talonRFront.setNeutralMode(NeutralMode.Brake);
        talonLBack.setNeutralMode(NeutralMode.Brake);
        talonRBack.setNeutralMode(NeutralMode.Brake);
    
        talonLBack.follow(talonLFront);
        talonRBack.follow(talonRFront);
    
        leftMotors.setInverted(Constants.leftInverted);
        rightMotors.setInverted(Constants.rightInverted);
    
        talonLFront.set(ControlMode.PercentOutput,0);
        talonRFront.set(ControlMode.PercentOutput,0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void driveLeftMotors(double speed){
        talonLFront.set(ControlMode.PercentOutput, speed);
    }

    public void driveRightMotors(double speed){
        talonRFront.set(ControlMode.PercentOutput, speed);
    }

    public void arcadeDrive(double fwd, double rot) {
        drive.arcadeDrive(fwd, rot);
    }

    public void stop(){
        drive.stopMotor();
    }

    public void resetEncoders() {
        talonLFront.setSelectedSensorPosition(0);
        talonRBack.setSelectedSensorPosition(0);
    }

    public double getLeftEncoderPosition(){
        return talonLFront.getSelectedSensorPosition();
    }

    public double getRightEncoderPosition(){
        return talonRFront.getSelectedSensorPosition();
    }
}
