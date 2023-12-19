package com.kun;

import java.util.*;

public class TopK {

    public static void main(String[] args) {
        TopK topK = new TopK();
        List l = topK.getTopK(new int[]{10,20,15,33,33,51,63,9,18},3);

        System.out.println(Arrays.toString(l.toArray()));
    }

    List<Integer> getTopK(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });


        for(int i =0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        for(int i = 0; i<k-1 ;i++){
           int v=  pq.remove();
        }

        int val = pq.remove();
        List<Integer> integers = new ArrayList<>();
        integers.add(val);

        while(!pq.isEmpty()){
            int moreVal = pq.remove();
            if(moreVal == val)
                integers.add(moreVal);
        }

        return integers;
    }
}
