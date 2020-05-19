package level2arrays;

import java.util.ArrayList;

public class AddOne {

    public static int[] plusOne(int[] A) {
        if (A.length == 0)
            return new int[0];

        int sum, digit = 0;
        int carry = 1;
        int i = A.length - 1;
        int j=0;
        for (;j<A.length-1; j++){
            if(A[j] != 0)
                break;
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for(;i>=j; i--) {
            sum = A[i] + carry;
            digit = sum %10;
            carry = sum/10;
            resultList.add(digit);
        }
        if (carry > 0) {
            resultList.add(carry);
        }

        int[] result = new int[resultList.size()];
        for (i=resultList.size() -1, j=0; i>=0; i--, j++) {
            result[j] = resultList.get(i);
        }
        return result;
    }

    public static void addOne(String[] args) {
        int[] A = new int[]{9};
        for (int i=0; i< A.length; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println();
        int[] B = plusOne(A);
        for (int i=0; i< B.length; i++){
            System.out.print(B[i]+" ");
        }
        System.out.println();
    }
}