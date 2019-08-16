package javachallenges.strings;

public class StringTokens {

    public static void stringTokens(String[] args) {

        String s =  "                        ";
        if (s.trim().length() == 0) {
            System.out.println(0);
            return;
        }
        if (s.length() > 400000)
            return;
        String[] tokens = s.trim().split("[\\ !,?.\\\\_'@]+");
        System.out.println("**" + s.trim());
        System.out.println(tokens.length);

        for (String i : tokens){
            System.out.println(i);
        }
        System.out.println(tokens.length);
    }
}

/*
Given a strings, , matching the regular expression [A-Za-z !,?._'@]+, split the strings into tokens. We define a token to be one or more consecutive English alphabetic letters. Then, print the number of tokens, followed by each token on a new line.

Note: You may find the String.split method helpful in completing this challenge.

Input Format

A single strings, .

Constraints

 is composed of any of the following: English alphabetic letters, blank spaces, exclamation points (!), commas (,), question marks (?), periods (.), underscores (_), apostrophes ('), and at symbols (@).
Output Format

On the first line, print an integer, , denoting the number of tokens in strings  (they do not need to be unique). Next, print each of the  tokens on a new line in the same order as they appear in input strings .

Sample Input

He is a very very good boy, isn't he?
Sample Output

10
He
is
a
very
very
good
boy
isn
t
he
Explanation

We consider a token to be a contiguous segment of alphabetic characters. There are a total of  such tokens in strings , and each token is printed in the same order in which it appears in strings .
 */
