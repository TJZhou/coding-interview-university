package com.tianju;

import java.util.*;

public class Solution {

    public void dqRun() {
        // instead of using Stack, recommend to use Deque
        Deque<Integer> dq = new LinkedList<>();
        // the implementation of addFirst, offerFirst, push is exactly the same in LinkedList (linkFirst)
        // 0
        dq.addFirst(0);
        // 1 0
        dq.offerFirst(1);
        // 2 1 0
        dq.push(2);
        for(int num : dq) {
            System.out.print(num + " ");
        }

        System.out.println();

        // linkLast
        // 2 1 0 3
        dq.add(3);
        // 2 1 0 3 4
        dq.offer(4);
        // 2 1 0 3 4 5
        dq.addLast(5);
        // 2 1 0 3 4 5 6
        dq.offerLast(6);
        for(int num : dq) {
            System.out.print(num + " ");
        }

        System.out.println();

        // We cannot get index of element in Deque, but we can cast it to LinkedList and then get by index
        List<Integer> cast = (LinkedList<Integer>) dq;
        System.out.println(cast.get(0));
    }

    public void jaggedArrayRun() {
        int[][] arr = new int[3][];
        arr[0] = new int[4];
        arr[1] = new int[3];
        arr[2] = new int[2];
        Arrays.fill(arr[0], 4);
        Arrays.fill(arr[1], 3);
        Arrays.fill(arr[2], 2);
        for(int[] ar : arr) {
            for(int a : ar) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        s.dqRun();
//        s.jaggedArrayRun();
    }
}
