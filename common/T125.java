package com.company.leetcode.common;

public class T125 {

    public static void main(String[] args) {

        System.out.println(new T125().isPalindrome("race a car"));

    }

    public boolean isPalindrome(String s) {
        if(s.length()==1) return true;
        String str="";
        char[] c = s.toCharArray();
        int j =c.length-1;
        for(int i=0;i<c.length;i++){
            if(64<c[i]&&c[i]<91){
                c[i] +=32;
//                str+=c[i];
            }else if(c[i]>47&&c[i]<58){
                c[i]=c[i];
//                str+=c[i];
            }else if(c[i]>96&&c[i]<123){
                c[i]=c[i];
            }
            while (c[i]!=32&&c[j]!=32){
              if(c[i]!=c[j]){
                    return false;
                }else break;    
            }
            j--;
        }
//        int m = c.length-1;
//        int n=0;
//        if(c[n]==32)
//            n++;
//        else if(c[m]==32)
//            m--;
//        else if(c[n]!=c[m]){
//            return false;
//        }
        return true;
    }
}
