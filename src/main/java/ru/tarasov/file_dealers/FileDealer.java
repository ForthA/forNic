package ru.tarasov.file_dealers;

import ru.tarasov.model.Data;
import ru.tarasov.model.MyFile;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileDealer {
    private Data data;

    public FileDealer(Data data) {
        this.data = data;
    }

    public void openFile(){
        JFileChooser fileChooser = new JFileChooser();
        int ret = fileChooser.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                MyFile myFile = new MyFile(file);
                data.addRecord(myFile, FileFormatter.getInstance().formatData(myFile.getAllRows()));
            } catch (IOException exception) {
                System.out.println("Something went wrong with file reading!\n");
            }
        }
    }

    public void renameFile(String oldName, String newName){
        if (data.indexFileByName(oldName).getFile().renameTo(new File(newName))){
            System.out.println("File was renamed\n");
        }
    }

    public void changeFile(String filename, List<String> newText){
        try {
            data.indexFileByName(filename).setNewText(newText);
        } catch (IOException e) {
            System.out.println("Smth went wrong");
        }
    }

    public void saveFile(String filename){
        JFileChooser jFileChooser = new JFileChooser();
        if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            MyFile file = new MyFile(jFileChooser.getSelectedFile());
            try {
                file.setNewText(data.indexFileByName(filename).getAllRows());
            } catch (IOException e) {
                System.out.println("Smth went wrong");
            }
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
