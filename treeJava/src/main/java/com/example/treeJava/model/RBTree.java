package com.example.treeJava.model;

public class RBTree<T extends Comparable> extends BinarySearchTree<T> {

    @Override
    public RBNode<T> insert(T t) {
        RBNode node = (RBNode)super.insert(t);
        balanceInsert(node);
        return node;
    }

    @Override
    public RBNode<T> delete(T t) {
        RBNode node = (RBNode)super.delete(t);
        balanceDelete(node);
        return node;
    }

    @Override
    protected RBNode createNode(T t) {
        RBNode rbNode = new RBNode(t);
        return rbNode;
    }

    private void balanceInsert(RBNode node){
        for (RBNode x=node,p,pp,ppl,ppr;;){
            if (x == root){
                x.setRed(false);
                return;
            }
            if (!(p=x.getParent()).isRed()){
                return;
            }
            if (p==(ppl = (pp=p.getParent()).getLeft())){
                if ((ppr = pp.getRight())!=null && ppr.isRed()){
                    p.setRed(false);
                    ppr.setRed(false);
                    pp.setRed(true);
                    x = pp;
                }else {

                }
            }else {

            }
        }
    }

    private void balanceDelete(RBNode node){

    }

    private void rotateLeft(RBNode node){

    }

    private void rotateRight(RBNode node){

    }
}
