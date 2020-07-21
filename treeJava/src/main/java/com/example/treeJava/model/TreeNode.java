package com.example.treeJava.model;

import com.example.treeJava.ui.ShowNodeBean;
import lombok.Data;

import java.awt.*;

@Data
public class TreeNode<T> {

    T data;
    Color color = Color.pink;

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

    @Override
    public String toString(){
        return getData().toString();
    }

}
