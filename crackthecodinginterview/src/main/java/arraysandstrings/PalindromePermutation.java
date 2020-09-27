package arraysandstrings;

import java.util.HashMap;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-27
 */
public class PalindromePermutation {

    /*
    Solution 1:
    Keep a count of characters in the string.
    We should have an even number of all except(at max 1) character.
     */
    private boolean palindromePermutation(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(Character c: s.toCharArray()) {
            if(!hashMap.containsKey(c)) {
                hashMap.put(c, 0);
            }
            hashMap.put(c, hashMap.get(c)+1);
        }

        boolean oddFlag = false;
        for(char c:hashMap.keySet()) {
            if(hashMap.get(c) % 2 != 0){
                if(oddFlag) {
                    return false;
                }
                oddFlag = true;
            }
        }

        return true;
    }

    /*
    Solution 2: Using a bitmap.
    We can switch the bit on an off as we find an odd or even
    number of the character.
    All except one bit should be unset.
     */
    private boolean palindromePermutationBitMap(String s) {
        int bitvector = createBitVectorForString(s);
        return bitvector == 0 || checkExactlyOneBitIsSet(bitvector);
    }

    /*
    TIP: Exactly one bit is set can be checked by subtracting one from the number
    and then ANDing with the original integer.
     */
    private boolean checkExactlyOneBitIsSet(int bitvector) {
        return (bitvector & (bitvector - 1)) == 0;
    }

    /*
    Create a bit vector for the string. For each letter with value i,
    toggle the ith bit.
     */
    private int createBitVectorForString(String s) {
        int bitvector = 0;
        for(char c: s.toCharArray()) {
            int x = getCharNumber(c);
            bitvector = toggle(bitvector, x);
        }
        return bitvector;
    }

    /*
    Toggle the ith bit in the integer
     */
    private int toggle(int bitvector, int i) {
        if (i < 0) return bitvector;

        int mask = 1 << i;
        bitvector ^= mask;
        return bitvector;
    }

    /* Map each character to a number. a -> 0, b -> 1, c -> 2, etc. 21 * This is case insensitive. Non-letter characters map to -1. */
    private int getCharNumber(char c) {
        int a= Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val= Character.getNumericValue(c);
        if (a<= val && val<= z) {
            return val - a;
        }
        return -1;
    }

    public static void palindromePermutation(String[] args) {
        String s = "tactcot";
        System.out.println(new PalindromePermutation().palindromePermutationBitMap(s));
    }
}

/*
Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat'; "atc o eta·; etc.)
 */