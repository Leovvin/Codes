package com.example.demo.runner.leetcode.list.linkedlist.delete;

import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。链表结点与函数的定义如下：
 *
 * class ListNode{
 *     int value;
 *     ListNode next;
 * }
 *
 * void deleteNode(ListNode head,ListNode toBeDelete){
 *
 * }
 */

@Component
@ConditionalOnProperty(name = "runner",havingValue = "deleteNode")
public class DeleteNodeRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }

    private void deleteNode(ListNode head,ListNode toBeDelete){
        if (toBeDelete.next!=null){
            toBeDelete.setValue(toBeDelete.getNext().getValue());
            toBeDelete.setNext(toBeDelete.getNext().getNext());
        }else if (head == toBeDelete){
            head=null;
        }else {
            ListNode cur = head;
            while (cur.getNext()!= toBeDelete){
                cur = cur.getNext();
            }
            cur.setNext(null);
        }
    }

    @Data
    class ListNode{
        int value;
        ListNode next;
    }
}
