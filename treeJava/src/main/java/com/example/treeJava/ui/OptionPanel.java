package com.example.treeJava.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OptionPanel extends JPanel {

    ShowPanel showPanel;

    JTextField input;
    JButton addButton ;
    JButton nextButton ;
    public OptionPanel(){
        input = new JTextField(16);
        addButton = new JButton("Add");
        nextButton = new JButton("Next");
        addButton.addActionListener(addAction);
        this.add(input);
        this.add(addButton);
        this.add(nextButton);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1) );
    }

    ActionListener addAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    ActionListener nextAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };


    public void setShowPanel(ShowPanel showPanel) {
        this.showPanel = showPanel;
    }
}
