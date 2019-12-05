package irc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import irc.robot.subsystems.Arm;
import irc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Ultrasonic;

public class Robot extends TimedRobot {
    //private Ultrasonic ultra = new Ultrasonic(6,9);
    private Drivetrain drivetrain;
    private Arm arm;
    // Runs once when the robot starts up.
    @Override
    public void robotInit() {
        drivetrain = Drivetrain.getInstance();
        arm = Arm.getInstance();
        //ultra.setAutomaticMode(true);
    }

    // Runs every tick when the robot is on. It does not matter which mode the robot is in (autonomous, teleoperated, etc.)
    @Override
    public void robotPeriodic() {
        //System.out.println(ultra.getRangeInches());
    }

    // Runs once when autonomous starts.
    private int run;
    @Override
    public void autonomousInit() {
        run = 0;
    }

    // Runs every tick during autonomous.
    @Override
    public void autonomousPeriodic() {
        run++;
        if(run < 100)
            drivetrain.setSpeed(0.3, 0.3);
        else if(run < 130)
            drivetrain.setSpeed(-0.5, 0.5);
        else if(run < 150)
            drivetrain.setSpeed(0.3, 0.3);
        else if (run < 225){
            arm.setSpeed(0.75);
            drivetrain.setSpeed(0,0);
        }
        else if(run < 275)
            arm.setSpeed(-0.2);

    }

    // Runs once when teleoperated starts.
    @Override
    public void teleopInit(){
        drivetrain.setSpeed(0, 0);
    }

    // Runs every tick during teleoperated.
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

    }

}