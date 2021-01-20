package com.dolphin422.business.common.leetcode;

import java.util.Stack;

/**
 * @Description:
 * @author: DamonJT MAC
 * @createDate: 2020/12/26 17:02
 */
public class TestAbc {

    public static void main(String[] args) {
        String testStr = "({}{}[])";
        boolean ok = isValid(testStr);
        System.out.println("Hello World!  " + ok);
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
