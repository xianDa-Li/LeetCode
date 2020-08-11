package com.company.leetcode.general;

import java.util.*;
public class T946 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        /*
        if(pushed.length==0 && popped.length==0) return true;
        Stack<Integer> s = new Stack<>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            s.push(pushed[i]);
            if(pushed[i]==popped[j]){
                s.pop();
                j++;
            }
        }

        for(int i=j;i<popped.length;i++){
            if(s.pop()!=popped[i])
                return false;
        }
        return true;
        */
        int N = pushed.length;
        Stack<Integer> s = new Stack();

        int j = 0;
        for (int i=0;i<pushed.length;i++) {
            s.push(pushed[i]);
            while (!s.isEmpty()  && s.peek() == popped[j]) {
                s.pop();
                j++;
            }
        }

        return s.isEmpty();

    }

    public static void main(String[] args) {
        int[] pushed ={2,1,0};
        int[] popped = {1,2,0};
        boolean ans = validateStackSequences(pushed,popped);
        System.out.println(ans);
    }
}
