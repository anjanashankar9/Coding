package dictionaries_and_hashmaps;


import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int pairs = 0;
        for (int i=1; i<s.length(); i++) {
            String[] substrings = getSubstrings(s,i);
            for (int j=0; j<substrings.length-1; j++) {
                for(int k=j+1; k<substrings.length; k++) {
                    if (isAnagram(substrings[j], substrings[k]))
                        pairs++;
                }
            }

        }
        return pairs;
    }

    //Get all substrings of length n
    static String[] getSubstrings(String s, int n) {
        String[] substrings = new String[s.length() - n +1];

        for (int i=0; i<=s.length()-n; i++) {
            substrings[i] = s.substring(i,i+n);
        }

        return substrings;
    }

    static boolean isAnagram(String a, String b) {
        Map<Character, Integer> letters = new HashMap<>();
        if (a.length() != b.length())
            return false;

        for (int i=0; i<a.length(); i++) {
            if (letters.containsKey(a.charAt(i))) {
                letters.put(a.charAt(i), (letters.get(a.charAt(i)) + 1));
            }
            else {
                letters.put(a.charAt(i), 1);
            }
        }

        for (int i=0; i<b.length(); i++) {
            if (letters.containsKey(b.charAt(i))) {
                if (letters.get(b.charAt(i)) == 1) {
                    letters.remove(b.charAt(i));
                }
                else {
                    letters.put(b.charAt(i), letters.get(b.charAt(i)) - 1);
                }
            }
            else
                return false;
        }
        return true;
    }

    public static void sherlockAnagrams(String[] args)  {

        int q = 2;

        String s1 = "abba";
        String s2 = "abcd";

        int result = sherlockAndAnagrams(s1);
        System.out.println(result);

        result = sherlockAndAnagrams(s2);
        System.out.println(result);
    }
}



/*
Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example , the list of all anagrammatic pairs is  at positions  respectively.

Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .

sherlockAndAnagrams has the following parameter(s):

s: a string .
Input Format

The first line contains an integer , the number of queries.
Each of the next  lines contains a string  to analyze.

Constraints



String  contains only lowercase letters  ascii[a-z].

Output Format

For each query, return the number of unordered anagrammatic pairs.

Sample Input 0

2
abba
abcd
Sample Output 0

4
0
Explanation 0

The list of all anagrammatic pairs is  and  at positions  and  respectively.

No anagrammatic pairs exist in the second query as no character repeats.

Sample Input 1

2
ifailuhkqq
kkkk
Sample Output 1

3
10
Explanation 1

For the first query, we have anagram pairs  and  at positions  and respectively.

For the second query:
There are 6 anagrams of the form  at positions  and .
There are 3 anagrams of the form  at positions  and .
There is 1 anagram of the form  at position .

Sample Input 2

1
cdcd
Sample Output 2

5
Explanation 2

There are two anagrammatic pairs of length :  and .
There are three anagrammatic pairs of length :  at positions  respectively.
 */

//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps