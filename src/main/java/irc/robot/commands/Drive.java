package irc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import irc.robot.OI;
import irc.robot.subsystems.Drivetrain;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Drive extends Command {

    private OI oi;
    private Drivetrain drivetrain;

    //Getting OI and Drivetrain instances to run commands with.
    public Drive(){
        oi = OI.getInstance();
        drivetrain = Drivetrain.getInstance();

        requires(drivetrain);

    }

    //Execute runs when the robot is active.
    // Here we call the setSpeed function from the Drivetrain Class, using values from the OI class's Joysticks.
    public void execute(){
        int speedl = 0;
        int speedr = 0;
        //drivetrain.setSpeed(oi.getLeftJoy(), oi.getRightJoy());

        if (IsKeyPressed.isWPressed()) {
            speedl += 0.5;
            speedr += 0.5;
            System.out.println("w");
        }
        if (IsKeyPressed.isAPressed()) {
            speedl += 0.5;
            System.out.println("A");
        }
        if (IsKeyPressed.isSPressed()) {
            speedl -= 0.5;
            speedr -= 0.5;
            System.out.println("S");
        }
        if (IsKeyPressed.isDPressed()) {
            speedr += 0.5;
            System.out.println("D");
        }
        drivetrain.setSpeed(speedl, speedr);
    }

    //We never want this command to stop, so we return false for the abstract isFinished method.
    @Override
    protected boolean isFinished() {

        return false;

    }
}
class IsKeyPressed {
    private static volatile boolean wPressed = false;
    private static volatile boolean aPressed = false;
    private static volatile boolean sPressed = false;
    private static volatile boolean dPressed = false;
    public static boolean isWPressed() {
        synchronized (IsKeyPressed.class) {
            return wPressed;
        }
    }
    public static boolean isAPressed() {
        synchronized (IsKeyPressed.class) {
            return aPressed;
        }
    }
    public static boolean isSPressed() {
        synchronized (IsKeyPressed.class) {
            return sPressed;
        }
    }
    public static boolean isDPressed() {
        synchronized (IsKeyPressed.class) {
            return dPressed;
        }
    }
    public static void main(String[] args) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (IsKeyPressed.class) {
                    switch (ke.getID()) {
                        case KeyEvent.KEY_PRESSED:
                            if (ke.getKeyCode() == KeyEvent.VK_W) {
                                wPressed = true;
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_A) {
                                aPressed = true;
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_S) {
                                sPressed = true;
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_D) {
                                dPressed = true;
                            }
                            break;

                        case KeyEvent.KEY_RELEASED:
                            if (ke.getKeyCode() == KeyEvent.VK_W) {
                                wPressed = false;
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_A) {
                                aPressed = false;
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_S) {
                                sPressed = false;
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_D) {
                                dPressed = false;
                            }
                            break;

                    }
                    return false;
                }
            }
        });
    }
}