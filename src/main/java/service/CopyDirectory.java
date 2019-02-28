package main.java.service;

import java.io.File;
import java.io.IOException;

public class CopyDirectory {
    private static void copyDir(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File[] files = oldFile.listFiles();
        File newFile = new File(newPath);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        for (File file : files) {
            if (file.isFile()) {
                copyFile(file.getPath(), newPath + "\\" + file.getName());
            } else if (file.isDirectory()) {
                copyDir(file.getPath(), newPath + "\\" + file.getName());
            }
        }

    }
}