// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.FunnelCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.Auto.AutoCommand;
import frc.robot.commands.Auto.IntakeGroupCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FunnelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  Joystick m_driveController = new Joystick(JoystickConstants.F310);

  DriveSubsystem m_robotDrive = new DriveSubsystem();
  IntakeSubsystem m_intake = new IntakeSubsystem();
  FunnelSubsystem m_funnel = new FunnelSubsystem();
  ShooterSubsystem m_shooter = new ShooterSubsystem();
  ClimbSubsystem m_climb = new ClimbSubsystem();
  AutoCommand m_auto = new AutoCommand(m_funnel,m_shooter,m_robotDrive);
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_robotDrive.setDefaultCommand(
        new DriveCommand(m_robotDrive, () -> m_driveController.getRawAxis(1), () -> -m_driveController.getRawAxis(4)));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Top Alma
    new JoystickButton(m_driveController, 1).whileHeld(new IntakeCommand(m_intake, 0.8));
    // Top Geri Bırakma
    new JoystickButton(m_driveController, 2).whileHeld(new IntakeCommand(m_intake, -0.8));
    // Top Alma ve Taşıma
    new JoystickButton(m_driveController, 3).whileHeld(new IntakeGroupCommand(m_intake, m_funnel, 0.5));
    // Top Alma ve Taşıma Geri Bırakma
    new JoystickButton(m_driveController, 4).whileHeld(new IntakeGroupCommand(m_intake, m_funnel, -0.5));
    // Funnel Top Taşıma
    new JoystickButton(m_driveController, 5).whileHeld(new FunnelCommand(m_funnel, 0.8));
    // Funnel Top Taşıma Geri
    new JoystickButton(m_driveController, 6).whileHeld(new FunnelCommand(m_funnel, -0.8));
    // Top Atma
    new JoystickButton(m_driveController, 7).whileHeld(new ShooterCommand(m_shooter, 1));
    // Tırmanma
    new JoystickButton(m_driveController, 7).whileHeld(new ClimbCommand(m_climb, 5));
    // Tırmanma Geri
    new JoystickButton(m_driveController, 7).whileHeld(new ClimbCommand(m_climb, -1));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_auto;
  }
}
