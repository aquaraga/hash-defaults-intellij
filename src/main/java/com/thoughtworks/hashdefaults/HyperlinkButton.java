package com.thoughtworks.hashdefaults;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class HyperlinkButton extends JButton {
    private final String tooltip;

    public HyperlinkButton(String text, String hyperlink, String tooltip) {
        super(text);
        this.tooltip = tooltip;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showHyperlinkTooltip();
            }
        });

        addActionListener(e -> {
            try {
                URI uri = new URI(hyperlink);
                java.awt.Desktop.getDesktop().browse(uri);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    private void showHyperlinkTooltip() {
        setToolTipText(tooltip);
    }
}