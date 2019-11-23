package irc.robot.subsystems;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import irc.robot.commands.moveArm;

public class Arm extends Subsystem {
    private static Arm instance;
    public static Arm getInstance(){
        if(instance == null)
            instance = new Arm();
        return instance;
    }

    //Initializing all the motor controllers.
    private VictorSP armVictor;

    private Arm(){
        armVictor = new VictorSP(2);
    }

    public void setSpeed (double up){
        armVictor.setSpeed(up);

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new moveArm());
    }
}
