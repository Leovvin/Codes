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
import java.util.Objects;

@Component
public class ShowPanel extends JPanel {
    @Autowired
    IBinaryTree binaryTree;

    public void refreshTree(){
        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D) g;

        binaryTree.traversal(treeNode -> drawNode(g2,generateShowNode(treeNode)));
    }

    private ShowNodeBean generateShowNode(TreeNode treeNode){
        if (Objects.isNull(treeNode.getParent())){
            return generateRoot(treeNode);
        }else {
            return generateChild(treeNode);
        }
    }

    private ShowNodeBean generateRoot(TreeNode treeNode){
        Integer middle = this.getWidth()>>>1;
        Integer offset = ShowNodeBean.WIDTH>>>1;
        ShowNodeBean showNodeBean = new ShowNodeBean(middle-offset,10,treeNode.toString(),null);
        showNodeBean.setColor(treeNode.getColor());
        treeNode.setShowNodeBean(showNodeBean);
        return showNodeBean;
    }

    private ShowNodeBean generateChild(TreeNode treeNode){
        ShowNodeBean parentShowNodeBean = treeNode.getParent().getShowNodeBean();
        Integer level = 1;
        TreeNode tmp = treeNode;
        while (tmp.getParent() != binaryTree.getRoot()){
            level++;
            tmp = tmp.getParent();
        }
        Integer offset = SwingConsts.FRAME_WIDTH >>> level +1;
        boolean isLeft = treeNode.getParent().getLeft() == treeNode;
        if (isLeft){
            ShowNodeBean showNodeBean = new ShowNodeBean(parentShowNodeBean.getX()-offset, parentShowNodeBean.getY()+70,treeNode.toString(),parentShowNodeBean);
            showNodeBean.setColor(treeNode.getColor());
            treeNode.setShowNodeBean(showNodeBean);
            return showNodeBean;
        }else {
            ShowNodeBean showNodeBean = new ShowNodeBean(parentShowNodeBean.getX()+offset, parentShowNodeBean.getY()+70,treeNode.toString(),parentShowNodeBean);
            showNodeBean.setColor(treeNode.getColor());
            treeNode.setShowNodeBean(showNodeBean);
            return showNodeBean;
        }
    }


    private void drawLineBetweenNodes(Graphics2D g2, ShowNodeBean nodeBean){
        if (Objects.isNull(nodeBean.getParent())){
           return;
        }

        Integer offsetX= ShowNodeBean.WIDTH>>>1;
        Integer offsetY = ShowNodeBean.HEIGHT;
        ShowNodeBean parentBean = nodeBean.getParent();

        g2.drawLine(parentBean.getX()+offsetX,parentBean.getY()+offsetY,nodeBean.getX()+offsetX,nodeBean.getY());
    }

    private void drawNode(Graphics2D g2, ShowNodeBean showNodeBean){
        g2.setColor(showNodeBean.getColor());
        g2.fillRect(showNodeBean.getX(), showNodeBean.getY(),ShowNodeBean.WIDTH,ShowNodeBean.HEIGHT);

        g2.setColor(Color.black);

        {
            Point2D loc = new Point(showNodeBean.getX()+10, showNodeBean.getY()+13);
            Font font = g2.getFont();
            FontRenderContext frc = g2.getFontRenderContext();
            TextLayout layout = new TextLayout(showNodeBean.getData(), font, frc);
            layout.draw(g2, (float)loc.getX(), (float)loc.getY());
        }

        drawLineBetweenNodes(g2,showNodeBean);

    }
}
