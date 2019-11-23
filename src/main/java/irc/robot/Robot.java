package irc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import irc.robot.subsystems.Drivetrain;

public class Robot extends TimedRobot {

    private Drivetrain drivetrain;

    // Runs once when the robot starts up.
    @Override
    public void robotInit() {
        drivetrain = Drivetrain.getInstance();
    }

    // Runs every tick when the robot is on. It does not matter which mode the robot is in (autonomous, teleoperated, etc.)
    @Override
    public void robotPeriodic() {
    }

    // Runs once when autonomous starts.
    @Override
    public void autonomousInit() {
    }

    // Runs every tick during autonomous.
    @Override
    public void autonomousPeriodic() {

        Scheduler.getInstance().run();

    }

    // Runs once when teleoperated starts.
    @Override
    public void teleopInit(){
    }

    // Runs every tick during teleoperated.
    @Override
    public void teleopPeriodic() {

        Scheduler.getInstance().run();

    }

}