package com.kun.gen.slidewindow;

import java.util.*;

public class FruitsInBuckets_904 {
    public static void main(String[] args) {
        FruitsInBuckets_904 fruitsInBuckets904 = new FruitsInBuckets_904();
        int[] fruits = new int[]{1,2,3,2,2};
        System.out.println(fruitsInBuckets904.totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {

        //Key: type, value: Number of fruits for this type
        Map<Integer,Integer> typeMapNumber = new HashMap<>();
        Deque<Integer> window = new ArrayDeque<>();

        int maxNumber = 0;
        for(int tree: fruits){
            //Already have this type of fruit
            if(typeMapNumber.containsKey(tree)){
                typeMapNumber.put(tree,typeMapNumber.get(tree)+1);
                window.addLast(tree);
            }else{
                if(typeMapNumber.keySet().size() == 2) {
                    if (window.size() >maxNumber){
                        maxNumber = window.size();
                    }
                    while(true) {
                        Integer prevType = window.removeFirst();
                        int remain = typeMapNumber.get( prevType) - 1;
                        if(remain == 0){
                            typeMapNumber.remove(prevType);
                            break;
                        }else{
                            typeMapNumber.put(prevType,remain);
                        }
                    }
                }
                //Add new
                typeMapNumber.put(tree,1);
                window.addLast(tree);
            }

        }

        if(window.size() >maxNumber){
            maxNumber = window.size();
        }

        return maxNumber;
    }
}
