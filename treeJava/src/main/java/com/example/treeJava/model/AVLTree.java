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

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Integer delete(Integer integer) {
        TreeNode<Integer> node = search(integer);
        if (Objects.isNull(node)){
            return null;
        }

        TreeNode candidate;
        if (Objects.nonNull(node.getRight())){
            candidate = getMostLeftDescendant(node);
            if (candidate.getParent().getLeft() == candidate){
                candidate.getParent().setLeft(candidate.getRight());
            }else {
                candidate.getParent().setRight(candidate.getRight());
            }
            if (Objects.nonNull(node.getLeft())){
                node.getLeft().setParent(candidate);
            }
            node.getRight().setParent(candidate);
            candidate.setLeft(node.getLeft());
            candidate.setRight(node.getRight());
            if (Objects.nonNull(node.getParent())){
                if (node.getParent().getLeft() == node){
                    node.getParent().setLeft(candidate);
                }else {
                    node.getParent().setRight(candidate);
                }
            }
        }else if (Objects.nonNull(node.getLeft())){
            candidate = node.getLeft();
            if (Objects.nonNull(node.getParent())){
                if (node.getParent().getLeft() == node){
                    node.getParent().setLeft(candidate);
                }else {
                    node.getParent().setRight(candidate);
                }
            }
        }else {
            candidate = null;
            if (Objects.nonNull(node.getParent())){
                if (node.getParent().getLeft() == node){
                    node.getParent().setLeft(candidate);
                }else {
                    node.getParent().setRight(candidate);
                }
            }
        }

        if (root == node){
            root = candidate;
        }

        return node.getData();
    }


    private TreeNode getMostLeftDescendant(TreeNode treeNode){
        TreeNode result = treeNode.getRight();
        while (Objects.nonNull(result.getLeft())){
            result = result.getLeft();
        }
        return result;
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
