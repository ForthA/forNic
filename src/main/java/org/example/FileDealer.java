package org.example;

import java.io.File;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDealer {
    private Data data;
    public FileDealer() {
        data = new Data();
    }
    public void openFile(File file){
        FileFormater fileFormater = new FileFormaterTxt();
        FileReaderRes fileReaderRes = new FileReaderTxt();
        data.addRecord(new FileInfo(file, "Траектория " + data.getSize(),".txt"), fileFormater.formatData(fileReaderRes.readFile(file)));
    }

    public void changeFile(File file){
    }

    public void saveFile(File file){

    }

    public void renameFile(File file){

    }
    public void showFile(File file){

    }
    public Data getData() {
        return data;
    }
    public void clearData() {
        data.clear();
    }
}
