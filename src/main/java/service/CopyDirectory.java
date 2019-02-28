package main.java.service;

import java.io.*;

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

    private static void copyFile(String oldPath, String newPath) throws IOException {
        BufferedReader bufferedReader = null;
        PrintStream printStream = null;
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(oldPath)));
        printStream = new PrintStream(new FileOutputStream(newPath));
        String s = null;
        while ((s = bufferedReader.readLine()) != null) {
            printStream.println(s);
            printStream.flush();
        }
        if (bufferedReader != null) bufferedReader.close();
        if (printStream != null) printStream.close();
    }
}