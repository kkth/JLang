package com.kun;

import java.util.*;

public class PermuteByBackTrack {
    public static void main(String[] args) {
        PermuteByBackTrack permuteByBackTrack = new PermuteByBackTrack();
        List<List<Integer>> ret = permuteByBackTrack.permute(new int[]{1,2,3,4});
        int i =0;
        for(List<Integer> l :ret){
            i++;
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println("Total premute number: " + i);
    }

    public List<List<Integer>> permute(int[] nums){
        /*
            Track who is used, you cannot use a index range in original num
            to mark the used one because the could be distributed in nums in
            any order and with holes.
         */
        boolean[] used = new boolean[nums.length];
        /*
            This is necessary to record current path. It will be filled in the
            course of step down and we can determine whether we reached the leaf
            by evaluate the length of this path.
         */
        Stack<Integer> path = new Stack<>();

        //Init the used indicator array
        for(int i=0;i<nums.length;i++){
            used[i] = false;
        }

        List<List<Integer>> permuteList = new ArrayList<>();
        //Used to record the path
        dfs(nums,used,permuteList,path);
        return permuteList;
    }

    void dfs(int[] nums, boolean[] used, List<List<Integer>> permuteList,Stack<Integer> path){
        for(int i=0;i<nums.length;i++){
            //Not used, go!
            if(!used[i]){
                path.push(nums[i]);
                used[i] = true;
                //All elements in path, we can generate the permute now
                if(path.size() == nums.length){
                    List<Integer> curPath = new ArrayList<>(path);
                    permuteList.add(curPath);
                }else{
                    dfs(nums,used,permuteList,path);
                }
                //backtrack
                path.pop();
                used[i] = false;
            }
        }

    }
}
