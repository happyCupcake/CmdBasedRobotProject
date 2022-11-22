// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
    private final CANSparkMax leftClimber = new CANSparkMax(Constants.kLeftClimberPort, MotorType.kBrushless);
    private final CANSparkMax rightClimber = new CANSparkMax(Constants.kRightClimberPort, MotorType.kBrushless);
    
    public Climber() {
        leftClimber.restoreFactoryDefaults();
        rightClimber.restoreFactoryDefaults();
        leftClimber.setInverted(Constants.kLeftClimberInvert);
        rightClimber.setInverted(Constants.kRightClimberInvert);
    }

    public void rotate(double speed){
        leftClimber.set(speed); //inverted?
        rightClimber.set(speed);
    }

    @Override
    public void periodic(){}

    @Override
    public void simulationPeriodic(){}

}*/
