package com.kun.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口
 */
public class GrumpyBookstoreOwner_1052 {
    public static void main(String[] args) {
        int[] customers = new int[] {1,0,1,2,1,1,7,5};
        int[] grumpy = new int[] {0,1,0,1,0,1,0,1};
        int minutes = 3;

        GrumpyBookstoreOwner_1052 grumpyBookstoreOwner1052= new GrumpyBookstoreOwner_1052();
        System.out.println(grumpyBookstoreOwner1052.maxSatisfied(customers,grumpy,minutes));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        Deque<Integer> slideWindow = new ArrayDeque<>();
        int maxSum = 0;
        int start = 0;
        int end = 0;

        int i = 0;
        int curSum = 0;
        for (i = 0;i<minutes && i<customers.length;i++){
           maxSum += customers[i];
           curSum += customers[i];
           slideWindow.add(customers[i]);
           end++;
        }

        for(;i<customers.length;i++){
            int removed = slideWindow.getFirst();
            int added = customers[i];
            slideWindow.add(added);
            curSum += added;
            curSum -= removed;
            if(curSum > maxSum){
                maxSum = curSum;
                start = i-minutes+1;
                end = i;
            }
        }

        int result = 0;
        for(int j = 0;j<customers.length;j++){
            if(j>=start && j<=end){
               result += customers[j];
            }else{
                if(grumpy[j] == 0){
                    result += customers[j];
                }
            }
        }

        return result;
    }
}
