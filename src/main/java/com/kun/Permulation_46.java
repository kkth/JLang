package com.kun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Permulation_46 {

    public static void main(String[] args) {
        Permulation_46 permulation46 = new Permulation_46();
        List<List<Integer>> res = permulation46.permute(new int[]{1,2,3});
        res.stream().map(l -> Arrays.toString(l.toArray())).forEach(System.out::println);

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;

        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[nums.length];
        for(int i =0;i<nums.length;i++){
            used[i] = false;
        }
        stepInto(res,path,nums,used);
        return res;
    }

    public void stepInto(List<List<Integer>> res,Stack<Integer> path, int[] nums, boolean[] used){
        //Just debug
        System.out.println("--->\nStep into new node, now path is " + getStackString(path) + " and used index = " + Arrays.toString(used));
        //Just debug

        //This is the key to avoid duplicate
        for(int i=0;i<nums.length;i++){
            //Debug
            StringBuffer sb = new StringBuffer();
            sb.append("Try num i, index = "+ i + " and value = " + nums[i]);

            if(!used[i]) {
                //Debug
                sb.append(" which is not used sofar");
                System.out.println(sb.toString());
                path.add(nums[i]);
                used[i] = true;
                System.out.println("Setup a new node, path is " + getStackString(path) + " and used index = " + Arrays.toString(used));
                if (path.size() == nums.length) {
                    //Reach leaf node, get current path as a permutation
                    Object[] curPath = path.toArray();
                    List<Integer> curPerm = new ArrayList<>();
                    for (Object o : curPath) {
                        curPerm.add((Integer) o);
                    }
                    //Add to result collection
                    res.add(curPerm);
                    System.out.println("Get a new permutation: " + Arrays.toString(curPerm.toArray()));
                } else {//Go deeper
                    stepInto(res, path, nums, used);
                }
                path.pop();
                used[i] = false;
                System.out.println("<---\nWould like to step out current node, after pop: path is " + getStackString(path) + "and used index = " + Arrays.toString(used));

            }else {
                sb.append(" which is already used, just skip it.");
                System.out.println(sb.toString());
            }
        }
    }
    public static String getStackString(Stack<Integer> s){
        return s.toString();
    }

}
