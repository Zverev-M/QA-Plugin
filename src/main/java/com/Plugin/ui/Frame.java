package com.Plugin.ui;

import com.Plugin.QAHelper;
import com.Plugin.engine.AnswerDialog;
import com.intellij.openapi.project.Project;
import com.jetbrains.rd.util.reactive.KeyValuePair;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Frame extends JFrame{
    private JPanel mainPanel;
    private JList<String> list;
    private JButton followButton;

    public Frame (File folder, JList<String> jList, Project project, String tag) {
        mainPanel = new JPanel();
        list = jList;

        followButton = new JButton("Follow");
        followButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.getSelectedIndex() != -1) {

                    String path = list.getSelectedValue();
                    KeyValuePair<String, Integer> pair = QAHelper.FindQuestion(tag, path);

                    AnswerDialog dialog = new AnswerDialog(project, pair, path);
                    dialog.show();
                }
            }
        });

        mainPanel.add(list);
        mainPanel.add(followButton);
    }

    public JComponent getMainPanel() {
        return mainPanel;
    }

}
