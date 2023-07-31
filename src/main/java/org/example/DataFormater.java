package org.example;

public class DataFormater {
    public static String makePreviewData(Trajectory trajectory) {
        StringBuilder str = new StringBuilder();
        for (TrajectoryRow row: trajectory.trajectory){
            str.append(row.time.getTime() + " " + row.point.getX() + " " + row.point.getY() + " " + row.point.getZ() + " " + row.velocity.getVx() + " " + row.velocity.getVy() + " " + row.velocity.getVz() + "\n");
        }
        return str.toString();
    }
}
