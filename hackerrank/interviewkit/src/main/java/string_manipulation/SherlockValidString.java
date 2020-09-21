package string_manipulation;

import java.util.*;

public class SherlockValidString {

    // Complete the isValid function below.
    static String isValid(String s) {

        HashMap<Character, Integer> charCount = new HashMap<>();
        for (Character c : s.toCharArray()) {
            Integer count = 0;
            if (charCount.containsKey(c)) {
                count = (charCount.get(c)+1);
            }
            else {
                count = 1;
            }
            charCount.put(c, count);
        }

        Set<Integer> charCountSet = new HashSet<>(charCount.values());
        if (charCountSet.size() > 2)
            return "NO";

        int commonCount = 0;
        boolean flag = false;
        ArrayList<Integer> countArray = new ArrayList<>(charCount.values());
        if (countArray.size() ==  1) {
            return "YES";
        }
        if (countArray.size() < 3) {
            if (Math.abs(countArray.get(0) - countArray.get(1)) > 1)
                return "NO";
        }

        commonCount = countArray.get(0);
        if (commonCount != countArray.get(1) && commonCount != countArray.get(2)) {
            if (countArray.get(1).equals(countArray.get(2))) {
                if (Math.abs(countArray.get(0) - countArray.get(1)) > 1 && countArray.get(0) != 1)
                    return "NO";
                commonCount = countArray.get(1);
                flag = true;
            }

        }
        else if (commonCount != countArray.get(1) && commonCount == countArray.get(2)) {
            flag = true;
            if (Math.abs(countArray.get(1) - commonCount) > 1)
                return "NO";
        }
        else if (commonCount == countArray.get(1) && commonCount != countArray.get(2)) {
            flag = true;
            if (Math.abs(countArray.get(1) - commonCount) > 1 && countArray.get(1) != 1)
                return "NO";
        }
        for (int i=3; i< countArray.size(); i++) {
            if (countArray.get(i) != commonCount && flag) {
                return "NO";
            }
            else if (countArray.get(i) != commonCount && !flag) {
                if (Math.abs(countArray.get(i) - commonCount) > 1 && countArray.get(i) != 1)
                    return "NO";
                else {
                    flag = true;
                }
            }
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void sherlockValidString(String[] args) {

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);

        scanner.close();
    }
}


/*
Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.

For example, if , it is a valid string because frequencies are . So is  because we can remove one  and have  of each character in the remaining string. If  however, the string is not valid as we can only remove  occurrence of . That would leave character frequencies of .

Function Description

Complete the isValid function in the editor below. It should return either the string YES or the string NO.

isValid has the following parameter(s):

s: a string
Input Format

A single string .

Constraints

Each character
Output Format

Print YES if string  is valid, otherwise, print NO.

Sample Input 0

aabbcd
Sample Output 0

NO
Explanation 0

Given , we would need to remove two characters, both c and d  aabb or a and b  abcd, to make it valid. We are limited to removing only one character, so  is invalid.

Sample Input 1

aabbccddeefghi
Sample Output 1

NO
Explanation 1

Frequency counts for the letters are as follows:

{'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}

There are two ways to make the valid string:

Remove  characters with a frequency of : .
Remove  characters of frequency : .
Neither of these is an option.

Sample Input 2

abcdefghhgfedecba
Sample Output 2

YES
Explanation 2

All characters occur twice except for  which occurs  times. We can delete one instance of  to have a valid string.
 */
//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
