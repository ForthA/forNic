package ru.tarasov.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Format;
import java.util.List;

public class MyFile {

    private File file;

    public MyFile(String path){
        File file = new File(path);
    }

    public MyFile(File file){
        this.file = file;
    }
    public void setFile(File file) {
        this.file = file;
    }

    public void setFile(String path){
        this.file = new File(path);
    }

    public void setNewText(List<String> text) throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        for (String row: text){
            fileWriter.write(row);
        }
        fileWriter.flush();
    }
    public File getFile(){
        return file;
    }

    public String getFileName() {
        return file.getName();
    }
    public String getFormat(){
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }
    public String getPath(){
        return file.getPath();
    }
    public List<String> getAllRows() throws IOException {
        return Files.readAllLines(file.toPath());
    }

}
