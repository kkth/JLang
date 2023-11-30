package com.kun;


import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class SymmetricTree_101 {
    public static void main(String[] args){
        Integer[] nodes = new Integer[]{1,2,2,null,3,null,3};
        TreeNode root = BTrees.buildFromBFS(nodes);
        SymmetricTree_101 symmetricTree101 = new SymmetricTree_101();
        System.out.println(symmetricTree101.isSymmetric(root));
    }
    public boolean isSymmetric(TreeNode root) {
        /*
            Dqeue does not support null value, a class used to wrap
            TreeNode so that we can support both actual node and node
            does not exist
         */
        class NodeInQueue{
            boolean isEmpty;
            TreeNode node;
            NodeInQueue(boolean isEmpty, TreeNode node){
               this.isEmpty = isEmpty;
               this.node = node;
            }

            @Override
            public String toString() {
                return "NodeInQueue{" +
                        "isEmpty=" + isEmpty +
                        ", nodeVal=" + ((node==null)?"":node.val) +
                        '}';
            }
        }

        boolean ret = true;
        if(root == null)
            return ret;

        Deque<NodeInQueue> queue = new ArrayDeque<>();
        queue.add(new NodeInQueue(false,root));
        //Loop by layer
        while(!queue.isEmpty()){
            //This is length of current layer
            int len = queue.size();
            //Try to counteract all nodes (including empty and non-empty nodes) in the same layer
            //to find whether they are symmetric
            Stack<NodeInQueue> stack = new Stack<>();
            //Just record all nodes in this layer
            List<NodeInQueue> _trackLayer = new ArrayList<>();
            //Stop the loop when step into a layer with all nodes empty
            boolean allEmpty = true;

            //Loop current layer
            for(int i = 0;i<len;i++){
                NodeInQueue nodeWrapper = queue.pop();
                _trackLayer.add(nodeWrapper);

                if(nodeWrapper.isEmpty){
                    //Dummy left
                    queue.add(new NodeInQueue(true,null));
                    //Dummy right
                    queue.add(new NodeInQueue(true,null));
                }else{
                    //find at least one actual node
                    allEmpty = false;
                    if(nodeWrapper.node.left != null){
                        queue.add(new NodeInQueue(false,nodeWrapper.node.left));
                    }else{
                        queue.add(new NodeInQueue(true,null));
                    }

                    if(nodeWrapper.node.right != null){
                        queue.add(new NodeInQueue(false,nodeWrapper.node.right));
                    }else{
                        queue.add(new NodeInQueue(true,null));
                    }
                }

                //Skip the root node (because this is only layer with odd node number: no way to counteract!)
                if(len != 1){
                    if(!stack.isEmpty()){
                        NodeInQueue top = stack.peek();
                        //both empty, pop and discard both
                        if(top.isEmpty && nodeWrapper.isEmpty){
                            stack.pop();
                        }else
                            //both non-empty, check the value
                            if(!top.isEmpty && !nodeWrapper.isEmpty){
                                if(top.node.val == nodeWrapper.node.val){
                                    //pop and discard both
                                    stack.pop();
                                }
                                //No counteract, save it
                            } else{
                                stack.add(nodeWrapper);
                            }
                    }else{//Fist node in this layer, save it
                        stack.add(nodeWrapper);
                    }

                }
            }
            //Just debug
            System.out.println(Arrays.toString(_trackLayer.toArray()));

            //Finish current layer, check whether the stack is empty
            if(!stack.isEmpty()){
              ret = false;
              break;
            }

            //No actual node is left
            if(allEmpty) {
                break;
            }
        }

        return ret;
    }

}


