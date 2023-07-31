package org.example;

public class Velocity {
    private double vx;
    private double vy;
    private double vz;
    Velocity(double vx, double vy, double vz){
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
    }
    void setVx(double value){
        vx = value;
    }
    void setVy(double value) {
        vy = value;
    }
    void setVz(double value){
        vz = value;
    }
    double getVx(){
        return vx;
    }
    double getVy(){
        return vy;
    }
    double getVz(){
        return vz;
    }
}
