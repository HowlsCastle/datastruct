package com.example.datastruct.stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterNum {
    public int[] nextGreaterNum(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap();


        for(int n : nums2) {
            if (stack.size() !=0 && n > stack.peek()) {
                hashMap.put(stack.pop(), n);
            }
            stack.push(n);
        }

        int[] ret = new int[nums1.length];
        for(int i = 0; i < nums1.length; ++i) {
            ret[i] = hashMap.getOrDefault(nums1[i], -1);
        }
        return ret;
    }


}
