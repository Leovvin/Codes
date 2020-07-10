package com.example.model;

import lombok.Data;

@Data
public class TreeNode<T> {

    T data;
    boolean isRed;
    int height;

    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parent;

}
