// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD licen


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ChasisDriveSubsystem;
import edu.wpi.first.networktables.*;

public class LIMETARGETFOLLOW extends CommandBase {
  public final ChasisDriveSubsystem ChasisSub;
  private double tx, ta, speedangle, speedline, speed;
  

  /** Creates a new LIMETARGETFOLLOW. */
  public LIMETARGETFOLLOW(ChasisDriveSubsystem ChasisSub) {
    this.ChasisSub = ChasisSub;
    addRequirements(ChasisSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    updateValues();
    speedangle = (tx-0)/100*.7;
    speedline = (15-ta);
    
    

  }

  private void updateValues(){
    this.tx = NetworkTableInstance.getDefault().getTable("limelight-abtomat").getEntry("tx").getDouble(0);
    this.ta = NetworkTableInstance.getDefault().getTable("limelight-abtomat").getEntry("ta").getDouble(0);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
