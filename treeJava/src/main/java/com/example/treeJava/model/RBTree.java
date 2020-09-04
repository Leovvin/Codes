package com.example.treeJava.model;

import java.util.Objects;

public class RBTree<T extends Comparable> extends BinarySearchTree<T> {

    @Override
    public RBNode<T> insert(T t) {
        RBNode node = (RBNode)super.insert(t);
        if (node == null){
            return null;
        }
        balanceInsert(node);

        root = root.getRoot();
        return node;
    }

    @Override
    public RBNode<T> delete(T t) {
        RBNode<T> node = (RBNode<T>)super.search(t);

        RBNode<T> replace,sub;
        if (Objects.nonNull(node.getLeft())){
            replace = node;
            sub = node.getLeft();
        }else if (Objects.nonNull(node.getRight())){
            replace = node;
            sub = node.getRight();
        }else {
            replace = node.getRight();
            while (Objects.nonNull(replace.getLeft())){
                replace = replace.getLeft();
            }
            sub = replace.getRight();
        }

        if (replace == root){
            root = sub;
            sub.setRed(false);
            sub.setParent(null);
            return replace;
        }
        boolean isRed = replace.isRed();

        if(replace == replace.getParent().getLeft()){
            replace.getParent().setLeft(sub);
        }else {
            replace.getParent().setRight(sub);
        }

        if (replace == node){
            sub.setParent(replace.getParent());
        }else {
            if (node == replace.getParent()){

            }
        }



        return node;
    }

    @Override
    protected RBNode createNode(T t) {
        RBNode rbNode = new RBNode(t);
        return rbNode;
    }

    private void balanceInsert(RBNode node){
        for (RBNode x=node,xp,xpp;;){
            xp = x.getParent();
            if (xp==null){
                x.setRed(false);
                return;
            }
            if (!xp.isRed()){
                return;
            }
            xpp = xp.getParent();
            if (xp==xpp.getLeft()){
                if (xpp.getRight()!=null && xpp.getRight().isRed()){
                    xpp.setRed(true);
                    xp.setRed(false);
                    xpp.getRight().setRed(false);
                    x=xpp;
                }else {
                    if (x==xp.getRight()){
                        x = xp;
                        rotateLeft(x);
                    }
                    xp = x.getParent();
                    xp.setRed(false);
                    xpp.setRed(true);
                    rotateRight(xpp);
                    return;
                }
            }else {
                if (xpp.getLeft()!=null&& xpp.getLeft().isRed()){
                    xpp.setRed(true);
                    xp.setRed(false);
                    xpp.getLeft().setRed(false);
                    x = xpp;
                }else {
                    if (x == xp.getLeft()){
                        x = xp;
                        rotateRight(x);
                    }
                    xp = x.getParent();
                    xp.setRed(false);
                    xpp.setRed(true);
                    rotateLeft(xpp);
                    return;
                }
            }
        }
    }

    private void balanceDelete(RBNode node){

    }

    private void rotateLeft(RBNode node){
        RBNode r,p;
        r = node.getRight();
        p = node.getParent();

        node.setParent(r);
        node.setRight(r.getLeft());
        if (r.getLeft()!=null){
            r.getLeft().setParent(node);
        }

        r.setParent(p);
        r.setLeft(node);

        if (p != null){
            if (p.getLeft() == node){
                p.setLeft(r);
            }else {
                p.setRight(r);
            }
        }
    }

    private void rotateRight(RBNode node){
        RBNode l,p;
        l=node.getLeft();
        p = node.getParent();

        node.setLeft(l.getRight());
        if (l.getRight()!= null){
            l.getRight().setParent(node);
        }
        node.setParent(l);

        l.setRight(node);
        l.setParent(p);

        if (p!=null){
            if (node == p.getLeft()){
                p.setLeft(l);
            }else {
                p.setRight(l);
            }
        }
    }
}
