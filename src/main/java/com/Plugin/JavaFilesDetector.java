package com.Plugin;

import java.io.File;
import java.util.ArrayList;

public class JavaFilesDetector {

    public static ArrayList<File> processFilesFromFolder(File folder, String tag)
    {
        ArrayList<File> listOfFile = new ArrayList<File>();

        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                listOfFile.addAll(processFilesFromFolder(entry, tag));
            }

            if (getFileExtension(entry).equals("java") && QuestionsSearcher.ContainsTag(entry.getPath(), tag)) {
                listOfFile.add(entry);
            }
        }

        return listOfFile;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    public static ArrayList<String> ConvertFilesPathToString(ArrayList<File> list) {
        ArrayList<String> newList = new ArrayList<String>();
        for (File file : list) {
            newList.add(file.getPath());
        }

        return newList;
    }


}
