package ru.tarasov.model;

public class TrajectoryRow {

    private Point point;
    private Velocity velocity;

    public TrajectoryRow(Point point, Velocity velocity){
        this.point = point;
        this.velocity = velocity;
    }


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }
}
