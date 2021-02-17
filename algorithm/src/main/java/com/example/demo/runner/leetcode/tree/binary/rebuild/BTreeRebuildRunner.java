package com.example.demo.runner.leetcode.tree.binary.rebuild;

import com.sun.tools.corba.se.idl.constExpr.GreaterThan;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "treeBuild")
public class BTreeRebuildRunner implements CommandLineRunner {

    @Data
    class Node{
        int value;
        Node left;
        Node right;
    }

    @Override
    public void run(String... args) throws Exception {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] midOrder = {4,7,2,1,5,3,8,6};

        Algorithm algorithm = new Algorithm();
        Node node = algorithm.buildTree(preOrder,0,preOrder.length-1,midOrder,0,midOrder.length-1);
        node.getValue();
    }

    class Algorithm{
        Node buildTree(int[] preOrder,int pl,int pr,int[] midOrder,int ml,int mr){
            if (pl>pr){
                return null;
            }else if (pl == pr){
                Node node = new Node();
                node.setValue(preOrder[pl]);
                return node;
            }

            Node root = new Node();
            int rootVal = preOrder[pl];
            root.setValue(rootVal);
            int ltl = 0;
            for (ltl=0;ml+ltl<mr;ltl++){
                if (midOrder[ml+ltl]==rootVal){
                    break;
                }
            }
            root.setLeft(buildTree(preOrder,pl+1,pl+ltl,midOrder,ml,ml+ltl-1));
            root.setRight(buildTree(preOrder,pl+ltl+1,pr,midOrder,ml+ltl+1,mr));
            return root;
        }
    }
}
