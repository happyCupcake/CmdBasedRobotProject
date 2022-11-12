// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
    private final CANSparkMax intakeMotor = new CANSparkMax(Constants.kIntakePort, MotorType.kBrushless);

    public Intake(){
        intakeMotor.restoreFactoryDefaults();
        intakeMotor.setInverted(Constants.kIntakeInvert);
    }

    public void on(){
        intakeMotor.set(Constants.kIntakeSpeed);
    }

    public void off(){
        intakeMotor.stopMotor();
    }
    
    @Override
    public void periodic(){}

    @Override
    public void simulationPeriodic(){}

}

