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
        if (isRed){
            this.color= Color.red;
        }else {
            this.color= Color.blue;
        }
        isRed = red;
    }
}
