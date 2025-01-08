package com.kun.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxPoint_1423 {
    public static void main(String[] args) {
        int[] cardPoints = new int[]{1,2,3,4,5,6,1};
        int k = 3;
        MaxPoint_1423 maxPoint1423 = new MaxPoint_1423();
        System.out.println(maxPoint1423.maxScore(cardPoints,k));

        cardPoints = new int[]{2,2,2};
        k = 2;
        System.out.println(maxPoint1423.maxScore(cardPoints,k));
    }
    public int maxScore(int[] cardPoints, int k) {
        int start = 0;
        int end = cardPoints.length-1;
        List<List<Integer>> solutions = new ArrayList<>();

        Stack<Integer> path = new Stack<>();
        backtrack(start, end, cardPoints,k,path,0, solutions);

        int maxVal = 0;
        for(List<Integer> solution: solutions){
            int curSum = 0;
            for(Integer val: solution){
                curSum += val;
            }
            if(curSum > maxVal){
                maxVal = curSum;
            }
        }
        return  maxVal;
    }

    public void backtrack(int start, int end, int[] cardPoints, int k, Stack<Integer> path, int sumSofar, List<List<Integer>> solutions){
        if(start > end){
            return;
        }
       for(int i = 0;i<2;i++){
           int curValue = 0;
           if(i == 0){
               curValue = cardPoints[start];
               start++;
           }else{
               curValue = cardPoints[end];
               end--;
           }

           int curSum = sumSofar + curValue;
           path.push(curValue);

           if(path.size() == k){
               solutions.add(new ArrayList<>(path));
           }else{
              backtrack(start,end,cardPoints,k,path,curSum,solutions);
           }

           path.pop();
       }
    }
}
