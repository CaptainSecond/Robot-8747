// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Joystick
    public static final class JoystickConstants {
        public static final int F310 = 0;
        public static final int joystick = 1;
    }

    // Sürüş
    public static final class DriveConstants {
        public static final int kLeftMasterMotorOutput = 0;
        public static final int kRightMasterMotorOutput = 1;
    }

    // Top Alma
    public static final class IntakeConstants {
        public static final int kIntakeMotorOutput = 2;
    }

    // Top Taşıma
    public static final class FunnelConstants {
        public static final int kFunnelMotorOutput = 3;
    }

    // Top Fırlatma
    public static final class ShooterConstants {
        public static final int kShooterMotorOutput = 4;
        //DIO public static final byte encodara = 0;
        //DIO public static final byte encodarb = 1;
    }

    // Tırmanma
    public static final class ClimbConstants {
        public static final int kClimbMotorOutput = 5;
        //public static final int kSClimbSlaveMotorOutput = 6;
    }

}
