package com.kun.gen.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Permute_46 {
    public static void main(String[] args) {
        Permute_46 permute46 = new Permute_46();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = permute46.permute(nums);
        for(List<Integer> path: result){
            System.out.println(Arrays.deepToString(path.toArray()));
        }

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        for (int i = 0;i<nums.length;i++){
            used[i] = false;
        }

        Stack<Integer> path = new Stack<>();

        backtrack(nums,used,path,result);
        return result;
    }

    public void backtrack(int[] nums, boolean[] used, Stack<Integer> path, List<List<Integer>> result){
        for(int i =0; i<nums.length;i++){
            if(!used[i]){
                //
                path.push(nums[i]);
                used[i] = true;

                if(path.size() == nums.length){
                    result.add(new ArrayList<>(path));
                }else{
                    backtrack(nums,used,path,result);
                }

                //
                path.pop();
                used[i] = false;
            }
        }

    }

}
