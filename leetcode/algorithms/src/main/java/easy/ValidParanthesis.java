package easy;

import java.util.Stack;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-15
 */
public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character c: s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }
            if(c == ']' || c == '}' || c == ')') {
                switch(c) {
                    case ']':
                        if(stack.isEmpty())
                            return false;
                        if (stack.pop() != '[')
                            return false;
                        break;

                    case '}':
                        if(stack.isEmpty())
                            return false;
                        if (stack.pop() != '{')
                            return false;
                        break;

                    case ')':
                        if(stack.isEmpty())
                            return false;
                        if (stack.pop() != '(')
                            return false;
                        break;
                }
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;

    }

    public static void main(String[] args) {

        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        System.out.println(new ValidParanthesis().isValid(s1));
        System.out.println(new ValidParanthesis().isValid(s2));
        System.out.println(new ValidParanthesis().isValid(s3));
        System.out.println(new ValidParanthesis().isValid(s4));
        System.out.println(new ValidParanthesis().isValid(s5));
    }

}

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

 */
//https://leetcode.com/problems/valid-parentheses/