package com.thoughtworks.hashdefaults;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.ex.CustomComponentAction;

import javax.swing.*;

public class ShowHyperlinkAction extends AnAction implements CustomComponentAction {

    private final String hyperlink = "https://docs.google.com/presentation/d/15Bw1qwvfuJ3bswOUS0HvNJbR2EVmHLtPk_cWNWuLVf0";

    public void actionPerformed(AnActionEvent e) {

    }

    @Override
    public JComponent createCustomComponent(Presentation presentation, String place) {
        return new HyperlinkButton("#defaults", hyperlink, "Show #defaults artifact");
    }
}
