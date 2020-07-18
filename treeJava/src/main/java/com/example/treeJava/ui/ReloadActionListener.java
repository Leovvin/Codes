package com.example.treeJava.ui;

import com.example.treeJava.model.IBinaryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.concurrent.ExecutorService;

@Component
public class ReloadActionListener implements ActionListener {
    @Autowired
    ShowPanel showPanel;
    @Autowired
    ExecutorService executorService;
    @Autowired
    IBinaryTree<Integer> binaryTree;

    @Override
    public void actionPerformed(ActionEvent e) {


        executorService.submit(()->{
            try {
                binaryTree.clear();
                Random random = new Random();
                random.ints(10,0,100)
                        .forEach(i->binaryTree.insert(i));

                SwingUtilities.invokeAndWait(()->{showPanel.repaint();});
                SwingUtilities.invokeLater(()->{
                    showPanel.refreshTree();
                });
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
        });
    }
}
