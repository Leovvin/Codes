package com.example.treeJava.model;


import java.util.Objects;

public abstract class BinaryTree<T> implements IBinaryTree<T> {
    TreeNode<T> root;

    @Override
    public TreeNode<T> getRoot() {
        return root;
    }

    @Override
    public void traversal(Visitor visitor) {
        doPreOrderTraversal(visitor,root);
    }

    private void doPreOrderTraversal(Visitor visitor,TreeNode treeNode){
        if (Objects.isNull(treeNode)){
            return;
        }
        visitor.visit(treeNode);
        doPreOrderTraversal(visitor,treeNode.getLeft());
        doPreOrderTraversal(visitor,treeNode.getRight());
    }
}
