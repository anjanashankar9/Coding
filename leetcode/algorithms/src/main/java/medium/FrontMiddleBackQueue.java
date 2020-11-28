package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-28
 */
public class FrontMiddleBackQueue {
    List<Integer> queue;

    public FrontMiddleBackQueue() {
        this.queue = new ArrayList<>();
    }

    public void pushFront(int val) {
        queue.add(0, val);
    }

    public void pushMiddle(int val) {
        int i = (queue.size())/2;
        if(queue.size() == 2)
            i=1;
        queue.add(i, val);
    }

    public void pushBack(int val) {
        queue.add(val);
    }

    public int popFront() {
        if(queue.size()==0)
            return -1;
        return queue.remove(0);
    }

    public int popMiddle() {
        if(queue.size() == 0)
            return -1;
        int i = (queue.size()-1)/2;
        return queue.remove(i);
    }

    public int popBack() {
        if(queue.size() == 0)
            return -1;
        return queue.remove(queue.size()-1);
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue fb = new FrontMiddleBackQueue();
//        ["FrontMiddleBackQueue","pushMiddle","pushMiddle","pushFront","popFront","popMiddle","popMiddle","pushMiddle","pushMiddle",
//                "pushMiddle","pushFront","pushMiddle","pushFront","popMiddle","popMiddle","pushMiddle","popMiddle"]
//[[],[772749],[264112],[339812],[],[],[],[173630],[986451],[711423],[288691],[661516],[539917],[],[],[30316],[]]
        fb.pushMiddle(772749);
        fb.pushMiddle(264112);
        fb.pushFront(339812);
        System.out.println(fb.popFront());
        System.out.println(fb.popMiddle());
        System.out.println(fb.popMiddle());
        fb.pushMiddle(173630);
        fb.pushMiddle(986451);
        fb.pushMiddle(711423);
        fb.pushFront(288691);
        fb.pushMiddle(661516);
        fb.pushFront(539917);
        System.out.println(fb.popMiddle());
        System.out.println(fb.popMiddle());
        fb.pushMiddle(30316);
        System.out.println(fb.popMiddle());

    }
}
