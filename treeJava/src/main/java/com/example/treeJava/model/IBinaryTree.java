package com.example.treeJava.model;

public interface IBinaryTree<T> {

    TreeNode<T> getRoot();

    TreeNode<T> addRoot(T t);

    TreeNode<T> insert(T t);

    void traversal(Visitor visitor);

    public interface Visitor<T>{
        public void visit(TreeNode<T> treeNode);
    }
}
