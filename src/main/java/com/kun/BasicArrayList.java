package com.kun;

//Reference: https://zhuanlan.zhihu.com/p/628209040


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BasicArrayList {
    public static void main(String[] args) {
        BasicArrayList.fromArrayToList();
        BasicArrayList.fromListToArray();
        BasicArrayList.iterator();
        BasicArrayList.copyList();
    }
    static void fromArrayToList(){
        //Utilize Arrays.asList
        //public static <T> List<T> asList(T... a) {...}

        List<Integer> list_1 = Arrays.asList(new Integer[]{1,2,3});
        System.out.println(list_1);

        List<Integer> list_2 = new ArrayList<>(Arrays.asList(new Integer[]{3,4,5}));
        System.out.println(list_2);

    }

    static void fromListToArray(){

        List<Integer> list = Arrays.asList(new Integer[]{5,6,7});
        Integer[] theList = (Integer[]) list.toArray();
        System.out.println(Arrays.toString(theList));

        Integer[] theList_2 = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(theList_2));

    }

    static void iterator(){
        List<Integer> list = Arrays.asList(new Integer[]{9,10,11});
        for(Integer i:list){
            System.out.println(i);
        }

        Iterator<Integer> ite = list.iterator();
        while(ite.hasNext()){
            Integer val = ite.next();
            System.out.println(val);
        }
    }

    static void copyList(){
       List<Integer> list = Arrays.asList(new Integer[]{11,12,13});
       List<Integer> newList = new ArrayList<>(list);
       System.out.println(Arrays.toString(newList.toArray()));
    }
}
