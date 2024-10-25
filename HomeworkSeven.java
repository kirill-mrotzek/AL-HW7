package com.telran.prof.org.algoritms;

import java.util.HashMap;
import java.util.Stack;

//Последовательность ([{}]) является правильной,
//а последовательности ([)], {()] правильными не являются. Докажите это, используя, стек!

public class HomeworkSeven {

    public static void main(String[] args) {
        String str1 = "([{}])";
        String str2 = "([)]";
        String str3 = "{()]";

        System.out.println(str1 + " " + validate(str1));
        System.out.println(str2 + " " + validate(str2));
        System.out.println(str3 + " " + validate(str3));
    }

    public static boolean validate(String str) {

        HashMap<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (bracketPairs.containsValue(c)) {
                stack.push(c);
            }
            else if (bracketPairs.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (top != bracketPairs.get(c)) {
                    return false;
                }
            }
        }
        return false;
    }
}
