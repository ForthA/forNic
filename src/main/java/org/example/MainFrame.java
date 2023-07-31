package org.example;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;

public class MainFrame extends JFrame{
    private JTable trajectoryTable;
    private JList fileList;
    private JTextArea filePreviewText;
    private JPanel mainPanel;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JPanel SettingsPanel;
    private JPanel smw;
    JMenuBar jMenuBarFile;
    JMenu menuFile;
    JMenu openRecent;
    JMenu closeRecent;
    JMenuItem menuFileM1;
    JMenuItem menuFileM4;
    JMenuBar jMenuBarSetting;
    JMenu menuSettings;
    JMenuItem menuSettingsM1;
    JMenuItem[] openRecentArr;
    JMenuItem[] closeRecentArr;
    ListModel listModel;
    TableModel tableModel;
    public FileDealer fileDealer;

    public MainFrame(){
        fileDealer = new FileDealer();
        makeFileMenu();
        makeSettingMenu();
        setContentPane(mainPanel);
        setTitle("TrajectoryApp");
        setSize(1440, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setPreviewFileText(String str){
        filePreviewText.setText(str);
    }
    public void setTableView(Trajectory trajectory){
        tableModel = new TableModel(trajectory);
        trajectoryTable.setModel(tableModel);
    }
    public void addFilePreview(Data data){
        listModel = new ListModel(data, this);
        fileList.setModel(listModel);
        fileList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    String filename = (String) fileList.getSelectedValue();
                    for (int i = 0; i < fileDealer.getData().getSize(); i++){
                        if (fileDealer.getData().getRecordKey(i).getName().equals(filename)){
                            setPreviewFileText(DataFormater.makePreviewData(fileDealer.getData().getRecord(fileDealer.getData().getRecordKey(i))));
                            setTableView(fileDealer.getData().getRecord(fileDealer.getData().getRecordKey(i)));
                        }
                    }
                }
            }
        });

    }
    public void destroyFilePreview(){

    }
    public JTextArea getFilePreviewText() {
        return filePreviewText;
    }

    private void makeFileMenu(){
        jMenuBarFile = new JMenuBar();
        menuFile = new JMenu("Файл");
        openRecent = new JMenu("Открыть недавние");
        closeRecent = new JMenu("Закрыть");
        menuFile.setSize(new Dimension(100,100));
        menuFileM1 = new JMenuItem("Открыть");
        menuFileM4 = new JMenuItem("Закрыть все");
        openRecentArr = new JMenuItem[0];
        menuFileM1.addActionListener(new OpenFileListener(fileDealer, this));
        menuFileM4.addActionListener(new CloseFilesListener(fileDealer, this));
        menuFile.add(menuFileM1);
        menuFile.add(openRecent);
        menuFile.add(closeRecent);
        menuFile.add(menuFileM4);
        jMenuBarFile.add(menuFile);
        SettingsPanel.add(jMenuBarFile);
    }

    private void makeSettingMenu(){
        jMenuBarSetting = new JMenuBar();
        menuSettings = new JMenu("Настройки");
        menuSettingsM1 = new JMenuItem("Сохранить положение окон");
        closeRecentArr = new JMenuItem[0];
        menuSettings.add(menuSettingsM1);
        jMenuBarFile.add(menuSettings);
        SettingsPanel.add(jMenuBarSetting);
    }
    public void refreshMenu(Data data){
        for (int i = 0;i < data.getSize();i++){
            data.getRecordKey(i);
        }
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }
}
