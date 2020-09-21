package algorithms.warmup.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ashankar1 on 4/6/15.
 */
public class IdentifySmithNumbers {
    public static void identifySN(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        isSN(n);
    }
    private static void isSN(int n){
        List<Integer> primeFactors = findPrimeFactors(n);
        for(Integer i:primeFactors){
            System.out.print(i);
        }
        int pfSum = calcSum(primeFactors);
        System.out.println("pfSum = "+pfSum);
        int digitsSum = sumOfDigits(n);
        System.out.println("digitssum = "+digitsSum);
        if(pfSum==digitsSum)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static int sumOfDigits(int n) {
        int sum=0;
        while(n>0){
            sum+= n%10;
            n=n/10;
        }
        return sum;
    }

    private static int calcSum(List<Integer> primeFactors) {
        int sum = 0;
        for(Integer i:primeFactors){
            if(i>9){
                List<Integer> newlist = new ArrayList<Integer>();
                int j=i;
                while(j>0){
                    newlist.add(j%10);
                    j=j/10;
                }
                sum+=calcSum(newlist);
            }
            else
                sum+=i;
        }
        return sum;
    }

    private static List<Integer> findPrimeFactors(int n) {
        List<Integer> primeFactors = new ArrayList<Integer>();
        for(int i=2;i<=n;i++){
            if(n%i == 0){
                primeFactors.add(i);
                n/=i;
                i--;
            }
        }
        return primeFactors;
    }


}
/*
A Smith number is a composite number, the sum of whose digits is the sum of the digits of its prime factors obtained as a result of
prime factorization (excluding 1). The first few such numbers are 4, 22, 27, 58, 85, 94, and 121.

Example:
378=2×3×3×3×7
So, its prime factors are 2, 3, 3, 3, and 7.
The sum of its digits is (3+7+8)=18.
The sum of the digits of its factors is (2+3+3+3+7)=18.

Similarly, 4937775 is a Smith number.
4937775=3×5×5×65837, and the sum of its digits is the same as the sum of the digits of its prime factors: 4+9+3+7+7+7+5=3+5+5+6+5+8+3+7=42.

Task:
Write a program to check whether a given integer is a Smith number.

Input Format

There will be only one line of input: N, the number which needs to be checked.

Constraints:
0<N<2,147,483,647 (max value of an integer of the size of 4 bytes)

Output Format

1 if the number is a Smith number.
0 if the number is a not Smith number.

Sample Input

378

Sample Output

1

Explanation

Its prime factors are 2, 3, 3, 3, and 7.
The sum of its digits is (3+7+8)=18.
The sum of the digits of its factors is (2+3+3+3+7)=18.
 */

//https://www.hackerrank.com/challenges/identify-smith-numbers