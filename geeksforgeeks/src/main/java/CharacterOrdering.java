/**
 * @Author Anjana Shankar
 * @Created 2020-09-21
 */
public class CharacterOrdering {

    public static void main(String[] args){
        int noOfAlphabets = 3;
        String[] words = {"caa", "aaa", "aab"};
        printDictionaryOrder(noOfAlphabets,words);
    }

    private static void printDictionaryOrder(int noOfAlphabets,
                                             String[] words) {
        Graph graph = new Graph(noOfAlphabets);
        //Process adjacent pair of words to build the graph.
        for(int i=0;i<words.length-1;i++){
            //Take 2 adjacent words, and find the first mismatching character
            String word1 = words[i];
            String word2 = words[i+1];
            for(int j=0;j<Math.min(word1.length(), word2.length());j++){
                //If we find a mismatching character then create an edge from character of word1 to word2
                if(word1.charAt(j) != word2.charAt(j)){
                    graph.addEdge(word1.charAt(j) - 'a',word2.charAt(j) - 'a');
                    break;
                }
            }
        }
        graph.topologicalSort();
    }
}


/**
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
 * Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
 * Output: Order of characters is 'b', 'd', 'a', 'c'
 * Note that words are sorted and in the given language "baa"
 * comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 * Input:  words[] = {"caa", "aaa", "aab"}
 * Output: Order of characters is 'c', 'a', 'b'
 */
//http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/