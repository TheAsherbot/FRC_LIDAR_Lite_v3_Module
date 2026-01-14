package frc.robot.core;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Counter;

public class LidarLitev3Sensor
{
    private Counter lidar;
    private double distance;

    public LidarLitev3Sensor(int lidarID)
    {
        lidar = new Counter(0); //plug the lidar into PWM 0
        lidar.setMaxPeriod(1.00); //set the max period that can be measured
        lidar.setSemiPeriodMode(true); //Set the counter to period measurement
        lidar.reset();
    }

    public void Update() 
    {
        if(lidar.get() < 1)
        {
            distance = 0;
        }
        else
        {
            distance = (lidar.getPeriod()*1000000.0/10.0); //convert to distance. sensor is high 10 us for every centimeter.
        }
        
        System.out.println("Distance: " + distance);
    }


    public double GetDistance()
    {
        return distance;
    }

}
