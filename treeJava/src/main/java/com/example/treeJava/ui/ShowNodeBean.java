package com.example.treeJava.ui;

import lombok.Data;

import java.awt.*;

@Data

public class ShowNodeBean {
    public static final Integer WIDTH=40;
    public static final Integer HEIGHT=35;

    int x,y;
    String data;
    ShowNodeBean parent;
    Color color ;

    public ShowNodeBean(int x, int y, String data, ShowNodeBean parent) {
        this.x = x;
        this.y = y;
        this.data = data;
        this.parent = parent;
    }

}
