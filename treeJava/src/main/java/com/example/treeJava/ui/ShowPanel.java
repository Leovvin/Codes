package com.example.treeJava.ui;

import com.example.treeJava.model.IBinaryTree;
import com.example.treeJava.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

@Component
public class ShowPanel extends JPanel {
    @Autowired
    IBinaryTree binaryTree;

    public void refreshTree(){
        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D) g;

        TreeNode rootNode = binaryTree.getRoot();
        ShowNode rootShowNode = generateRoot(rootNode);
        appendNode(g2,null,rootShowNode);

        if (Objects.nonNull(rootNode.getLeft())){
            ShowNode child = generateChild(rootNode,true);
            appendNode(g2,rootShowNode,child);
        }
    }

    private ShowNode generateRoot(TreeNode treeNode){
        Integer middle = this.getWidth()>>>1;
        ShowNode showNode = new ShowNode(middle-40,10,treeNode.getData().toString(),Integer.toString(treeNode.getHeight()));
        treeNode.setShowNode(showNode);
        return  showNode;
    }

    private ShowNode generateChild(TreeNode treeNode,boolean isLeft){
        ShowNode parentShowNode = treeNode.getShowNode();
        if (isLeft){
            TreeNode child = treeNode.getLeft();
            ShowNode showNode = new ShowNode(parentShowNode.getX()-100,parentShowNode.getY()+50,child.getData().toString(),Integer.toString(child.getHeight()));
            child.setShowNode(showNode);
            return showNode;
        }else {
            TreeNode child = treeNode.getRight();
            ShowNode showNode = new ShowNode(parentShowNode.getX()-100,parentShowNode.getY()+50,child.getData().toString(),Integer.toString(child.getHeight()));
            child.setShowNode(showNode);
            return showNode;
        }
    }

    private void appendNode(Graphics2D g2,ShowNode parent,ShowNode node){
        if (Objects.nonNull(parent)){
            drawLineBetweenNodes(g2,parent,node);
        }
        drawNode(g2,node);
    }

    private void drawLineBetweenNodes(Graphics2D g2,ShowNode parent,ShowNode node){

    }

    private void drawNode(Graphics2D g2,ShowNode showNode){
        g2.setColor(Color.PINK);
        g2.fillRect(showNode.getX(),showNode.getY(),80,35);

        g2.setColor(Color.black);

        {
            Point2D loc = new Point(showNode.getX()+10,showNode.getY()+13);
            Font font = g2.getFont();
            FontRenderContext frc = g2.getFontRenderContext();
            TextLayout layout = new TextLayout(showNode.getPrimaryData(), font, frc);
            layout.draw(g2, (float)loc.getX(), (float)loc.getY());
        }

        {
            Point2D loc1 = new Point(showNode.getX()+10,showNode.getY()+28);
            Font font1 = g2.getFont();
            FontRenderContext frc1 = g2.getFontRenderContext();
            TextLayout layout1 = new TextLayout(showNode.getSecondaryData(), font1, frc1);
            layout1.draw(g2, (float) loc1.getX(), (float) loc1.getY());
        }
    }
}
