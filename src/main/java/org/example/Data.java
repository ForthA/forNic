package org.example;

import java.io.File;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class Data {
    private Map<FileInfo, Trajectory> data;
    public void removeRecord(FileInfo file){
        data.remove(file);
    }

    Data(){
        data = new LinkedHashMap<>();
    }
    public void addRecord(FileInfo key, Trajectory value){
        data.put(key, value);
    }

    public Trajectory getRecord(FileInfo key){
        return data.get(key);
    }
    public FileInfo getRecordKey(int index){
        int i = 0;
        for (Map.Entry<FileInfo, Trajectory> item : data.entrySet()){
            if (index == i)
                return item.getKey();
            i++;
        }
        return new FileInfo(new File(""),"", "");
    }
    public int getSize(){
        return data.size();
    }
    public void clear(){
        data.clear();
    }
}
