package irc.robot;

import edu.wpi.first.wpilibj.Joystick;

// The OI class links together physical controls with commands on the robot.

public class OI {

    // This is a singleton. Learn more about singletons here: https://www.geeksforgeeks.org/singleton-class-java/
    private static OI instance;
    public static OI getInstance() {
        if (instance == null)
            instance = new OI();
        return instance;
    }

    // Initializing two Joysticks and giving them ports.
    private Joystick leftJoy, rightJoy;

    private OI() {

        leftJoy = new Joystick(0);
        rightJoy = new Joystick(1);

    }

    /*
     * DRIVETRAIN CONTROLS
     */

    /** @return Left y-axis joystick **/
    public double getLeftJoy() {

        return leftJoy.getY();

    }
    public boolean getLeftClicky() {

        return leftJoy.getRawButton(1);

    }
    public boolean getRightClicky() {

        return rightJoy.getRawButton(1);

    }
    /** @return Right y-axis joystick **/
    public double getRightJoy() {


        return rightJoy.getY();
    }

}