/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6743.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();

	public static final int LEFT_STICK_X_AXIS = 0;
	public static final int LEFT_STICK_Y_AXIS = 1;
	public static final int LEFT_TRIGGER = 2;
	public static final int RIGHT_TRIGGER = 3;
	public static final int RIGHT_STICK_X_AXIS = 4;
	public static final int RIGHT_STICK_Y_AXIS = 5;

	public static final int A_BUTTON = 1;
	public static final int B_BUTTON = 2;
	public static final int X_BUTTON = 3;
	public static final int Y_BUTTON = 4;
	public static final int LEFT_BUTTON = 5;
	public static final int RIGHT_BUTTON = 6;
	public static final int BACK_BUTTON = 7;

	Solenoid Soul = new Solenoid(1, 2);
	
	SpeedControllerGroup LeftDrive, RightDrive;

	RobotDrive RDrive;

	Joystick XCon;

	Spark FrontRight, RearRight, FrontLeft, RearLeft, LilPump;
	
	double Speed;
	double Rotation;

	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);

		FrontRight = new Spark(0);
		RearRight = new Spark(1);
		RightDrive = new SpeedControllerGroup(FrontRight, RearRight);

		FrontLeft = new Spark(2);
		RearLeft = new Spark(3);
		LeftDrive = new SpeedControllerGroup(FrontLeft, RearLeft);

		LilPump = new Spark(4);
		
		RDrive = new RobotDrive(LeftDrive,RightDrive);
		
		XCon = new Joystick(0); // depends on the usb connected to computer
	} 

	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);

	}
	boolean doOnce = true;
	@Override
	public void autonomousPeriodic() {
		// switch (m_autoSelected) {
		// case kCustomAuto:

		// while (isAutonomous() && isEnabled()) {
		
		// }

		// break;
		// case kDefaultAuto:
		// default:
		// Put default auto code here
		// break;
	}
	// }

	/**
	 * is called periodically during operator control.
	 */
	@Override
	
	public void teleopPeriodic() {
		while (isOperatorControl() && isEnabled()) {
		//	double Speed; Speed = XCon.getRawAxis(LEFT_STICK_Y_AXIS);
			//double Rotation; Rotation = XCon.getRawAxis(LEFT_STICK_X_AXIS);
		//	Speed = -1*(XCon.getRawAxis(LEFT_STICK_Y_AXIS));
		//	Rotation = -1*(XCon.getRawAxis(LEFT_STICK_X_AXIS));
            /*
  public void mecanumDrive_Polar(double magnitude,
                               double direction,
                               double rotation)          
*/
			RDrive.MecanumDrive_Polar( );
			
			if (XCon.getRawButton(B_BUTTON)) {
				LilPump.set(1);
			} else {
				LilPump.set(0);
			}
			if (XCon.getRawButton(X_BUTTON)) {
				Soul.set(true);
				
			} else {
				Soul.set(false);
			}
		}
		
		}		
	private void setSensitivity(double d) {
		// TODO Auto-generated method stub
	}
	@Override
	public void testPeriodic() {

	}
}


