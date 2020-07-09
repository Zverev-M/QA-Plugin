package com;

import com.intellij.lang.javascript.boilerplate.GithubTagListProvider;
import com.intellij.platform.templates.github.GithubTagInfo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLReader {
    String origin;
    //final String REGEX = "\"@[\\w\\d-_]+\"";
    Tags code = new Tags();

    public Tags pars() throws IOException {
        try {

            URL url = new URL(origin);

            try {
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));
                String str = reader.readLine();

                Pattern pattern = Pattern.compile(Constants.REGEX);
                Matcher matcher = pattern.matcher(str);

                while (str != null) {
                    while(matcher.find()) {
                        code.add(matcher.group());
                    }

                    str = reader.readLine();
                    matcher = pattern.matcher(str);
                }
                reader.close();
                return code;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
