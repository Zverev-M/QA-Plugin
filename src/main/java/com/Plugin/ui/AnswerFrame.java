package com.Plugin.ui;

import com.Plugin.QAHelper;
import com.jetbrains.rd.util.reactive.KeyValuePair;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerFrame extends JFrame{
    private JPanel mainPanel;
    private JTextField textField;
    private JLabel label;
    private JButton saveButton;

    public AnswerFrame (KeyValuePair<String, Integer> pair, String path) {
        label.setText(pair.getKey());
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!textField.getText().equals("")) {
                    QAHelper.EditFile(path, pair.getValue(), textField.getText());
                }
            }
        });
    }

    public JComponent getMainPanel() {
        return mainPanel;
    }
}
