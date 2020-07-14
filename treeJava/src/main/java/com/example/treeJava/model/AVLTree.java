package com.example.treeJava.model;


import java.util.Objects;

public class AVLTree implements IBinaryTree<Integer> {
    TreeNode<Integer> root;

    TreeNode<Integer> succeed;

    @Override
    public TreeNode<Integer> getRoot() {
        return root;
    }

    @Override
    public TreeNode<Integer> addRoot(Integer t) {
        root = new TreeNode<>(t);
        root.setHeight(0);
        return root;
    }

    @Override
    public TreeNode<Integer> insert(Integer t) {
        if (Objects.isNull(root)){
            return addRoot(t);
        }
        root.setHeight(root.getHeight()+1);
        TreeNode node = new TreeNode<Integer>(t,root);
        root.left = node;
        return node;
    }

}
