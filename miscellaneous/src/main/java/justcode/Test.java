package justcode;
import java.util.*;

class SmallElementIndex {
    Integer element; // Stores the element
    Integer lesserIndex; // Stores the index of smaller element;
    Integer currIndex; // Stores my current index;

    SmallElementIndex(Integer element, Integer idx, Integer currIndex) {
        this.element = element;
        this.lesserIndex = idx;
        this.currIndex = currIndex;
    }
}
public class Test {

    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        int[] lToR = new int[stockData.size()];
        int[] rToL = new int[stockData.size()];

        Stack<SmallElementIndex> stack = new Stack<>();

        for (int i=0; i<stockData.size(); i++) {
            if(stack.empty()) {
                lToR[i] = -1;
                stack.push(new SmallElementIndex(stockData.get(i), -1, i ));
            }
            else {
                // Check that the element at the top is smaller than the current element.
                // if yes push
                if(!stack.empty() && stack.peek().element < stockData.get(i)) {
                    lToR[i] = stack.peek().currIndex;
                    stack.push(new SmallElementIndex(stockData.get(i), stack.peek().currIndex, i));
                }
                // if no, pop till you find the element lower or stack empty.
                else {
                    while(!stack.empty() && stack.peek().element >= stockData.get(i)) {
                        stack.pop();
                    }
                    if(stack.empty()) {
                        lToR[i] = -1;
                        stack.push(new SmallElementIndex(stockData.get(i), -1, i ));
                    }
                    else {
                        lToR[i] = stack.peek().currIndex;
                        stack.push(new SmallElementIndex(stockData.get(i), stack.peek().currIndex, i));
                    }
                }
            }
        }

        while(!stack.empty()) {
            stack.pop();
        }

        for (int i=stockData.size()-1; i>=0; i--) {
            if(stack.empty()) {
                rToL[i] = -1;
                stack.push(new SmallElementIndex(stockData.get(i), -1, i ));
            }
            else {
                // Check that the element at the top is smaller than the current element.
                // if yes push
                if(stack.peek().element < stockData.get(i)) {
                    rToL[i] = stack.peek().currIndex;
                    stack.push(new SmallElementIndex(stockData.get(i), stack.peek().currIndex, i));
                }
                // if no, pop till you find the element lower or stack empty.
                else {
                    while(!stack.empty() && stack.peek().element >= stockData.get(i)) {
                        stack.pop();
                    }
                    if(stack.empty()) {
                        rToL[i] = -1;
                        stack.push(new SmallElementIndex(stockData.get(i), -1, i ));
                    }
                    else {
                        rToL[i] = stack.peek().currIndex;
                        stack.push(new SmallElementIndex(stockData.get(i), stack.peek().currIndex, i));
                    }
                }
            }
        }

        for (Integer q: queries) {
            int l = lToR[q-1];
            int r = rToL[q-1];

            if (l == -1)
                result.add(r);
            else if (r==-1)
                result.add(l);
            else {
                int lDiff = q-1-l;
                int rDiff = r-q+1;

                if(lDiff<=rDiff)
                    result.add(l);
                else
                    result.add(r);
            }

        }


        return result;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Integer> s = new ArrayList<>();

        s.add(5);
        s.add(6);
        s.add(8);
        s.add(4);
        s.add(9);
        s.add(10);
        s.add(8);
        s.add(3);
        s.add(6);
        s.add(4);


        List<Integer> q = new ArrayList<>();
        q.add(3);
        q.add(1);
        q.add(8);

        predictAnswer(s,q);
    }
}
