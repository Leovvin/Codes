package com.example.treeJava.model;

import java.awt.*;

public class RBNode<T> extends TreeNode<T> {

    public RBNode(T t){
        super(t);
        isRed=true;
        this.color = Color.red;
    }
    boolean isRed ;

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        if (red){
            this.color= Color.red;
        }else {
            this.color= Color.blue;
        }
        isRed = red;
    }

    @Override
    public RBNode<T> getRight() {
        return (RBNode)super.getRight();
    }

    @Override
    public RBNode<T> getLeft() {
        return (RBNode)super.getLeft();
    }

    @Override
    public RBNode<T> getParent() {
        return (RBNode)super.getParent();
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }
}
