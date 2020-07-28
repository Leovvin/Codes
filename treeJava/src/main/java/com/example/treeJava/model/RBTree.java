package com.example.treeJava.model;

import org.springframework.stereotype.Component;

@Component
public class RBTree<T extends Comparable> extends BinarySearchTree<T> {

    @Override
    public TreeNode<T> insert(T t) {
        return super.insert(t);
    }

    @Override
    public TreeNode<T> delete(T t) {
        return super.delete(t);
    }
}
