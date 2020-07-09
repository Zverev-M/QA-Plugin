package com.Plugin.engine;

import com.Plugin.ui.TagFrame;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TagDialog extends DialogWrapper {

    private final TagFrame frame;

    public TagDialog(@Nullable Project project) {
        super(project);
        this.setResizable(false);
        frame = new TagFrame(project);
        setTitle("Your GitHub Tag");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return frame.getMainPanel();
    }
}
