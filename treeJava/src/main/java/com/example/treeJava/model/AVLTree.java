package com.example.treeJava.model;

import java.util.Objects;

public class AVLTree<T extends Comparable> extends BinarySortedTree<T> {

    @Override
    public TreeNode<T> insert(T t) {
        AVLTreeNode node = (AVLTreeNode)super.insert(t);
        updateHeight(node);
        return node;
    }

    @Override
    public TreeNode<T> delete(T t) {
        AVLTreeNode node = (AVLTreeNode)super.delete(t);
        updateHeight(node);
        return node;
    }

    @Override
    protected TreeNode createNode(T t) {
        return new AVLTreeNode(t);
    }

    private void updateHeight(AVLTreeNode node){
        while (Objects.nonNull(node)){
            Integer newHeight = Math.max(getHeight(node.getLeft()),getHeight(node.getRight()))+1;
            if (node.getHeight() == newHeight && newHeight != 0){
                break;
            }
            node.setHeight(newHeight);
            node = (AVLTreeNode)node.getParent();
        }
    }



    private Integer getHeight(TreeNode node){
        if (Objects.isNull(node)){
            return -1;
        }
        return ((AVLTreeNode)node).getHeight();
    }
}
