package com.kun;

import java.util.*;

public class MountainArray_1671 {
    public static void main(String[] args) {
       MountainArray_1671 mountainArray1671 = new MountainArray_1671();
       int [] nums = new int[]{2,1,1,5,6,2,3,1};
       System.out.println(mountainArray1671.minimumMountainRemovals(nums));

    }

    public int minimumMountainRemovals(int[] nums) {
        int ret = -1;
        Map<Integer,Node> nodes = new HashMap<>();
        getIncSubSequence(nodes, nums);
        getDecSubSequence(nodes, nums);

        int _maxIndex = -1;
        for(Node node: nodes.values()){
            if(node.maxDecLength > 1 && node.maxIncLength >1) {
                int totalLen = node.maxIncLength + node.maxDecLength - 1;
                int subCount = nums.length - totalLen;
                if (ret == -1 || subCount < ret) {
                    ret = subCount;
                    _maxIndex = node.index;
                }
            }
        }

       Set<Integer> _mountainElem = new HashSet<>();
       _mountainElem.addAll(nodes.get(_maxIndex)._maxIncSequence);
       _mountainElem.addAll(nodes.get(_maxIndex)._maxDecSequence);
       Arrays.sort(_mountainElem.toArray());

       List<Integer> _mountain = new ArrayList<>();
       for(Integer i: _mountainElem){
          _mountain.add(nums[i]);
       }
       System.out.println(Arrays.toString(_mountain.toArray()));

        return ret;
    }

    class Node{
        int index = -1;
        int maxIncLength = 1;
        List<Integer> _maxIncSequence = new ArrayList<>();
        int maxDecLength = 1;
        List<Integer> _maxDecSequence = new ArrayList<>();

        Node(int index){
            this.index = index;
            _maxDecSequence.add(index);
            _maxIncSequence.add(index);
        }

    }
    void getIncSubSequence(Map<Integer,Node> nodes, int[] nums){
        for(int i = 0;i<nums.length;i++){
            Node curNode = new Node(i);
            for(int j = i-1;j>=0;j--){
               if(nums[i] > nums[j] ) { //Potential increase sequence
                   Node prev = nodes.get(j);
                   if(prev.maxIncLength +1 > curNode.maxIncLength){
                       curNode.maxIncLength = prev.maxIncLength+1;
                       curNode._maxIncSequence.clear();
                       curNode._maxIncSequence.addAll(prev._maxIncSequence);
                       curNode._maxIncSequence.add(i);
                   }
               }
            }

            nodes.put(i,curNode);
        }
    }
    void getDecSubSequence(Map<Integer,Node> nodes, int[] nums){
        for(int i = nums.length-1;i>=0;i--){
            Node curNode = nodes.get(i);
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] > nums[j] ) { //Potential increase sequence
                    Node prev = nodes.get(j);
                    if(prev.maxDecLength +1 > curNode.maxDecLength){
                        curNode.maxDecLength = prev.maxDecLength+1;
                        curNode._maxDecSequence.clear();
                        curNode._maxDecSequence.addAll(prev._maxDecSequence);
                        curNode._maxDecSequence.add(i);
                    }
                }
            }


        }
    }
}
