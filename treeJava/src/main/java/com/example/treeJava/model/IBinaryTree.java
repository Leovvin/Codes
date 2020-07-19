package com.example.treeJava.model;

public interface IBinaryTree<T> {

    TreeNode<T> getRoot();

    TreeNode<T> insert(T t);

    void clear();

    TreeNode<T> delete(T t);

    void traversal(Visitor visitor);

    interface Visitor<T>{
        void visit(TreeNode<T> treeNode);
    }
}
