package com.Plugin;

import java.io.FileReader;
import java.util.Scanner;

public class QuestionsSearcher {
    public static boolean ContainsTag(String path, String tag) {
        try {
            FileReader fr = new FileReader(path);
            Scanner sc = new Scanner(fr);

            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                if (s.lastIndexOf("?".concat(tag)) != -1) {
                    s = sc.nextLine();
                    if (s.endsWith("!answer:")) {
                        fr.close();
                        return true;
                    }
                }
            }

            return false;
        }

        catch (Exception e) {
            return false;
        }

    }
}
