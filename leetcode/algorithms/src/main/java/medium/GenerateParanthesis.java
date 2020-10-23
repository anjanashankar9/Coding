package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-23
 */
public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        /*
        ()()()
        (())()
        ((()))
        ()(())
        (())()

        ()

        ()()
        (())

        ()()()
        (())()
        ()(())
        ((()))
        (()())

        ()()()()
        (())()()
        ()(())()
        ((()))()
        (()())()

        (()()())
        ((())())
        (()(()))
        (((())))
        ((()()))



         */

        // Can be done using recursion.
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 0,0,new StringBuilder(), result);

        return result;
    }

    private void generateParenthesis(int n, int openCount, int closeCount, StringBuilder sb, List<String> result) {
        if(2*n == openCount + closeCount) {
            result.add(sb.toString());
            return;
        }
        if(openCount < n) {
            sb.append("(");
            generateParenthesis(n, openCount+1, closeCount, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }

        if(openCount > closeCount) {
            sb.append(")");
            generateParenthesis(n, openCount, closeCount+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = new GenerateParanthesis().generateParenthesis(n);
        for(String s : result) {
            System.out.println(s);
        }
    }
}

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 */

//https://leetcode.com/problems/generate-parentheses/