package com.example.treeJava.model;

import lombok.Data;

@Data
public class TreeNode<T> {

    T data;
    boolean isRed;
    int height;

    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parent;

    public TreeNode(T data){
        this.data = data;
    }

    public TreeNode(T data, TreeNode parent){
        this(data);
        this.parent = parent;
    }

}
