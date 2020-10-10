package bitmanipulation;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-29
 */
public class NextNumber {
    /*
    We need to flip the righmost non trailing zero.
    And rearrange all bits to the right of p such that all 0s are on the left
    and 1s are on the right. As we do this we replace one of the 1s with zero.

     */

    int getNext(int n) {
        /* Compute c0 and cl */
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        /* Error: if n == 11..1100...00,
        then there is no bigger number with the same * number of ls. */
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        int p = c0 + c1; // position of rightmost non-trailing zero
        n |= (1 << p); // Flip rightmost non-trailing zero
        n &= ~((1 << p) - 1); // Clear all bits to the right of p
        n |= (1 << (c1 - 1)) - 1; // Insert (c1-1) ones on the right
        return n;
    }
}


/*
Given a positive integer, print the next smallest and the next largest number
that have the same number of 1 bits in their binary representation.
 */
