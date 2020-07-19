package com.example.treeJava.model;

public class AVLTree<T extends Comparable> extends BinarySortedTree<T> {

    @Override
    public TreeNode<T> insert(T t) {
        TreeNode treeNode = super.insert(t);
        return treeNode;
    }

    @Override
    public TreeNode<T> delete(T t) {
        TreeNode result = super.delete(t);

        return result;
    }
}
