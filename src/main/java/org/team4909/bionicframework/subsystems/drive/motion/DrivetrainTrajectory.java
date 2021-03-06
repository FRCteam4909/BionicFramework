package org.team4909.bionicframework.subsystems.drive.motion;

import com.ctre.phoenix.motion.TrajectoryPoint;
import jaci.pathfinder.Trajectory;
import org.team4909.bionicframework.hardware.motor.BionicSRX;

/**
 * SRX Motion Profiling Compliant Trajectory Abstraction Layer
 */
public class DrivetrainTrajectory {
    public final int profileIntervalMs;

    public final TrajectoryPoint[] left;
    public final TrajectoryPoint[] right;

    /**
     * @param left  Left Trajectory Generated from Pathfinder
     * @param right Right Trajectory Generated from Pathfinder
     */
    public DrivetrainTrajectory(DrivetrainConfig config, Trajectory left, Trajectory right) {
        profileIntervalMs = config.getProfileIntervalMs();

        this.left = BionicSRX.convertToSRXTrajectory(left, config.getTicksToFeet());
        this.right = BionicSRX.convertToSRXTrajectory(right, config.getTicksToFeet());
    }

    public DrivetrainTrajectory(DrivetrainConfig config, Trajectory rotation) {
        profileIntervalMs = config.getProfileIntervalMs();

        left = BionicSRX.convertToSRXTrajectory(rotation, config.getTicksToFeet(), true);
        right = BionicSRX.convertToSRXTrajectory(rotation, config.getTicksToFeet(),  false);
    }

}