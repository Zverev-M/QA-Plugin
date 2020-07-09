package com;

import javax.swing.text.JTextComponent;
import java.util.Map;

public class CommentMessage {

    private final String content;
    private final Settings settings;

    public CommentMessage(Settings settings, Map<String, JTextComponent> components) {
        this.settings = settings;
        this.content = buildContent(components);
    }

    private String buildContent(Map<String, JTextComponent> components) {
        return Utils.convert(settings.messageTemplate, settings.handler, components);
    }

    @Override
    public String toString() {
        return content;
    }
}
