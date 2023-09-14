package com.kun;

import java.util.ArrayList;
import java.util.List;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        boolean found = false;
        int min = 0;
        List<List<Integer>> dp = new ArrayList<>();
        //Init it
        List<Integer> dproot = new ArrayList<>();
        dproot.add(triangle.get(0).get(0));
        dp.add(dproot);

        int level = triangle.size();

        for (int i = 1;i<level;i++) {
            int elementsInCurLevel = i+1;
            List<Integer> curDP = new ArrayList<>();
            for (int j = 0;j<elementsInCurLevel;j++){


                int curMin = 0;
                if(j==0){//Left most
                    curMin = triangle.get(i).get(j) + dp.get(i-1).get(j);
                }else if(j == dp.get(i-1).size()) {//Right most
                   curMin = triangle.get(i).get(j) + dp.get(i-1).get(j-1);
                }else {
                   curMin = Math.min(triangle.get(i).get(j) + dp.get(i-1).get(j),
                            triangle.get(i).get(j) + dp.get(i-1).get(j-1));
                }

               curDP.add(curMin);

                if(i==level-1){
                    if(!found || curMin <min){
                        min = curMin;
                        found = true;
                    }
                }
            }
            dp.add(curDP);
        }

        return min;
    }


    class DPWithPath{
        int sum;
        int val;
        int parentVal;
    }
    public static void main(String[] args){

        //triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]

        List<List<Integer>> triangle= new ArrayList<>();

        List<Integer> level1 = new ArrayList<>();
        level1.add(2);
        triangle.add(level1);

        List<Integer> level2 = new ArrayList<>();
        level2.add(3);
        level2.add(4);
        triangle.add(level2);

        List<Integer> level3 = new ArrayList<>();
        level3.add(6);
        level3.add(5);
        level3.add(7);
        triangle.add(level3);

        List<Integer> level4 = new ArrayList<>();
        level4.add(4);
        level4.add(1);
        level4.add(8);
        level4.add(3);
        triangle.add(level4);


        Triangle_120 triangle120 = new Triangle_120();

        System.out.println(triangle120.minimumTotal(triangle));

    }


}
