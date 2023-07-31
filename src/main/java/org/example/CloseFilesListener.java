package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseFilesListener implements ActionListener {
    private final MainFrame mainFrame;
    FileDealer fileDealer;
    public CloseFilesListener(FileDealer fileDealer, MainFrame mainFrame){
        this.fileDealer = fileDealer;
        this.mainFrame = mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        fileDealer.getData().clear();
        mainFrame.setPreviewFileText("");
        mainFrame.setTableView(new Trajectory());
        mainFrame.addFilePreview(fileDealer.getData());
    }
}
