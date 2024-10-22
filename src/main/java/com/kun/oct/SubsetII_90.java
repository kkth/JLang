package com.kun.oct;

import java.util.*;

public class SubsetII_90 {
    public static void main(String[] args) {
        SubsetII_90 subsetII90 = new SubsetII_90();

        int[] nums = new int[]{1,2,2};
        List<List<Integer>> results = subsetII90.subsetsWithDup(nums);
        for(List<Integer> result: results){
           System.out.println(Arrays.toString(result.toArray()));
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<Integer>());//The empty set

        Stack<Integer> path = new Stack<>();
        Set<Integer> used = new HashSet<>();
        int curIndex = 0;
        trackBack(nums,curIndex,used,results,path);

        return results;
    }

    public void trackBack(int[] nums, int curIndex, Set<Integer> used, List<List<Integer>> results, Stack<Integer> path){
       for(int i = curIndex;i<nums.length;i++){
         // if(!used.contains(nums[i])){
              path.push(nums[i]);
              //used.add(nums[i]);

              List<Integer> result = new ArrayList<>(path);
              Collections.sort(result);
              if(!contains(results,result)) {
                  results.add(result);
              }
              if(path.size() != nums.length){
                 trackBack(nums,i+1,used,results,path);
              }
              path.pop();
              //used.remove(nums[i]);
           // }
       }
    }

    public static boolean contains(List<List<Integer>> source, List<Integer> target){
        return source.contains(target);
    }
}
