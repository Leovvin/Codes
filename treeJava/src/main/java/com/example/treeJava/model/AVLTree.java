package com.example.treeJava.model;

import java.util.Objects;

public class AVLTree<T extends Comparable> extends BinarySortedTree<T> {

    @Override
    public TreeNode<T> insert(T t) {
        AVLTreeNode node = (AVLTreeNode)super.insert(t);

        for (AVLTreeNode cur=(AVLTreeNode)_hot;Objects.nonNull(cur);cur=cur.getParent()){
            if (isBalance(cur)){
                updateHeight(cur);
            }else {
                AVLTreeNode parent = cur.getParent();
                boolean isLeftChild = isLeftChild(cur);
                AVLTreeNode node1=rotateAt(tallerChild(tallerChild(cur)));
                setChild(parent,node1,isLeftChild);
                break;
            }
        }
        return node;
    }

    @Override
    public TreeNode<T> delete(T t) {
        AVLTreeNode node = (AVLTreeNode)super.delete(t);
        return node;
    }

    @Override
    protected AVLTreeNode createNode(T t) {
        return new AVLTreeNode(t);
    }

    private AVLTreeNode rotateAt(AVLTreeNode node){
        AVLTreeNode p = node.getParent();
        AVLTreeNode g = p.getParent();

        if (isLeftChild(p)){
            if (isLeftChild(node)){
                p.setParent(g.getParent());
                return connect34(node,p,g,node.getLeft(),node.getRight(),p.getRight(),g.getRight());
            }else {
                node.setParent(g.getParent());
                return connect34(p,node,g,p.getLeft(),node.getLeft(),node.getRight(),g.getRight());
            }
        }else {
            if (isLeftChild(node)){
                node.setParent(g.getParent());
                return connect34(g,node,p,g.getLeft(),node.getLeft(),node.getRight(),p.getRight());
            }else {
                p.setParent(g.getParent());
                return connect34(g,p,node,g.getLeft(),p.getLeft(),node.getLeft(),node.getRight());
            }
        }
    }

    private void setChild(AVLTreeNode p,AVLTreeNode n,boolean isLeft){
        if (Objects.nonNull(p)){
            if (isLeft){
                p.setLeft(n);
            }else {
                p.setRight(n);
            }
        }
    }

    private AVLTreeNode connect34(AVLTreeNode a,AVLTreeNode b,AVLTreeNode c
            ,AVLTreeNode t1,AVLTreeNode t2,AVLTreeNode t3,AVLTreeNode t4){
        a.setLeft(t1);
        if (Objects.nonNull(t1)){
            t1.setParent(a);
        }
        a.setRight(t2);
        if (Objects.nonNull(t2)){
            t2.setParent(a);
        }
        updateHeight(a);

        c.setLeft(t3);
        if (Objects.nonNull(t3)){
            t3.setParent(c);
        }
        c.setRight(t4);
        if (Objects.nonNull(t4)){
            t4.setParent(c);
        }
        updateHeight(c);


        b.setLeft(a);a.setParent(b);
        b.setRight(c);c.setParent(b);
        updateHeight(b);
        if(Objects.isNull(b.getParent())){
            root = b;
        }
        return b;
    }

    private AVLTreeNode tallerChild(AVLTreeNode node){
        return getHeight(node.getLeft())>getHeight(node.getRight())?node.getLeft():
                getHeight(node.getLeft())<getHeight(node.getRight())?node.getRight():
                        isLeftChild(node)?node.getLeft():node.getRight();

    }

    private void updateHeight(AVLTreeNode node){
        Integer newHeight = Math.max(getHeight(node.getLeft()),getHeight(node.getRight()))+1;
        node.setHeight(newHeight);
    }

    private Integer getHeight(TreeNode node){
        if (Objects.isNull(node)){
            return -1;
        }
        return ((AVLTreeNode)node).getHeight();
    }

    private boolean isBalance(AVLTreeNode node){
        return Math.abs(getHeight(node.getLeft())-getHeight(node.getRight()))<2;
    }
}
