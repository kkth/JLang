package com.kun;

public class NumberOfOneBits_191 {
    public static void main(String[] args){
        NumberOfOneBits_191 numberOfOneBits191 = new NumberOfOneBits_191();
        System.out.println(numberOfOneBits191.hammingWeight(-3));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret  = 0;
        for(int i =0;i<Integer.SIZE;i++){
           if((n & (1<<i)) !=0) {
               ret++;
           }
        }
        return ret;
    }

}
