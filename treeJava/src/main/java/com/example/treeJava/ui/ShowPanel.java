package com.example.treeJava.ui;

import javax.swing.*;
import java.awt.*;


public class ShowPanel extends JPanel {

    OptionPanel optionPanel;
    public ShowPanel(){
        this.add(new JLabel("hello"));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1) );
    }

    public void setOptionPanel(OptionPanel optionPanel) {
        this.optionPanel = optionPanel;
    }
}
