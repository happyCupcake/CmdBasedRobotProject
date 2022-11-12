// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
    private final CANSparkMax IndexerMotor = new CANSparkMax(Constants.kIndexerPort, MotorType.kBrushless);

    public Indexer() {
        IndexerMotor.restoreFactoryDefaults();
        IndexerMotor.setInverted(Constants.kIndexerInvert);
    }

    public void on(){
        IndexerMotor.set(Constants.kIndexerSpeed);
    }

    public void off(){
        IndexerMotor.stopMotor();
    }

    @Override
    public void periodic(){}

    @Override
    public void simulationPeriodic(){}
}
