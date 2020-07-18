package com.example.treeJava;

import com.example.treeJava.ui.ShowPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Command implements CommandLineRunner {
    @Autowired
    JFrame showFrame;
    @Autowired
    ShowPanel showPanel;

    @Override
    public void run(String... args) throws Exception {

        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                showFrame.setVisible(true);
                showFrame.pack();
            }
        });
        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                showPanel.refreshTree();
            }
        });
    }
}
