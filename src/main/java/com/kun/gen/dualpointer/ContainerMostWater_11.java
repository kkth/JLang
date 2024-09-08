package com.kun.gen.dualpointer;

public class ContainerMostWater_11 {
    public static void main(String[] args) {
        ContainerMostWater_11 containerMostWater11 = new ContainerMostWater_11();

        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(containerMostWater11.maxArea(height));

        int[] height2 = new int[]{1,1};
        System.out.println(containerMostWater11.maxArea(height2));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int maxCapacity = 0;
        while(left < right){
           int curHeight = Math.min(height[left],height[right]) ;
           int curCapacity = curHeight*(right-left);
           if(curCapacity > maxCapacity){
               maxCapacity = curCapacity;
           }
           if(height[left]< height[right]){
              left++;
           }else{
              right--;
           }
        }

        return  maxCapacity;
    }
}
