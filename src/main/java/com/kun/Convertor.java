package com.kun;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Convertor {
    public static void main(String[] args) throws IOException {
        while(true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            System.out.println(toPrettyFormat(convert(input)));
        }
    }
    static String convert(String s){
        String t1 = s.replace(' ',',');
        String t2 = t1.replace(",{","{");
        String input = t2.replace("}{","},{");
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<input.length();i++){
            if(nexNullString(input,i)){
                sb.append(input.charAt(i));
                sb.append("\"\"");
            }else if(nextIsStartOfWord(input, i)){
                sb.append(input.charAt(i));
                sb.append("\"");
            }else if(nextIsEndOfWord(input,i)){
                sb.append(input.charAt(i));
                sb.append("\"");
            }else {
                sb.append(input.charAt(i));
            }
        }

        return sb.toString();
    }

    static boolean nextIsStartOfWord(String s, int pos){
        boolean ret = false;
        //Get current character
        char c = s.charAt(pos);
        if(c == '{'){
            ret = true;
        }else if(c ==':'){
            if(s.charAt(pos+1) !='[' && s.charAt(pos+1) !='{'){
                ret = true;
            }
        }else if(c == '['){
            if(s.charAt(pos+1) !='{') {
                ret = true;
            }
        }else if(c ==','){
            if(s.charAt(pos+1) !='{') {
                ret = true;
            }
        }
        return ret;
    }
    static boolean nexNullString(String s, int pos){
       if(s.charAt(pos)==':' && s.charAt(pos+1)==',')
           return true;
       else
           return false;
    }
    static boolean nextIsEndOfWord(String s, int pos){
        boolean ret = false;
        //The last one, return false directly.
        if(pos == s.length()-1)
            return ret;
            //Get next character rather than current
        char c = s.charAt(pos+1);
        if(c == ':'){
            ret = true;
        }else if(c == ']'){
            if (s.charAt(pos) != '}'){
                ret = true;
            }
        }else if(c == '}'){
            if (s.charAt(pos) != ']' && s.charAt(pos) !='}'){
                ret = true;
            }
        }else if(c == ',') {
            if (s.charAt(pos) != '}'){
                ret = true;
            }
        }
        return ret;
    }

    private static String toPrettyFormat(String json) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonObject);
    }
}
