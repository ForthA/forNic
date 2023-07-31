package org.example;

import java.io.File;

public class FileFormaterTxt implements FileFormater {

    @Override
    public Trajectory formatData(String[] info) {
        Trajectory data = new Trajectory();
        for (String str : info){
            str = str.replaceAll("\\s+", " ");
            String[] row = str.split(" ");
            System.out.println(str);
            data.addRow(new TrajectoryRow(
                    new Time(Double.parseDouble(row[0])),
                    new Point(Double.parseDouble(row[1]), Double.parseDouble(row[2]), Double.parseDouble(row[3])),
                    new Velocity(Double.parseDouble(row[4]), Double.parseDouble(row[5]), Double.parseDouble(row[6]))
            ));
        }
        return data;
    }

    @Override
    public String makePreviewData(Trajectory trajectory) {
        StringBuilder str = new StringBuilder();
        for (TrajectoryRow row: trajectory.trajectory){
            str.append(row.time.getTime() + " " + row.point.getX() + " " + row.point.getY() + " " + row.point.getZ() + " " + row.velocity.getVx() + " " + row.velocity.getVy() + " " + row.velocity.getVz() + "\n");
        }
        return str.toString();
    }
}
