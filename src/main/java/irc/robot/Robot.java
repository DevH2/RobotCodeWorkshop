package irc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import irc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Ultrasonic;

public class Robot extends TimedRobot {
    private Ultrasonic ultra = new Ultrasonic(6,9);
    private Drivetrain drivetrain;

    // Runs once when the robot starts up.
    @Override
    public void robotInit() {
        drivetrain = Drivetrain.getInstance();
        ultra.setAutomaticMode(true);
    }

    // Runs every tick when the robot is on. It does not matter which mode the robot is in (autonomous, teleoperated, etc.)
    @Override
    public void robotPeriodic() {
        System.out.println(ultra.getRangeInches());
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
