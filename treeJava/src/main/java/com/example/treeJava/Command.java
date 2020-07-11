package com.example.treeJava;

import com.example.treeJava.ui.ShowFrame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Command implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                ShowFrame frame = new ShowFrame();
                frame.setVisible(true);
                frame.pack();
            }
        });
    }
}
