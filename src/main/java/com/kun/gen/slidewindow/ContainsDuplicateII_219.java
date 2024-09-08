package com.kun.gen.slidewindow;

import com.kun.gen.dualpointer.ContainerMostWater_11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII_219 {

    public static void main(String[] args) {
        ContainsDuplicateII_219 containsDuplicateII219 = new ContainsDuplicateII_219();
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        System.out.println(containsDuplicateII219.containsNearbyDuplicate(nums,k));

        nums = new int[]{1,0,1,1};
        k = 1;
        System.out.println(containsDuplicateII219.containsNearbyDuplicate(nums,k));

        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        System.out.println(containsDuplicateII219.containsNearbyDuplicate(nums,k));

    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean contains = false;
        Set<Integer> curNums = new HashSet<>();
        Deque<Integer> theWindow = new ArrayDeque<>();

        for(int i = 0;i<nums.length;i++){
            //Full window, remove head at first
           if(theWindow.size() == k+1) {
               Integer head = theWindow.removeFirst();
               curNums.remove(head);
           }

           //Check
           if(curNums.contains(nums[i])){
               contains = true;
               break;
           } else{
               theWindow.addLast(nums[i]);
               curNums.add(nums[i]);
           }
        }

        return contains;

    }
}
