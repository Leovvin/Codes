package com.example.treeJava.config;

import com.example.treeJava.model.AVLTree;
import com.example.treeJava.model.IBinaryTree;
import com.example.treeJava.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.jvm.hotspot.ui.GraphicsUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

@Configuration
public class UIConfig {

    @Autowired
    OptionPanel optionPanel;
    @Autowired
    ShowPanel showPanel;

    @Bean("showFrame")
    public JFrame initShowFrame(AddActionListener addActionListener, DeleteActionListener deleteActionListener,
                                ReloadActionListener reloadActionListener){
        showPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1) );
        showPanel.setBackground(Color.decode("#D3D3D3"));

        JTextField input = new JTextField(16);
        JButton addButton = new JButton("Add");
        JButton rmButton = new JButton("Delete");
        JButton reloadButton = new JButton("Reload");
        JButton nextButton = new JButton("Next");
        addButton.addActionListener(addActionListener);
        rmButton.addActionListener(deleteActionListener);
        reloadButton.addActionListener(reloadActionListener);
        optionPanel.add(input);
        optionPanel.add(addButton);
        optionPanel.add(rmButton);
        optionPanel.add(reloadButton);
        optionPanel.add(nextButton);
        optionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1) );
        optionPanel.setInput(input);

        JFrame showFrame = new JFrame("Show Tree Process");
        showFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        showFrame.setLayout(new BorderLayout());
        showFrame.add(optionPanel,BorderLayout.NORTH);
        showFrame.add(showPanel,BorderLayout.CENTER);
        showFrame.setMinimumSize(new Dimension(SwingConsts.FRAME_WIDTH,SwingConsts.FRAME_HEIGHT));
        return showFrame;
    }

    @Bean
    public IBinaryTree<Integer> initBinaryTree(){
        IBinaryTree<Integer> tree = new AVLTree();
        Random random = new Random();
        random.ints(10,0,100)
                .forEach(i->tree.insert(i));
        return tree;
    }

    @Bean
    public ExecutorService executorService(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        return executorService;
    }

}
