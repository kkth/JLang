package com.kun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SubSets_78 {

    public static void main(String[] args) {

        SubSets_78 subSets78 = new SubSets_78();
        List<List<Integer>> ret = subSets78.subsets(new int[]{1,2,3});
        System.out.println(Arrays.toString(ret.toArray()));

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        if (nums == null||nums.length == 0){
            return ret;
        }

        ret.add(new ArrayList<>());

        Stack<Integer> path = new Stack<>();
        stepInto(nums,0,ret,path);

        return ret;
    }

    public void stepInto(int[] nums,int curIndex, List<List<Integer>> ret, Stack<Integer> path){

        for(int i= curIndex;i<nums.length;i++){
            path.add(nums[i]);
            //Add to return for each node and leaf node
            Object[] arr = path.toArray();
            List<Integer> subSet = new ArrayList<>();
            for(Object o: arr){
               subSet.add((Integer) o);
            }
            ret.add(subSet);

            if(path.size() != nums.length){
                stepInto(nums,i+1,ret,path);
            }

            path.pop();
        }
    }
}
