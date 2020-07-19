package com.example.treeJava.model;


import java.util.Objects;

public class BinarySortedTree<T extends Comparable> extends BinaryTree<T> {

    TreeNode<T> succeed;

    @Override
    public TreeNode<T> insert(T t) {
        if (Objects.isNull(root)){
            return addRoot(t);
        }

        if (Objects.nonNull(search(t))){
            return null;
        }
        TreeNode node ;
        if (succeed.getData().compareTo(t)<0){
            node = new TreeNode(t,succeed);
            succeed.setRight(node);
        }else {
            node = new TreeNode(t,succeed);
            succeed.setLeft(node);
        }

        updateHeight(node);

        return node;
    }

    private TreeNode<T> addRoot(T t) {
        root = new TreeNode<>(t);
        root.setHeight(0);
        return root;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public TreeNode<T> delete(T t) {
        TreeNode<T> node = search(t);
        if (Objects.isNull(node)){
            return null;
        }

        TreeNode<T> candidate;
        if (Objects.nonNull(node.getLeft())&& Objects.nonNull(node.getRight())){
            candidate = getMostLeftDescendant(node);
            T tmp = node.getData();
            node.setData(candidate.getData());
            candidate.setData(tmp);
        }else {
            candidate=node;
        }
        doDeleteNode(candidate);

        TreeNode returnVal = candidate.getParent();
        return returnVal;
    }

    private void doDeleteNode(TreeNode node){
        if (Objects.nonNull(node.getRight())){
            TreeNode child = node.getRight();
            if (isLeftChild(node)){
                node.getParent().setLeft(child);
            }else {
                node.getParent().setRight(child);
            }
            child.setParent(node.getParent());
        }else if (Objects.nonNull(node.getLeft())){
            TreeNode child = node.getLeft();
            if (isLeftChild(node)){
                node.getParent().setLeft(child);
            }else {
                node.getParent().setRight(child);
            }
            child.setParent(node.getParent());
        }else {
            if (node == root){
                root =null;
            }else if (isLeftChild(node)){
                node.getParent().setLeft(null);
            }else {
                node.getParent().setRight(null);
            }
        }
        updateHeight(node.getParent());
    }

    private boolean isLeftChild(TreeNode node){
        if (node == root){
            return false;
        }

        return node.getParent().getLeft()==node;
    }


    private TreeNode getMostLeftDescendant(TreeNode treeNode){
        TreeNode result = treeNode.getRight();
        while (Objects.nonNull(result.getLeft())){
            result = result.getLeft();
        }
        return result;
    }

    private void updateHeight(TreeNode node){
        while (Objects.nonNull(node)){
            Integer newHeight = Math.max(getHeight(node.getLeft()),getHeight(node.getRight()))+1;
            if (node.getHeight() == newHeight && newHeight != 0){
                break;
            }
            node.setHeight(newHeight);
            node = node.getParent();
        }
    }

    private Integer getHeight(TreeNode node){
        if (Objects.isNull(node)){
            return -1;
        }
        return node.getHeight();
    }

    public TreeNode search(T t){
        if (Objects.isNull(root)){
            return null;
        }
        TreeNode<T> result = succeed = root;
        while (Objects.nonNull(result)){
            if (result.getData().equals(t)){
                return result;
            }else if (result.getData().compareTo(t) < 0){
                succeed = result;
                result = succeed.getRight();
            }else {
                succeed = result;
                result = succeed.getLeft();
            }
        }
        return null;
    }


}
