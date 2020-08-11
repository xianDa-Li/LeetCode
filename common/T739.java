package com.company.leetcode.common;

public class T739 {
    public static void main(String[] args) {
        int[] T = {73,74,75,71,69,72,76,73};
        int[] a = dailyTemperatures(T);
        for(int i :a){
            System.out.println(i);
        }
    }

    public static  int[] dailyTemperatures(int[] T) {
//        int[] D = new int[T.length];
//        for(int i=0;i<T.length-1;i++){
//            for(int j=i+1;j<T.length;j++){
//                if(T[j]>T[i]){
//                    D[i] = j-i;
//                    break;
//                }
//            }
//        }
//        return D;

        int[] res = new int[T.length];
        for(int i=T.length-1;i>=0;i--){
            int j=i+1;
            while(j<T.length){
                if(T[j]>T[i]){
                    res[i]=j-i;
                    break;
                }else if(res[j]==0){
                    break;
                }else{
                    j = res[j]+j;
                }
            }
        }
        return res;
    }
}
