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

        if (Objects.nonNull(search(t))){
            return null;
        }
        TreeNode node ;
        if (succeed.getData()<t){
            node = new TreeNode(t,succeed);
            succeed.setRight(node);
        }else {
            node = new TreeNode(t,succeed);
            succeed.setLeft(node);
        }
        updateHeight(node);
        return node;
    }

    private void updateHeight(TreeNode node){
        while (Objects.nonNull(node)&&Objects.nonNull(node.getParent())&&node.parent.getHeight() == node.getHeight()){
            node.parent.setHeight(node.getParent().getHeight()+1);
            node = node.getParent();
        }
    }

    public TreeNode<Integer> search(Integer t){
        if (Objects.isNull(root)){
            return null;
        }
        TreeNode<Integer> result = succeed = root;
        while (Objects.nonNull(result)){
            if (result.getData().equals(t)){
                return result;
            }else if (result.getData() < t){
                succeed = result;
                result = succeed.getRight();
            }else {
                succeed = result;
                result = succeed.getLeft();
            }
        }
        return null;
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
