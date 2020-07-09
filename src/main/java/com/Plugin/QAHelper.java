package com.Plugin;

import com.jetbrains.rd.util.reactive.KeyValuePair;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QAHelper {
    public static KeyValuePair<String, Integer> FindQuestion(String tag, String path) {
        try {
            FileReader fr = new FileReader(path);
            Scanner sc = new Scanner(fr);

            String currentString;
            int i = 1;

            while (sc.hasNextLine()) {
                currentString = sc.nextLine();
                if (currentString.lastIndexOf("?".concat(tag)) != -1) {
                    String s = sc.nextLine();
                    if (s.endsWith("!answer:")) {
                        fr.close();
                        return new KeyValuePair<>(currentString, i);
                    }
                    i++;
                }
                i++;
            }

            fr.close();
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }

    public static void EditFile(String path, Integer numberOfLine, String answer) {
        try {
            File oldFile = new File(path);
            String parentPath = oldFile.getParent();

            File newFile = new File(parentPath.concat("\\NewTempFile.java"));
            newFile.createNewFile();

            FileReader fr = new FileReader(oldFile);
            FileWriter fw = new FileWriter(newFile);
            Scanner sc = new Scanner(fr);

            String line;
            int i = 0;

            while (sc.hasNextLine()) {
                line = sc.nextLine();

                if (i == numberOfLine) {
                    line = "*!answer: ".concat(answer);
                }

                fw.write(line.concat("\n"));
                i++;
            }

            fr.close();
            fw.close();

            if (oldFile.delete()) {
                newFile.renameTo(oldFile);
            }
        }
        catch (IOException e) {
            e.getMessage();
        }

    }
}
