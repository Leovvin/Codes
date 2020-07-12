package com.example.treeJava.ui;

import com.example.treeJava.model.IBinaryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

@Component
public class ShowPanel extends JPanel {
    @Autowired
    IBinaryTree binaryTree;

    public void refreshTree(){

        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D) g;

        Point2D loc = new Point(120,120);
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        TextLayout layout = new TextLayout("This is a string", font, frc);
        layout.draw(g2, (float)loc.getX(), (float)loc.getY());

        Rectangle2D bounds = layout.getBounds();
        bounds.setRect(bounds.getX()+loc.getX(),
                  bounds.getY()+loc.getY(),
                  bounds.getWidth(),
                  bounds.getHeight());
    }

}
