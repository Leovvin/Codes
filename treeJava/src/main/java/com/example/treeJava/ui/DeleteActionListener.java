package com.example.treeJava.ui;

import com.example.treeJava.model.IBinaryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class DeleteActionListener implements ActionListener {
    @Autowired
    ShowPanel showPanel;

    @Autowired
    OptionPanel optionPanel;
    @Autowired
    IBinaryTree<Integer> binaryTree;
    @Autowired
    ExecutorService executorService;

    @Override
    public void actionPerformed(ActionEvent e) {
        binaryTree.delete(optionPanel.getInputValue());

        Runnable refreshUI = new Runnable(){
            @Override
            public void run() {
                try {
                    SwingUtilities.invokeAndWait(()->{showPanel.repaint();});
                    SwingUtilities.invokeLater(()->{
                        showPanel.refreshTree();
                    });
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (InvocationTargetException invocationTargetException) {
                    invocationTargetException.printStackTrace();
                }
            }
        };
        executorService.submit(refreshUI);

    }
}
