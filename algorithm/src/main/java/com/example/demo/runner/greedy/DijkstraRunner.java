package com.example.demo.runner.greedy;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.lang.Integer.MAX_VALUE;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "dijkstra")
public class DijkstraRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        int size=5;
        Map<Integer,Node> n = new HashMap<>();
        n.put(1,new Node("b",1));
        n.put(2,new Node("c",2));
        n.put(3,new Node("d",3));
        n.put(4,new Node("e",4));
        Set s = new HashSet();
        s.add(new Node("a",0));
        int[][] g= {{0,10, MAX_VALUE,30,100},
                {MAX_VALUE,0,50,MAX_VALUE,MAX_VALUE},
                {MAX_VALUE,MAX_VALUE,0,MAX_VALUE,10},
                {MAX_VALUE,MAX_VALUE,20,0,60},
                {MAX_VALUE,MAX_VALUE,MAX_VALUE,MAX_VALUE,0}};
        Integer dist[] = new Integer[size];
        Integer prev[] = new Integer[size];
        for (int i=0;i<size;i++){
            dist[i] = g[0][i];
            prev[i]=0;
        }

        while (!n.isEmpty()){
            int min = MAX_VALUE;
            Node minCostNode = null;
            for (int i=0;i<size;i++){
                if (dist[i]!=0 && dist[i]<min){
                    minCostNode = n.get(i);
                }
            }
            s.add(minCostNode);
            n.remove(minCostNode.index);
            
        }



        System.out.println("ss");
    }

    @Data
    @AllArgsConstructor
    class Node{
        String name;
        int index;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return index == node.index && Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, index);
        }
    }
}
