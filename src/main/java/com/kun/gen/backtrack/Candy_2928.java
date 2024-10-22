package com.kun.gen.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Candy_2928 {
    public static void main(String[] args) {
        Candy_2928 candy2928 = new Candy_2928();
        System.out.println(candy2928.distributeCandies(5,2));

    }

    public int distributeCandies(int n, int limit) {
        int childrenCount = 3;
        List<List<Integer>> solutions = new ArrayList<>();
        Stack<Integer> path = new Stack<>();

        backTrack(childrenCount,0,limit,n,path,solutions);

        return solutions.size();
    }

    public void backTrack(int childrenCount, int curChild, int limit, int remainCandy, Stack<Integer> path, List<List<Integer>> solutions){
       for(int i = 0;i<=limit;i++){
           remainCandy -= i;
           path.push(i);
           if(remainCandy >= 0) {
               if (path.size() == childrenCount) {
                   if(remainCandy == 0) {
                       List<Integer> curSolution = new ArrayList<>(path);
                       System.out.println(Arrays.toString(curSolution.toArray()));
                       solutions.add(curSolution);
                   }
               } else {
                   backTrack(childrenCount, curChild + 1, limit, remainCandy, path, solutions);
               }
           }
           path.pop();
           remainCandy += i;
       }
    }


}
