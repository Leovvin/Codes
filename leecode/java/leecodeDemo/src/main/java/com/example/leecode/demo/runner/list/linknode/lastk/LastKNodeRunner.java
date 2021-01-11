package com.example.leecode.demo.runner.list.linknode.lastk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


/**
 * 题目：
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 */
@Component
@ConditionalOnProperty(name = "runner",havingValue = "lastKNode")
public class LastKNodeRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }

    class Node{
        int value;
        Node next;
    }

    private Node getLastKNode(Node head,int k){
        if (head==null){
            return null;
        }
        Node target=null,cur = head;
        for (int i = 0;i<k-1;i++){
            if (cur.next != null){
                cur = cur.next;
            }else {
                return null;
            }
        }

        target = head;

        while (cur.next!=null){
            target = target.next;
            cur = cur.next;
        }

        return target;
    }
}
