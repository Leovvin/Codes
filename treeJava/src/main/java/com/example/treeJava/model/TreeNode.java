package com.example.treeJava.model;

import com.example.treeJava.ui.ShowNodeBean;
import lombok.Data;

import java.awt.*;

@Data
public class TreeNode<T> {

    T data;
    Color color = Color.blue;

    int height = 0;

    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parent;

    ShowNodeBean showNodeBean;

    public TreeNode(T data){
        this.data = data;
    }

    public TreeNode(T data, TreeNode parent){
        this(data);
        this.parent = parent;
    }

    public TreeNode getRoot(){
        TreeNode tmp = this;
        while (tmp.getParent() != null){
            tmp = tmp.getParent();
        }
        return tmp;
    }

    @Override
    public String toString(){
        return getData().toString()+":"+getHeight();
    }

}
