package com.example.treeJava.model;


public class AVLTree<T> implements IBinaryTree<T> {
    TreeNode<T> root;

    @Override
    public TreeNode<T> getRoot() {
        return root;
    }

    @Override
    public TreeNode<T> addRoot(T t) {
        root = new TreeNode<>(t);
        return root;
    }
}
