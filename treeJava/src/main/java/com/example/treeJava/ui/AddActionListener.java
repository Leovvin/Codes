package com.example.treeJava.ui;

import com.example.treeJava.model.IBinaryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class AddActionListener implements ActionListener {
    @Autowired
    ShowPanel showPanel;
    @Autowired
    OptionPanel optionPanel;
    @Autowired
    IBinaryTree<Integer> binaryTree;

    @Override
    public void actionPerformed(ActionEvent e) {
        binaryTree.addRoot(optionPanel.getInputValue());
        SwingUtilities.invokeLater(()->{
            showPanel.refreshTree();
        });
    }
}
