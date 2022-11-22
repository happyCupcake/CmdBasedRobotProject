// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Indexer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IndexBall extends CommandBase {
    private Indexer indexer;

    public IndexBall(Indexer indexer) {
        this.indexer = indexer;
        addRequirements(this.indexer);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        indexer.on();
    }

    @Override
    public void end (boolean interrupted) {
        indexer.off();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
