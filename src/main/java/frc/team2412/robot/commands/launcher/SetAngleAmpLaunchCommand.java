package frc.team2412.robot.commands.launcher;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.team2412.robot.subsystems.LauncherSubsystem;
// this command can be used as a preset in controls, allowing the user to input a speed and angle
// value when they keybind it multiple times.

public class SetAngleAmpLaunchCommand extends Command {
	private double launcherSpeed;
	private double launcherAngle;
	private LauncherSubsystem launcherSubsystem;

	public SetAngleAmpLaunchCommand(LauncherSubsystem launcherSubsystem, double speed, double angle) {
		launcherSpeed = speed;
		launcherAngle = angle;
		this.launcherSubsystem = launcherSubsystem;
		addRequirements(launcherSubsystem);
	}

	@Override
	public void initialize() {
		launcherSubsystem.setAngle(launcherAngle);
		launcherSubsystem.ampLaunch(launcherSpeed);
		launcherSubsystem.manualSetpoint(launcherAngle);
	}

	@Override
	public boolean isFinished() {
		return MathUtil.isNear(
				launcherAngle, launcherSubsystem.getAngle(), LauncherSubsystem.ANGLE_TOLERANCE);
	}
}
