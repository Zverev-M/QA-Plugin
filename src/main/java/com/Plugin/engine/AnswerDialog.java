package com.Plugin.engine;

import com.Plugin.ui.AnswerFrame;
import com.Plugin.ui.Frame;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.jetbrains.rd.util.reactive.KeyValuePair;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AnswerDialog extends DialogWrapper {
    private final AnswerFrame frame;

    public AnswerDialog(@Nullable Project project, KeyValuePair<String, Integer> pair, String path) {
        super(project);
        this.setResizable(false);
        frame = new AnswerFrame(pair, path);
        setTitle("Question");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return frame.getMainPanel();
    }
}
