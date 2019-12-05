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
        arm = Arm.getInstance();
        requires(arm);

    }
    //Execute runs when the robot is active.
    // Here we call the setSpeed function from the Drivetrain Class, using values from the OI class's Joysticks.
    public void move(double up){
        arm.setSpeed(up);
    }
    public void execute(){

        if(oi.getLeftClicky()) {
            arm.setSpeed(0.75);
        } else if(oi.getRightClicky()){
            arm.setSpeed(-0.25);
        } else {
            arm.setSpeed(0);
        }
    }
    //We never want this command to stop, so we return false for the abstract isFinished method.
    @Override
    protected boolean isFinished() {

        return false;

    }
}