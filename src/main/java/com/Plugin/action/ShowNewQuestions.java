package com.Plugin.action;

import com.Plugin.engine.CommentDialog;

import com.Plugin.engine.TagDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class ShowNewQuestions extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        TagDialog dialog = new TagDialog(e.getProject());
        dialog.show();
    }

}
