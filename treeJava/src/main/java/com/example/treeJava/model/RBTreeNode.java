package com.example.treeJava.model;

import java.awt.*;

public class RBTreeNode<T> extends TreeNode<T> {

    public RBTreeNode(T t){
        super(t);
        isRed=true;
        this.color = Color.red;
    }
    boolean isRed ;

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        if (isRed){
            this.color= Color.red;
        }else {
            this.color= Color.blue;
        }
        isRed = red;
    }
}
