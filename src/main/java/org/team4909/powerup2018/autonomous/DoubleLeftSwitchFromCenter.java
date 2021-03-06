package org.team4909.powerup2018.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team4909.bionicframework.hardware.motor.MotorSubsystem;
import org.team4909.bionicframework.subsystems.drive.BionicDrive;
import org.team4909.bionicframework.subsystems.drive.commands.DriveDistance;
import org.team4909.bionicframework.subsystems.elevator.ElevatorSubsystem;

public class DoubleLeftSwitchFromCenter extends CommandGroup{
    public DoubleLeftSwitchFromCenter(MotorSubsystem intake, ElevatorSubsystem elevator, BionicDrive drivetrain){

        //Drive far enough to get away from the wall
        addSequential(new DriveDistance(24, .02, 0, 0));
//                drivetrain.driveDistance(1.5, 1));

        //Turn to avoid the pile of cubes
        addSequential(drivetrain.driveRotation(45,.0092,0.0002,0));

        //Drive to the switch
        addSequential(new DriveDistance(5*12, 0.02,0,0),2);
//                drivetrain.d

        //turn to score
        addSequential(drivetrain.driveRotation(-50, .0062,0.0002,0));

        // Move elevator to height
        addSequential(elevator.holdPosition(13000));
        addSequential(new WaitCommand(.5)); //wait to get there
//
        addSequential(new DriveDistance(4.5*12, 0.01,0,0),2);
//                drivetrain.driveDistance(1.833));

        addSequential(intake.setPercentOutput(-1.0));
        addSequential(new WaitCommand(1.5));
        addSequential(intake.setPercentOutput(0));

        //Back up
        addSequential(new DriveDistance(-4*12,.02,0,0));
        //elevator down
        addSequential(elevator.holdPosition(0));
        //turn left
        addSequential(drivetrain.driveRotation(-40,.0008,0.0002, 0));
        //Intake on
        addSequential(intake.setPercentOutput(1));
        //forward 4 feet
        addSequential(new DriveDistance(3.5*12,.02,0,0),2.5);
        //Make sure cube is in
        addSequential(intake.setPercentOutput(-0.5));
        addSequential(new WaitCommand(.1));
        addSequential(intake.setPercentOutput(1));
        addSequential(new WaitCommand(.3));
        //intake off
        addSequential(intake.setPercentOutput(0));
        //back up
        addSequential(new DriveDistance(-4*12,.02,0,0));
        //turn right
        addSequential(drivetrain.driveRotation(50,0.0085,0,0),1);
        //Elevator up
        addSequential(elevator.holdPosition(11000));
        addSequential(new WaitCommand(.5));
        //drive forward 4 feet
        addSequential(new DriveDistance(5*12,.02,0,0),1);
        //Shoot
        addSequential(intake.setPercentOutput(-1.0));
        addSequential(new WaitCommand(.75));
        addSequential(intake.setPercentOutput(0));
        //reset
        addSequential(new DriveDistance(-24,.02,0,0));
        addSequential(elevator.holdPosition(0));

    }
}
