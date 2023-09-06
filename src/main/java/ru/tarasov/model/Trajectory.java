package ru.tarasov.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Trajectory {

    private Map<Double, TrajectoryRow> trajectoryRows;

    public Trajectory(){
        trajectoryRows = new LinkedHashMap<>();
    }

    public void addRow(double time, Point point, Velocity velocity){
        trajectoryRows.put(time, new TrajectoryRow(point, velocity));
    }

    public void addRow(double time, TrajectoryRow trajectoryRow){
        trajectoryRows.put(time, trajectoryRow);
    }

    public Map<Double, TrajectoryRow> getTrajectoryRows() {
        return trajectoryRows;
    }

    public void setTrajectoryRows(Map<Double, TrajectoryRow> trajectoryRows) {
        this.trajectoryRows = trajectoryRows;
    }
}