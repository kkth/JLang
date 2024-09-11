package com.kun.gen.btree;

import com.kun.gen.utils.BTreeUtils;
import com.kun.gen.utils.BinaryTreePrinter;
import com.kun.gen.utils.TreeNode;

import java.util.*;

public class LevelOrderTraverse_102 {
    public static void main(String[] args) {
        Integer[] theArray = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = BTreeUtils.genTree(theArray);
        BinaryTreePrinter.printTree(root);

        LevelOrderTraverse_102 levelOrderTraverse102 = new LevelOrderTraverse_102();
        List<List<Integer>> result = levelOrderTraverse102.levelOrder(root);
        System.out.println(Arrays.deepToString(result.toArray()));

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
           int curLevelLen = queue.size();
           List<Integer> currenLevelList = new ArrayList<>();

           for(int i = 0;i<curLevelLen;i++){
              TreeNode cur = queue.pop();
              currenLevelList.add(cur.val);
              if(cur.left != null){
                  queue.add(cur.left);
              }
              if(cur.right != null){
                  queue.add(cur.right);
              }
           }

           result.add(currenLevelList);
        }

        return result;
    }
}
