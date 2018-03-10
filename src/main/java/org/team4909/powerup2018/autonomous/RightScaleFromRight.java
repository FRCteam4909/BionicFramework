package org.team4909.powerup2018.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team4909.bionicframework.hardware.motor.MotorSubsystem;
import org.team4909.bionicframework.subsystems.drive.BionicDrive;
import org.team4909.bionicframework.subsystems.elevator.ElevatorSubsystem;

public class RightScaleFromRight extends CommandGroup {
    public RightScaleFromRight(MotorSubsystem intake, ElevatorSubsystem elevator, BionicDrive drivetrain) {
        addSequential(drivetrain.driveDistance(27));
        addSequential(drivetrain.driveRotation(-90), 3);
        addSequential(elevator.holdPosition(33000));
        addSequential(new WaitCommand(3));
        addSequential(drivetrain.driveDistance(1), 2);
        addSequential(intake.setPercentOutput(-1.0), 1.5);
        addSequential(new WaitCommand(1.5));
        addSequential(intake.setPercentOutput(0));
        addSequential(drivetrain.driveDistance(-1), 2);
        addSequential(elevator.holdPosition(0));
    }
}
