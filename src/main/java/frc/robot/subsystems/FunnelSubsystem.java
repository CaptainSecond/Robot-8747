// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FunnelConstants;

public class FunnelSubsystem extends SubsystemBase {
  /** Creates a new FunnelSubsystem. */
  PWMVictorSPX FunnelMotor = new PWMVictorSPX(FunnelConstants.kFunnelMotorOutput);
  public FunnelSubsystem() {}

  public void runFunnel(double m_speed){
    FunnelMotor.set(m_speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
