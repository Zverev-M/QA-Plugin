package com.Plugin.ui;

import javax.swing.*;

public class CommentPanel extends JFrame{

    private JPanel mainPanel;
    private JList<String> list1;
    private JButton followButton;

    public CommentPanel() {
        setContentPane(mainPanel);
        setVisible(true);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
