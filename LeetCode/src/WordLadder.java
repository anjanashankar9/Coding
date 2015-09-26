import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ashankar1 on 9/26/15.
 */
public class WordLadder {
    public static void wordLadderMain(String [] args){
        String start = "hit";
        String end = "cog";
        String[] arr = {"hot","dot","dog","lot","log","cog"};
        HashSet<String> dict = new HashSet<String>(Arrays.asList(arr));

        for(String s:dict){
            System.out.print(" "+s);
        }
        int len = ladderLength(start,end,dict);
        System.out.println("Ladder Length : "+len);
    }

    private static int ladderLength(String start, String end, HashSet<String> dict) {
        int len = 0;

        Queue<String> wordQ = new LinkedList<String>();
        Queue<Integer> distQ = new LinkedList<Integer>();

        if (dict.size() == 0)
            return -1;

        wordQ.add(start);
        distQ.add(1);

        while (!wordQ.isEmpty()) {
            String currWord = wordQ.remove();
            Integer currDist = distQ.remove();

            if (currWord.equals(end))
                return currDist;

            for (int i = 0; i < currWord.length(); i++) {
                char[] currArray = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currArray[i] = c;
                    String newStr = new String(currArray);
                    if (dict.contains(newStr)) {
                        wordQ.add(newStr);
                        distQ.add(currDist + 1);
                        dict.remove(newStr);
                    }
                }
            }
        }

        return len;
    }
}

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
//https://leetcode.com/problems/word-ladder/