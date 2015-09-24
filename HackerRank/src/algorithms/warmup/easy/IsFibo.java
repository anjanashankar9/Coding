package algorithms.warmup.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ashankar1 on 4/9/15.
 */
public class IsFibo {
    public static void isfibo() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        List<Long> fiboNumbers = new ArrayList<Long>();
        fiboNumbers.add(new Long(0));
        fiboNumbers.add(new Long(1));
        for(int i=0;i<T;i++){
            Long number = in.nextLong();
            isFibo(number,fiboNumbers);
        }
    }
    private static void isFibo(Long N,List<Long> fiboNumers){
        if (N <= fiboNumers.get(fiboNumers.size()-1)){
            for(Long l : fiboNumers){
                if(N.longValue() == l.longValue()){
                    System.out.println("IsFibo");
                    return;
                }
            }

            System.out.println("IsNotFibo");
            return;
        }
        Long l1 = fiboNumers.get(fiboNumers.size()-2);
        Long l2 = fiboNumers.get(fiboNumers.size()-1);

        while(N>l2){
            fiboNumers.add(new Long(l1+l2));
            l1 = fiboNumers.get(fiboNumers.size()-2);
            l2 = fiboNumers.get(fiboNumers.size()-1);
        }

        if(N.longValue() == l2.longValue()){
            System.out.println("IsFibo");
        }
        else
            System.out.println("IsNotFibo");
    }
}
/*
You are given an integer, N. Write a program to determine if N is an element of the Fibonacci sequence.

        The first few elements of the Fibonacci sequence are 0,1,1,2,3,5,8,13,⋯. A Fibonacci sequence is one where every
        element is a sum of the previous two elements in the sequence. The first two elements are 0 and 1.

        Formally:
        fib0fib1⋮fibn=0=1=fibn−1+fibn−2∀n>1
        Input Format
        The first line contains T, number of test cases.
        T lines follow. Each line contains an integer N.

        Output Format
        Display IsFibo if N is a Fibonacci number and IsNotFibo if it is not. The output for each test case should be displayed in a new line.

        Constraints
        1≤T≤105
        1≤N≤1010
        Sample Input

        3
        5
        7
        8
        Sample Output

        IsFibo
        IsNotFibo
        IsFibo
        Explanation
        5 is a Fibonacci number given by fib5=3+2
        7 is not a Fibonacci number
        8 is a Fibonacci number given by fib6=5+3

        Time Limit
        Time limit for this challenge is given https://www.hackerrank.com/environment.
*/

//https://www.hackerrank.com/challenges/is-fibo