package algorithms.strings.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ashankar1 on 4/9/15.
 */
public class GameOfThrones {
    public static void got(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();

        String ans;
        // Assign ans a value of s or no, depending on whether or not inputString satisfies the required condition
        ans = isPalindromeAnagram(inputString);
        System.out.println(ans);
        myScan.close();
    }

    private static String isPalindromeAnagram(String inputString){
        Map<Character,Integer> countChars = new HashMap<Character,Integer>();
        char[] arr = inputString.toCharArray();
        for(char c: arr){
            if(countChars.get(c)==null){
                countChars.put(c, 1);
            }
            else{
                countChars.put(c, countChars.get(c)+1);
            }
        }

        boolean isOdd = false;
        for(Character c : countChars.keySet()){
            if(countChars.get(c) %2 != 0){
                if(isOdd)
                    return "NO";
                isOdd = true;
            }
        }
        return "YES";
    }
}

/*
Dothraki are planning an attack to usurp King Robert's throne.
King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.
door. But, to lock the door he needs a key that is an anagram of a certain palindrome string.

The king has a string composed of lowercase English letters.
Help him figure out whether any anagram of the string can be a palindrome or not.

Input Format
A single line which contains the input string.

Constraints
1≤ length of string ≤105
Each character of the string is a lowercase English letter.

Output Format
A single line which contains YES or NO in uppercase.

Sample Input : 01

aaabbbb
Sample Output : 01

YES
Explanation
A palindrome permutation of the given string is bbaaabb.

Sample Input : 02

cdefghmnopqrstuvw
Sample Output : 02

NO
Explanation
You can verify that the given string has no palindrome permutation.

Sample Input : 03

cdcdcdcdeeeef
Sample Output : 03

YES
Explanation
A palindrome permutation of the given string is ddcceefeeccdd.
 */

//https://www.hackerrank.com/challenges/game-of-thrones