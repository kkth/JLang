package com.kun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleSquare_1954 {
    public static void main(String[] args) {
        AppleSquare_1954 appleSquare1954 = new AppleSquare_1954();
        System.out.println(appleSquare1954.minimumPerimeter(1));
        System.out.println(appleSquare1954.minimumPerimeter(13));
        System.out.println(appleSquare1954.minimumPerimeter(1000000000));

    }

    public long minimumPerimeter(long neededApples) {
        List<Long> dp = new ArrayList<>();
        dp.add(0L);
        long curApples = dp.get(0);

        while(curApples <= neededApples){
            if(curApples == neededApples)
                break;
            //First layer is 0, second is 1, third is 2
           int prevLayer = dp.size()-1;
           long appleInPrevSquare = dp.get(prevLayer);

           int curLayer = prevLayer + 1;

           long curAppleInSingleSide = 0;
           /*
           for(int i = 0;i<=curLayer;i++){
               curAppleInSingleSide += curLayer;
               curAppleInSingleSide += i;
           }
           for(int i = 1;i<curLayer;i++){
                curAppleInSingleSide += curLayer;
                curAppleInSingleSide += i;
           }
            */
            curAppleInSingleSide = 3L *curLayer*curLayer;

           long appleInCurLayer = curAppleInSingleSide *4;
           long appleInCurSquare = appleInCurLayer + appleInPrevSquare;

           dp.add(appleInCurSquare);
           curApples = appleInCurSquare;
 //          System.out.println(Arrays.toString(dp.toArray()));
        }

       return (dp.size()-1)*8L;
    }
}
