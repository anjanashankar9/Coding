package medium;

import helpers.DoublyLinkedListNode;

import java.util.HashMap;

/**
 * @Author Anjana Shankar
 * @Created 2020-12-01
 *
 * We will use two data structures so that our get and put has an O(1) access.
 * Using a doubly linked list to track the access of nodes.
 * Using a hashmap to store the key values.
 */
public class LRUCache {
    final int capacity;
    DoublyLinkedListNode dummyHead;
    DoublyLinkedListNode dummyTail;
    HashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        this.dummyHead = new DoublyLinkedListNode(-1);
        this.dummyTail = new DoublyLinkedListNode(-1, dummyHead);
        this.dummyHead.next = dummyTail;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            moveToEnd(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            moveToEnd(key);
            cache.put(key, value);
            return;
        }
        else if (cache.size() == capacity) {
            removeLeastRecentlyUsed();
        }

        DoublyLinkedListNode node = new DoublyLinkedListNode(key, dummyTail.prev);
        dummyTail.prev.next = node;
        dummyTail.prev = node;
        node.next = dummyTail;
        cache.put(key,value);

    }

    private void removeLeastRecentlyUsed() {
        cache.remove(dummyHead.next.val);
        dummyHead.next.next.prev = dummyHead;
        dummyHead.next = dummyHead.next.next;
    }

    public void moveToEnd(int key) {
        DoublyLinkedListNode prev = dummyHead;
        DoublyLinkedListNode curr = dummyHead.next;

        while (curr.next != dummyTail) {
            if(curr.val == key) {
                prev.next = curr.next;
                curr.next.prev = prev;
                curr.next = dummyTail;
                curr.prev = dummyTail.prev;
                dummyTail.prev.next = curr;
                dummyTail.prev = curr;

                curr = dummyTail;
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }


    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(2);
//        cache.put(1,1);
//        cache.put(2,2);
//        cache.get(1);
//        cache.put(3,3);
//        cache.get(2);
//        cache.put(4,4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);

        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5,5);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);
    }
}

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?



Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4


Constraints:

1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
At most 3 * 104 calls will be made to get and put.
 */

//https://leetcode.com/problems/lru-cache/