package com.example.demo.runner.leetcode.queue.build.stack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "stackBuildQueue")
public class StackBuildQueueRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Queue<Integer> queue = new Queue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        int i = queue.take();
        queue.offer(4);
        while (!queue.isEmpty()){
            int k = queue.take();
            Integer.toString(k);
        }
    }


    class Queue<T>{
        Stack<T> s1 = new Stack();
        Stack<T> s2 = new Stack();

        boolean isEmpty(){
            return s1.isEmpty()&&s2.isEmpty();
        }

        void offer(T t){
            s1.push(t);
        }

        T take(){
            if (s2.isEmpty()){
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }

            if (s2.isEmpty()){
                return null;
            }
            return s2.pop();

        }

    }
}
