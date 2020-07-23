package com.example.treeJava.model;

import lombok.Data;

@Data
public class AVLTreeNode<T> extends TreeNode<T> {
    public AVLTreeNode(T t){
        super(t);
    }

    int height = 0;

    @Override
    public AVLTreeNode<T> getParent() {
        return (AVLTreeNode)super.getParent();
    }

    @Override
    public AVLTreeNode<T> getLeft() {
        return (AVLTreeNode)super.getLeft();
    }

    @Override
    public AVLTreeNode<T> getRight() {
        return (AVLTreeNode)super.getRight();
    }

    @Override
    public String toString(){
        return getData().toString()+":"+getHeight();
    }
}
