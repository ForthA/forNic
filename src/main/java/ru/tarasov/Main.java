package ru.tarasov;

import ru.tarasov.file_dealers.FileDealer;
import ru.tarasov.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileDealer fileDealer = new FileDealer(new Data());
        List<String> list = new ArrayList<>();
        list.add("4.000 4 5 6 7 8 9");
        fileDealer.openFile();
        fileDealer.getData().printData();
        fileDealer.changeFile("123.txt", list);
        fileDealer.saveFile("123.txt");
    }
}