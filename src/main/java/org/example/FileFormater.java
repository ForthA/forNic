package org.example;

import java.io.File;

public interface FileFormater {
    abstract Trajectory formatData(String[] info);
    String makePreviewData(Trajectory trajectory);
}
