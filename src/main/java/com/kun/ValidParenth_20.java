package com.kun;

import java.util.Stack;

public class ValidParenth_20 {

    public static void main(String[] args) {
        ValidParenth_20 validParenth20 = new ValidParenth_20();
        System.out.println(validParenth20.isValid("()"));
        System.out.println(validParenth20.isValid("()[]{}"));
        System.out.println(validParenth20.isValid("(]"));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();

        Stack<String> stack = new Stack<>();
        for (char c: chars){
            if(stack.isEmpty()) {
                stack.push(Character.toString(c));
            }else{
                String sTop = stack.peek();
                if(sTop.equals("{") && c=='}' || sTop.equals("(") && c ==')' || sTop.equals("[") && c==']'){
                    stack.pop();
                }else{
                    stack.push(Character.toString(c));
                }
            }
        }

        return stack.isEmpty();
    }
}
