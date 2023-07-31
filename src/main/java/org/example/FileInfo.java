package org.example;

import java.io.File;
import java.nio.file.Path;

public class FileInfo {
    private String format;
    private File file;
    private String appName;

    FileInfo(File file, String appName, String format){
        this.file = file;
        this.appName = appName;
        this.format = format;
    }

    public void setAppName(String newName){
        appName = newName;
    }
    public String getFormat(){
        return format;
    }
    public String getAppName(){
        return appName;
    }
    public File getFile(){
        return file;
    }

}
