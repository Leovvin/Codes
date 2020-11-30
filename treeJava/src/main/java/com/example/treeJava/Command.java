package com.example.treeJava;

import com.example.treeJava.model.AVLTree;
import com.example.treeJava.model.TreeNode;
import com.example.treeJava.ui.ShowPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Objects;
import java.util.Stack;

@Component
public class Command implements CommandLineRunner {
    @Autowired
    JFrame showFrame;
    @Autowired
    ShowPanel showPanel;

    Consumer consumer = new Consumer() {
        @Override
        public void consume(Integer i) {
            System.out.print(i+" ");
        }
    };

    @Override
    public void run(String... args) throws Exception {

        AVLTree<Integer> avl = new AVLTree();

        for (int i=0;i<10;i++){
            avl.insert((int)(Math.random()*100));
        }

        TreeNode<Integer> node = avl.getRoot();
        System.out.println("preTravel_R");
        preOrder_R(node);
        System.out.println("");
        System.out.println("-------------");
        System.out.println("preTravel");
        preOrder(node);
        System.out.println("");
        System.out.println("-------------");
        System.out.println("middleTravel_R");
        middleOrder_R(node);
        System.out.println("");
        System.out.println("-------------");
        System.out.println("middleTravel");
        middleOrder(node);
        System.out.println("");
        System.out.println("-------------");

//        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
//            @Override
//            public void run() {
//                showFrame.setVisible(true);
//                showFrame.pack();
//            }
//        });
//        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
//            @Override
//            public void run() {
//                showPanel.refreshTree();
//            }
//        });
    }

    private void preOrder_R(TreeNode<Integer> node){
        if (Objects.isNull(node)){
            return;
        }
        consumer.consume(node.getData());
        preOrder_R(node.getLeft());
        preOrder_R(node.getRight());
    }
    private void middleOrder_R(TreeNode<Integer> node){
        if (Objects.isNull(node)){
            return;
        }
        middleOrder_R(node.getLeft());
        consumer.consume(node.getData());
        middleOrder_R(node.getRight());
    }

    private void preOrder(TreeNode<Integer> node){
        if (Objects.isNull(node)){
            return;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        while (node!=null || !stack.empty()){
            if (Objects.nonNull(node)){
                consumer.consume(node.getData());
                stack.push(node);
                node = node.getLeft();
            }else {
                node = stack.pop();
                node = node.getRight();
            }
        }
    }

    private void middleOrder(TreeNode<Integer> node){
        if (Objects.isNull(node)){
            return;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        while (node!=null || !stack.empty()){
            if (node!=null){
                stack.push(node);
                node = node.getLeft();
            }else {
                node = stack.pop();
                consumer.consume(node.getData());
                node = node.getRight();
            }
        }
    }

    interface Consumer{
        void consume(Integer i);
    }
}
