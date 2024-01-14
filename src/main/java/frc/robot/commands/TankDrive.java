package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.Supplier;

public class TankDrive extends Command {
    private final Drivetrain m_drivetrain;
    private final Supplier<Double> m_leftSpeedSupplier;
    private final Supplier<Double> m_rightSpeedSupplier;

    public TankDrive (
        Drivetrain drivetrain,
        Supplier<Double> leftSpeedSupplier,
        Supplier<Double> rightSpeedSupplier
    ) {
        m_drivetrain = drivetrain;
        m_leftSpeedSupplier = leftSpeedSupplier;
        m_rightSpeedSupplier = rightSpeedSupplier;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        m_drivetrain.tankDrive(
            m_leftSpeedSupplier.get(),
            m_rightSpeedSupplier.get()
        );
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
