package com.Plugin.ui;

import com.Plugin.JavaFilesDetector;
import com.Plugin.engine.CommentDialog;
import com.intellij.openapi.project.Project;
import com.intellij.ui.components.JBList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class TagFrame {

    private JTextField textField1;
    private JButton findButton;
    private JPanel mainPanel;

    private String tag;
    private CommentDialog dialog;

    public TagFrame (Project project) {
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tag = textField1.getText();

                ArrayList<String> temp = JavaFilesDetector.ConvertFilesPathToString(JavaFilesDetector.processFilesFromFolder(new File(project.getBasePath() + "\\src"), tag));
                JList<String> jList = new JBList<String>(temp);

                dialog = new CommentDialog(project, jList, tag);
                dialog.show();
            }
        });
    }

    public JComponent getMainPanel() {
        return mainPanel;
    }
}
