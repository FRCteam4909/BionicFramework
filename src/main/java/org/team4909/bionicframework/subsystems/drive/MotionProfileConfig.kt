package org.team4909.bionicframework.subsystems.drive

class MotionProfileConfig(val profileIntervalMs: Int, cruisePercent: Double, wheelDiameterFeet: Double,
                          maxVelocityTicks: Double, val secondsFromNeutralToFull: Double,
                          val driveRotationTestFeet: Double, driveRotationTestRad: Double) {
    val ticksToFeet: Double
    val chassisWidthFeet: Double
    val cruiseVelocityFeet: Double
    val avgAccelerationFeet: Double
    val maxJerkFeet: Double

    val profileIntervalS: Double
        get() = profileIntervalMs.toDouble() / 1000

    init {
        this.ticksToFeet = Math.PI * wheelDiameterFeet / (4 * 360) // e4t spec, with 4x subsampling
        this.chassisWidthFeet = 2 * driveRotationTestFeet / driveRotationTestRad

        // Cruise Velocity
        val maxVelocityFeet = maxVelocityTicks * ticksToFeet
        this.cruiseVelocityFeet = cruisePercent * maxVelocityFeet
        this.avgAccelerationFeet = maxVelocityFeet / secondsFromNeutralToFull

        // Max Jerk
        this.maxJerkFeet = 60.0
    }
}
