package com.kun;

import java.util.Arrays;

/*
    parent index = (cur-1)/2
    left child = cur*2 +1
    right child = cur*2+2
 */
public class Heap {
    public static void main(String[] args){
        Heap heap= new Heap(true);
        heap.add(100).add(1).add(6).add(10).add(5).add(4).add(200);
        heap.printHeap();
        System.out.println(heap.poll());
        heap.printHeap();
        System.out.println(heap.poll());
        heap.printHeap();
        System.out.println(heap.poll());
        heap.printHeap();

        heap.clear();


    }


    int[] nums = null;
    boolean minHeap = true;
    public Heap(boolean minHeap){
       this.minHeap = minHeap;
    }
    Heap add(int val){
       if(nums == null){
           nums = new int[1];
           nums[0] = val;
       }else{
           int[] tmp = new int[nums.length+1];
           for(int i = 0;i<nums.length;i++){
               tmp[i] = nums[i];
           }
           tmp[tmp.length-1] = val;
           nums = tmp;
       }

       moveUp(nums.length-1);
       //printHeap();
       return this;
    }

    int poll(){
        if(nums == null){
            System.out.println("empty heap!");
            return -1;
        }

        int ret = nums[0];

        int[] tmp = new int[nums.length-1];
        for(int i = 1;i<nums.length;i++){
            tmp[i-1] = nums[i];
        }
        nums = tmp;
        for(int i =nums.length-1;i>0;i--) {
            moveUp(i);
        }

        return ret;
    }


    void moveUp(int cur){
        int parentIndex = (cur-1)/2;
        while(parentIndex >=0){
            if(minHeap){//if cur element is less than parent, move it up
               if(nums[cur] < nums[parentIndex]){
                    int tmp = nums[parentIndex];
                    nums[parentIndex] = nums[cur];
                    nums[cur] = tmp;
                    cur = parentIndex;
               }else{
                   break;
               }
            }else{ //if cur element is greater than parent, move it up
                if(nums[cur] > nums[parentIndex]){
                    int tmp = nums[parentIndex];
                    nums[parentIndex] = nums[cur];
                    nums[cur] = tmp;
                    cur = parentIndex;
                }else{
                    break;
                }
            }
            parentIndex = (cur-1)/2;
        }
    }

    void printHeap(){
        if(nums == null){
            System.out.println("empty heap!");
            return ;
        }
        System.out.println(Arrays.toString(nums));
    }

    void clear(){
        nums = null;
    }

}
