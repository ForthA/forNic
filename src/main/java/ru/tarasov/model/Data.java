package ru.tarasov.model;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Data {
    private Map<MyFile, Trajectory> data;

    public Data(){
        data = new LinkedHashMap<>();
    }

    public void addRecord(MyFile key, Trajectory value){
        data.put(key, value);
    }


    public MyFile indexFileByName(String name){
        for (Map.Entry<MyFile, Trajectory> entry : data.entrySet()){
            MyFile file = entry.getKey();
            if (file.getFileName().equals(name)){
                return file;
            }
        }
        return null;
    }
    //Для вывода
    public void printData(){
        for (Map.Entry<MyFile, Trajectory> item : data.entrySet()){
            for (Map.Entry<Double, TrajectoryRow> row : item.getValue().getTrajectoryRows().entrySet()){
                System.out.println(row.getKey() + " " + row.getValue().getPoint().getX() + " " + row.getValue().getPoint().getY() + " " +
                        row.getValue().getPoint().getZ() + " " + row.getValue().getVelocity().getVx() + " " + row.getValue().getVelocity().getVy() +
                        " " + row.getValue().getVelocity().getVz());
            }
        }
    }
}
