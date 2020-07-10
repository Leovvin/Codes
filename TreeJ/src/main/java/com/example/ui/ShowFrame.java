package com.example.ui;

import javax.swing.*;
import java.awt.*;

public class ShowFrame extends JFrame {
    final int WIDTH=1000;
    final int HEIGHT=1000;

    public ShowFrame(){
        super("Show Tree Process");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ShowPanel showPanel = new ShowPanel();
        OptionPanel optionPanel = new OptionPanel();
        showPanel.setOptionPanel(optionPanel);
        optionPanel.setShowPanel(showPanel);
        this.setLayout(new BorderLayout());
        this.add(optionPanel,BorderLayout.NORTH);
        this.add(showPanel,BorderLayout.CENTER);
        this.setMinimumSize(new Dimension(SwingConsts.FRAME_WIDTH,SwingConsts.FRAME_HEIGHT));
    }
}
