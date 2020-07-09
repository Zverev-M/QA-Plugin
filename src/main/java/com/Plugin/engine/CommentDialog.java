package com.Plugin.engine;

import com.Plugin.ui.Frame;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;

public class CommentDialog extends DialogWrapper {

    private final Frame frame;

    public CommentDialog(@Nullable Project project, JList<String> jList, String tag) {
        super(project);
        this.setResizable(false);
        String path = project.getBasePath();
        File folder = new File(path + "\\src");
        frame = new Frame(folder, jList, project, tag);
        setTitle("List of files with questions for " + tag);
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return frame.getMainPanel();
    }

    //public CommentMessage getCommentMessage() {
       // return panel.getCommentMessage();
    //}

}
