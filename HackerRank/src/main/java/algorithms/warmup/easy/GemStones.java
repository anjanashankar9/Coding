package algorithms.warmup.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ashankar1 on 4/9/15.
 */
public class GemStones {
    public static void gemstones(String [] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] rockComposition = new String[N];
        for(int i=0;i<N;i++){
            rockComposition[i] = in.next();
        }
        int gems = findGems(rockComposition,N);
        System.out.println(gems);
    }
    private static int findGems(String[] rockComposition, int N){
        char[] firstString = rockComposition[0].toCharArray();
        Set<Character> charSet = new HashSet<Character>();

        for(char s:firstString){
            boolean isGem = false;
            for(int j=1;j<N;j++){
                if(rockComposition[j].indexOf(s) != -1)
                    isGem = true;
                else{
                    isGem = false;
                    break;
                }
            }
            if(isGem){
                charSet.add(s);
            }

        }
        return charSet.size();
    }
}

/*
John has discovered various rocks. Each rock is composed of various elements,
and each element is represented by a lowercase latin letter from 'a' to 'z'. An element can be present multiple times in a rock.
An element is called a 'gem-element' if it occurs at least once in each of the rocks.

Given the list of N rocks with their compositions, display the number of gem-elements that exist in those rocks.

Input Format
The first line consists of N, the number of rocks.
Each of the next N lines contain rocks' composition. Each composition consists of lowercase letters of English alphabet.

Output Format
Print the number of gem-elements that are common in these rocks. If there are none, print 0.

Constraints
1 ≤ N ≤ 100
Each composition consists of only lowercase latin letters ('a'-'z').
1 ≤ Length of each composition ≤ 100

Sample Input

3
abcdde
baccd
eeabg
Sample Output

2
Explanation
Only "a", "b" are the two kind of gem-elements, since these are the only characters that occur in each of the rocks' composition.
 */
