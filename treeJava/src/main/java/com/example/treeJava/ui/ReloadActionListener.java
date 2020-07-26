package com.example.treeJava.ui;

import com.example.treeJava.model.IBinaryTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.concurrent.ExecutorService;

@Component
@Slf4j
public class ReloadActionListener implements ActionListener {
    @Autowired
    ShowPanel showPanel;
    @Autowired
    ExecutorService executorService;
    @Autowired
    IBinaryTree<Integer> binaryTree;

    @Override
    public void actionPerformed(ActionEvent e) {
        log.info("reload tree start");

        executorService.submit(()->{
            try {
                binaryTree.clear();
                Random random = new Random();
                random.ints(10,0,500)
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
