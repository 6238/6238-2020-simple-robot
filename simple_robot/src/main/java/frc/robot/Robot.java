// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
    private final static int LEFT_TALON_1_ID = 11;
    private final static int LEFT_TALON_2_ID = 12;
    private final static int RIGHT_TALON_1_ID = 10;
    private final static int RIGHT_TALON_2_ID = 13;

    private final WPI_TalonSRX talonLeft1 = new WPI_TalonSRX(LEFT_TALON_1_ID);
    private final WPI_TalonSRX talonLeft2 = new WPI_TalonSRX(LEFT_TALON_2_ID);
    private final WPI_TalonSRX talonRight1 = new WPI_TalonSRX(RIGHT_TALON_1_ID);
    private final WPI_TalonSRX talonRight2 = new WPI_TalonSRX(RIGHT_TALON_2_ID);

    private final SpeedControllerGroup leftDriveMotors = new SpeedControllerGroup(talonLeft1, talonLeft2);
    private final SpeedControllerGroup rightDriveMotors = new SpeedControllerGroup(talonRight1, talonRight2);

    private final DifferentialDrive robotDrive = new DifferentialDrive(leftDriveMotors, rightDriveMotors);
    private final Joystick stick = new Joystick(0);

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
    }

    /** This function is run once each time the robot enters autonomous mode. */
    @Override
    public void autonomousInit() {
    }

    /** This function is called periodically during autonomous. */
    @Override
    public void autonomousPeriodic() {
    }

    /**
     * This function is called once each time the robot enters teleoperated mode.
     */
    @Override
    public void teleopInit() {
    }

    /** This function is called periodically during teleoperated mode. */
    @Override
    public void teleopPeriodic() {
        robotDrive.arcadeDrive(stick.getY(), stick.getX());

        System.out.println("Testing teleoperated mode.");
    }

    /** This function is called once each time the robot enters test mode. */
    @Override
    public void testInit() {
    }

    /** This function is called periodically during test mode. */
    @Override
    public void testPeriodic() {
    }
}
