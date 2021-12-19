// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
    private final static int LEFT_LEADER_ID = 10;
    private final static int LEFT_FOLLOWER_ID = 13;
    private final static int RIGHT_LEADER_ID = 11;
    private final static int RIGHT_FOLLOWER_ID = 12;

    private final WPI_TalonSRX talonLeftLeader = new WPI_TalonSRX(LEFT_LEADER_ID);
    private final WPI_TalonSRX talonLeftFollower = new WPI_TalonSRX(LEFT_FOLLOWER_ID);
    private final WPI_TalonSRX talonRightLeader = new WPI_TalonSRX(RIGHT_LEADER_ID);
    private final WPI_TalonSRX talonRightFollower = new WPI_TalonSRX(RIGHT_FOLLOWER_ID);
    private final DifferentialDrive robotDrive = new DifferentialDrive(talonLeftLeader, talonRightLeader);
    private final Joystick m_stick = new Joystick(0);

    private final DoubleSolenoid doubleSolenoid = new DoubleSolenoid(0, 1);

    private static final int kDoubleSolenoidForward = 3;
    private static final int kDoubleSolenoidReverse = 4;

    @Override
    public void robotInit() {
        talonLeftFollower.follow(talonLeftLeader);
        talonRightFollower.follow(talonRightLeader);
        talonRightFollower.setInverted(true);
    }

    @Override
    public void autonomousInit() {}
    @Override
    public void autonomousPeriodic() {}
    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() {
        robotDrive.arcadeDrive(m_stick.getX(), m_stick.getY());

        System.out.println("Testing pneumatics system.");

        if (m_stick.getRawButton(kDoubleSolenoidForward)) {
            doubleSolenoid.set(DoubleSolenoid.Value.kForward);
        } else if (m_stick.getRawButton(kDoubleSolenoidReverse)) {
            doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
    }

    @Override
    public void testInit() {}
    @Override
    public void testPeriodic() {}
}
