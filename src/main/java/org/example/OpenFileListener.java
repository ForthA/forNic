package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenFileListener implements ActionListener {
    private final MainFrame mainFrame;
    FileDealer fileDealer;
    public OpenFileListener(FileDealer fileDealer, MainFrame mainFrame){
        this.fileDealer = fileDealer;
        this.mainFrame = mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            mainFrame.fileDealer.openFile(file);
            mainFrame.setPreviewFileText(DataFormater.makePreviewData(fileDealer.getData().getRecord(file)));
            mainFrame.setTableView(fileDealer.getData().getRecord(file));
            mainFrame.addFilePreview(fileDealer.getData());
        }
    }

    private void openChosenFile(File file){

    }


}
