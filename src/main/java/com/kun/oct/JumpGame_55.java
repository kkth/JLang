package com.kun.oct;

import java.util.*;

public class JumpGame_55 {
    public static void main(String[] args) {
        JumpGame_55 jumpGame55 = new JumpGame_55();

        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jumpGame55.canJump(nums));

        nums = new int[]{3,2,1,0,4};
        System.out.println(jumpGame55.canJump(nums));

        nums = new int[]{1,1,1,3,4,0,0,1};
        System.out.println(jumpGame55.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        boolean canJump = false;

        //The index(position) must reach
        int targetPos = nums.length-1;
        List<List<Integer>> solutions = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        int curIndex = 0;

        path.push(0);
        backtrack(targetPos,nums,curIndex,path,solutions);
        canJump = !solutions.isEmpty();

        for(List<Integer> solution:solutions){
            System.out.println(Arrays.toString(solution.toArray()));
        }

        return canJump;
    }

    void backtrack(int targetPos, int[] nums, int curIndex, Stack<Integer> path, List<List<Integer>> solution){
        for(int i = 1;i<=nums[curIndex];i++){
            path.push(curIndex+i);
            if(curIndex+i>=targetPos){//
                List<Integer> curPath = new ArrayList<>(path);
                solution.add(curPath);
            }else{
                backtrack(targetPos,nums,curIndex+i,path, solution);
            }
            path.pop();
        }
    }
}
