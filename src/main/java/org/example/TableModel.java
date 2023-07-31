package org.example;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    private Trajectory trajectory;
    public TableModel(Trajectory trajectory){
        this.trajectory = trajectory;
    }
    public String getColumnName(int c){
        switch (c){
            case 0:
                return "T, c";
            case 1:
                return "X, м";
            case 2:
                return "Y, м";
            case 3:
                return "Z, м";
            case 4:
                return "Vx, м/с";
            case 5:
                return "Vy, м/c";
            case 6:
                return "Vz, м/c";
            default:
                return "";
        }
    }
    @Override
    public int getRowCount() {
        return trajectory.trajectory.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return trajectory.trajectory.get(rowIndex).time.getTime();
            case 1:
                return trajectory.trajectory.get(rowIndex).point.getX();
            case 2:
                return trajectory.trajectory.get(rowIndex).point.getY();
            case 3:
                return trajectory.trajectory.get(rowIndex).point.getZ();
            case 4:
                return trajectory.trajectory.get(rowIndex).velocity.getVx();
            case 5:
                return trajectory.trajectory.get(rowIndex).velocity.getVy();
            case 6:
                return trajectory.trajectory.get(rowIndex).velocity.getVz();
            default:
                return "smth";
        }
    }

}
