package com.kun.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RecoveryIPAddress_93 {
    public static void main(String[] args) {
        RecoveryIPAddress_93 recoveryIPAddress93 = new RecoveryIPAddress_93();

        String s = "25525511135";
        List<String> results = recoveryIPAddress93.restoreIpAddresses(s);
        System.out.println(Arrays.toString(results.toArray()));

        s = "101023";
        results = recoveryIPAddress93.restoreIpAddresses(s);
        System.out.println(Arrays.toString(results.toArray()));

    }

    public List<String> restoreIpAddresses(String s) {

        List<String> results = new ArrayList<>();

        char[] charArray = s.toCharArray();
        for(char c: charArray){
            if(c<'0'|| c>'9'){
               return  results;
            }
        }

        Stack<Candidate> path = new Stack<>();
        backTrack(s,0,results,path);

        return results;
    }


    class Candidate{
        String ip;
        int start;
        int end;
    }

    public List<Candidate> extract(String source, int start){
        List<Candidate> results = new ArrayList<>();
        if(start >= source.length()){
            return results;
        }

        //0, the 0 is the only possible result
        if(source.substring(start,start+1).equals("0")){
            Candidate candidate = new Candidate();
            candidate.ip = "0";
            candidate.start = start;
            candidate.end = start;
            results.add(candidate);

            return results;
        }
        //at most 3 digits
        for(int i = 0;i<3;i++){
            if(start+i+1 <= source.length()) {
                String s = source.substring(start, start + 1 + i);
                Candidate candidate = new Candidate();
                candidate.ip = s;
                candidate.start = start;
                candidate.end = start + i;

                int ipVal = Integer.parseInt(s);
                if(ipVal >=0 && ipVal<=255) {
                    results.add(candidate);
                }
            }
        }

        return results;
    }
    public void backTrack(String s, int curIndex, List<String> results, Stack<Candidate> path){
        List<Candidate> candidates = extract(s,curIndex);
        for(Candidate candidate: candidates){
            path.push(candidate);
            if( path.size() == 4){//Reach last part
                if(candidate.end == s.length()-1){//Get all digits exactly at the end
                    List<Candidate> curResult = new ArrayList<>(path);
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0;i<4;i++){
                        Candidate candidate1 = curResult.get(i);
                        sb.append(candidate1.ip);
                        if(i != 3){
                            sb.append(".");
                        }
                    }

                    results.add(sb.toString());
                }
            }else{
                backTrack(s, candidate.end+1,results,path);
            }

            path.pop();
        }
    }


}
