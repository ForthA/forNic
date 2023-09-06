package ru.tarasov.file_dealers;

import ru.tarasov.model.Point;
import ru.tarasov.model.Trajectory;
import ru.tarasov.model.TrajectoryRow;
import ru.tarasov.model.Velocity;

import java.util.List;
import java.util.Map;

public class FileFormatter{

    private static FileFormatter instance;
    private FileFormatter(){};

    public static FileFormatter getInstance(){
        if (instance == null)
            instance = new FileFormatter();
        return instance;
    }
    public Trajectory formatData(List<String> info) {
        Trajectory trajectory = new Trajectory();
        for (String str: info){
            str = str.replaceAll("\\s+", " ");
            String[] row = str.split(" ");
            trajectory.addRow(Double.parseDouble(row[0]),
                    new Point(Double.parseDouble(row[1]), Double.parseDouble(row[2]), Double.parseDouble(row[3])),
                    new Velocity(Double.parseDouble(row[4]), Double.parseDouble(row[5]), Double.parseDouble(row[6])));
        }
        return trajectory;
    }

    public String makePreviewData(Trajectory trajectory) {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Double, TrajectoryRow> entry : trajectory.getTrajectoryRows().entrySet()){
            str.append(entry.getKey() + " " + entry.getValue().getPoint().getX() + " "+ entry.getValue().getPoint().getY() + " "+ entry.getValue().getPoint().getZ() + " " +
                     entry.getValue().getVelocity().getVx() + " " + entry.getValue().getVelocity().getVy() + " " + entry.getValue().getVelocity().getVz() + "\n");
        }
        return str.toString();
    }
}
