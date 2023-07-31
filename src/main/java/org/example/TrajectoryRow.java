package org.example;

public class TrajectoryRow {
    Time time;
    Point point;
    Velocity velocity;
    TrajectoryRow(Time time, Point point, Velocity velocity){
        this.time = time;
        this.point = point;
        this.velocity = velocity;
    }
}
