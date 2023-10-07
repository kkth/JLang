package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TaskScheduler {

    public static void main(String[] args){
        TaskScheduler taskScheduler = new TaskScheduler();
        Node root = taskScheduler.buildScheduler();
        taskScheduler.traverseScheduler(root);
    }

    class Node{
        String name;
        List<Node> children;

        public Node(String name) {
            this.name = name;
            children = new ArrayList<>();
        }
        public void addChild(Node node){
            children.add(node);
        }
    }

    Node buildScheduler(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        a.addChild(b);
        a.addChild(c);
        b.addChild(d);
        return a;
    }

    void traverseScheduler(Node root){
        if(root == null)
            return;

        List<List<String>> theTasks = new ArrayList<>();

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            List<String> curLayer = new ArrayList<>();
            for(int i = 0;i<len;i++){
                Node curNode = queue.poll();
                curLayer.add(curNode.name);
                List<Node> children = curNode.children;
                if(children != null){
                   for(int j=0;j<children.size();j++){
                       queue.add(children.get(j));
                   }
                }
            }

            theTasks.add(curLayer);
        }

        for(int i = theTasks.size()-1;i>=0;i--){
            for(int j= 0;j<theTasks.get(i).size();j++){
                System.out.println(theTasks.get(i).get(j));
            }
        }


    }
}
