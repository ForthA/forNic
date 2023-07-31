package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileReaderTxt implements FileReaderRes {
    @Override
    public String[] readFile(File file) throws FileReadException {
        List<String> data = new LinkedList<>();
        if (file == null)
            throw new FileReadException("File is not searched");
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            throw new FileReadException("Smth went wrong while reading file");
        }
        return data.toArray(new String[0]);
    }

}
