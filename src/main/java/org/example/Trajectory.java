package org.example;

import java.util.LinkedList;
import java.util.List;

public class Trajectory {
    public List<TrajectoryRow> trajectory;
    Trajectory(){
        trajectory = new LinkedList<>();
    }
    public void addRow(TrajectoryRow newData){
        trajectory.add(newData);
    }
}
