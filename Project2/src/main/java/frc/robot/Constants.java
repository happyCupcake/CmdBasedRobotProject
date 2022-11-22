// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //arm
    public static final int kArmPort = 23;
    public static final boolean kArmInvert = true; //?
    public static double armUptarget = 0; //change
    public static double armDowntarget = 14; //change
    public static double armkP = 0.2;
    public static double armtolerance = 2;

    //climber
    //public static final int kLeftClimberPort = 5;
    //public static final int kRightClimberPort = 14;
    public static final boolean kLeftClimberInvert = false; //?
    public static final boolean kRightClimberInvert = false; //?

    //drivetrain
    public static final int leftMaster = 3;
    public static final int rightMaster = 1;
    public static final int leftFollower = 4;
    public static final int rightFollower = 2;
    public static final boolean leftInverted = true;
    public static final boolean rightInverted = false;

    public static final double arcadeDriveSpeed = 0.5;
    public static double EncoderTicks = 2048;
    public static double kP = 0.6;
    public static double kD = 0.1;
    public static double dist = 3.0;

    public static final int kLeftX = 2;
    public static final int kRightX = 4;
    public static final int kLeftY = 1;
    public static final int kRightY = 5;
    public static final int controllerPort = 0;

    //indexer
    public static final int kIndexerPort = 25;
    public static final boolean kIndexerInvert = false; //?
    public static final double kIndexerSpeed = 0.5;    

    //intake
    public static final int kIntakePort = 8;
    public static final boolean kIntakeInvert = false; //?
    public static final double kIntakeSpeed = 0.5;

    //shooter
    //public static int ShooterMotorPortLeft = 5;
    public static int ShooterMotorPortRight = 21;
    public static boolean ShooterInvert = false;
    public static double shooterSpeed = 0.3; 

    //hood
    public static int hoodMotorPort = 22;
    public static double hoodkP = 0.3;
    public static double target = -10.0;
    public static double tolerance = 1.0;

    //controllers
    public static final int kController1Port = 0; //? for driving
    public static final int kController2Port = 1; //? for other

    //SkyWalkers8404
}
