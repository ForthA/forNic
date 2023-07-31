package org.example;

public class Point {
    private double x;
    private double y;
    private double z;
    Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    void setX(double value){
        x = value;
    }
    void setY(double value) {
        y = value;
    }
    void setZ(double value){
        z = value;
    }
    double getX(){
        return x;
    }
    double getY(){
        return y;
    }
    double getZ(){
        return z;
    }
}
