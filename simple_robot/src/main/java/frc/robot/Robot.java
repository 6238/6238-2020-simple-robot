// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import jdk.internal.org.objectweb.asm.commons.RemappingMethodAdapter;
import jdk.nashorn.internal.objects.annotations.SpecializedFunction;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
    private final static int LEFT_LEADER_ID = 0;
    private final static int LEFT_FOLLOWER_ID = 1;
    private final static int RIGHT_LEADER_ID = 2;
    private final static int RIGHT_FOLLOWER_ID = 3;

    private final SpeedController talonLeftLeader = new WPI_TalonSRX(LEFT_LEADER_ID);
    private final SpeedController talonLeftFollower = new WPI_TalonSRX(LEFT_FOLLOWER_ID);
    private final SpeedController talonRightLeader = new WPI_TalonSRX(RIGHT_LEADER_ID);
    private final SpeedController talonRightFollower = new WPI_TalonSRX(RIGHT_FOLLOWER_ID);
    private final DifferentialDrive m_robotDrive = new DifferentialDrive(talonLeftLeader, talonRightLeader);
    private final Joystick m_stick = new Joystick(0);
    private final Timer m_timer = new Timer();

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        talonLeftFollower.follow(talonLeftLeader);
        talonRightFollower.follow(talonRightLeader);
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
        m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
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
