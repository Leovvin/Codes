package com.example.treeJava.model;

import lombok.Data;

@Data
public class AVLTreeNode<T> extends TreeNode<T> {
    public AVLTreeNode(T t){
        super(t);
    }

    int height = 0;


    @Override
    public String toString(){
        return getData().toString()+":"+getHeight();
    }
}
