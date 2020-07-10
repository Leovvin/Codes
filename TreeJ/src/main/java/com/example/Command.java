package com.example;

import com.example.ui.ShowFrame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

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
