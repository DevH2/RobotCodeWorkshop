package irc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import irc.robot.OI;
import irc.robot.Robot;
import irc.robot.subsystems.Arm;
import irc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Ultrasonic;

public class moveArm extends Command {

    private OI oi;
    private Arm arm;

    //Getting OI and Drivetrain instances to run commands with.
    public moveArm(){

        oi = OI.getInstance();
        arm = arm.getInstance();
        requires(arm);

    }
    //Execute runs when the robot is active.
    // Here we call the setSpeed function from the Drivetrain Class, using values from the OI class's Joysticks.
    public void move(double up){
        arm.setSpeed(up);
    }

    //We never want this command to stop, so we return false for the abstract isFinished method.
    @Override
    protected boolean isFinished() {

        return false;

    }
}