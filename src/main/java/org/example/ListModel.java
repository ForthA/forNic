package org.example;

import javax.swing.*;
import java.io.File;

public class ListModel extends AbstractListModel {
    Data data;
    private final MainFrame mainFrame;
    public ListModel(Data data, MainFrame mainFrame){
        this.data = data;
        this.mainFrame = mainFrame;
    }
    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public Object getElementAt(int index) {
        return data.getRecordKey(index).getFile().getName();
    }

    private void setListeners(){

    }
}
