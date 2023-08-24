package com.kun;

import java.util.ArrayDeque;
import java.util.Deque;

public class BTrees {

/*

          10
        /    \
      5       15
    /   \       \
    3   7       18

 */

    public static TreeNode getTree(){
        return new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3),
                        new TreeNode(7)),
                new TreeNode(15,
                        null,
                        new TreeNode(18)));
    }

    public static TreeNode buildFromBFS(Integer[] bfs){
       if(bfs == null)
           return null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(bfs[0]);
        queue.add(root);
        int index = 0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.pop();
            for(int i =0;i<2;i++) {
                index++;
                if (index < bfs.length) {
                    TreeNode leftOrRight = new TreeNode();
                    if (bfs[index] != null) {
                        leftOrRight.val = bfs[index];
                        if(i == 0){
                            cur.left = leftOrRight;
                        }else{
                            cur.right = leftOrRight;
                        }
                    } else {
                        leftOrRight.val = -1;
                    }
                    queue.add(leftOrRight);
                }
            }

        }

       return root;
    }
}
