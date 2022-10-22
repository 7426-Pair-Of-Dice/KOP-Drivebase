package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Drive {
    
    // Declaring all of the motor controller instances
    private static VictorSPX leftMotorOne;
    private static VictorSPX leftMotorTwo;
    private static VictorSPX rightMotorOne;
    private static VictorSPX rightMotorTwo;

    public Drive() {
        // Defining all of the motor controller instances
        leftMotorOne = new VictorSPX(Constants.Drive.kLeftMotorOneId);
        leftMotorTwo = new VictorSPX(Constants.Drive.kLeftMotorTwoId);
        rightMotorOne = new VictorSPX(Constants.Drive.kRightMotorOneId);
        rightMotorTwo = new VictorSPX(Constants.Drive.kRightMotorTwoId);

        // Setting all of their configurations to the factory default
        leftMotorOne.configFactoryDefault();
        leftMotorTwo.configFactoryDefault();
        rightMotorOne.configFactoryDefault();
        rightMotorTwo.configFactoryDefault();

        // Setting up a following system, so that you only have to set one motor
        leftMotorOne.follow(leftMotorTwo);
        rightMotorOne.follow(rightMotorTwo);

        // Inverting the left side of the drive train so that both the left and right go in the same direction
        leftMotorOne.setInverted(true);
        leftMotorTwo.setInverted(true);
    }

    // Drives in a standard tank drive configuration, given left and right values from -1 to 1
    public void drive(double leftInput, double rightInput) {
        leftMotorTwo.set(ControlMode.PercentOutput, leftInput);
        rightMotorTwo.set(ControlMode.PercentOutput, rightInput);
    }

    // Inverts the entire drive, useful if drive is not automatically aligned to the front of your robot
    public void invert() {
        leftMotorOne.setInverted(false);
        leftMotorTwo.setInverted(false);

        rightMotorOne.setInverted(true);
        rightMotorTwo.setInverted(true);
    }
}
