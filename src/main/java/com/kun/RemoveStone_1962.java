package com.kun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStone_1962 {
    public static void main(String[] args) {
        RemoveStone_1962 removeStone1962 = new RemoveStone_1962();
        System.out.println(removeStone1962.minStoneSum(new int[]{5,4,9},2));
        System.out.println(removeStone1962.minStoneSum(new int[]{4,3,6,7},3));

    }

    public int minStoneSum(int[] piles, int k) {
        if(piles == null || k < 1)
            return -1;

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(Integer i: piles){
            queue.add(i);
        }

        for(int i =0;i<k;i++){
            Integer cur = queue.remove();
            queue.add(cur - cur/2);
        }

        System.out.println(Arrays.toString(queue.toArray()));
        int ret = 0;
        while(!queue.isEmpty()){
            ret += queue.remove();
        }

        return ret;
    }
}
