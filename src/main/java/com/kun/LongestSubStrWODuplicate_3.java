package com.kun;

import java.util.*;

public class LongestSubStrWODuplicate_3 {
    public static void main(String[] args) {

        LongestSubStrWODuplicate_3 longestSubStrWODuplicate3 = new LongestSubStrWODuplicate_3();
        longestSubStrWODuplicate3.lengthOfLongestSubstring("12345");
        longestSubStrWODuplicate3.lengthOfLongestSubstring("abcabcbb");
        longestSubStrWODuplicate3.lengthOfLongestSubstring("bbbbb");
        longestSubStrWODuplicate3.lengthOfLongestSubstring("pwwkew");
    }

    int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        int maxLen = -1, _lAtMax = -1, _rAtMax = -1;
        Map<Integer,List<List<Integer>>> _records = new HashMap<>();


        int l = 0;
        Set<String> setsInWindow = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            String cur = s.substring(i,i+1);
            //Found duplicated character in current window!
            if(setsInWindow.contains(cur)){
               while(true) {
                   //The left character of duplicated pair is next to the new boundary
                   //So we must remove any character before the duplicated one as well
                   String toBeRemoved = s.substring(l, l + 1);
                   setsInWindow.remove(toBeRemoved);
                   l++;
                  //The duplicated one is removed, stop here
                   if(toBeRemoved.equals(cur))
                       break;
               }
               setsInWindow.add(cur);
            }else{//Just put and move window forward
               setsInWindow.add(cur);
            }

            //Keep all the same length when >= is used here
            if(i-l+1 >= maxLen){
                maxLen = i-l+1;
                _lAtMax = l;
                _rAtMax = i;

                List<Integer> _curWindow = new ArrayList<>();
                _curWindow.add(_lAtMax);
                _curWindow.add(_rAtMax);

                List<List<Integer>> _windowList = _records.get(maxLen);
                if(_windowList == null){
                    _windowList = new ArrayList<>();
                    _windowList.add(_curWindow);
                    _records.put(maxLen,_windowList);
                }else{
                    _windowList.add(_curWindow);
                }
            }
        }

        List<List<Integer>> _values = _records.get(maxLen);
        System.out.println("max len = " + maxLen + ", the index =" + Arrays.toString(_values.toArray()));
        return maxLen;
    }
}
