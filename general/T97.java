package com.company.leetcode.general;

/*
    给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 */
public class T97 {

    public static void main(String[] args) {
        T97 t97 = new T97();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean ans = t97.isInterleave(s1,s2,s3);
        System.out.println(ans);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3) return false;

        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for (int i = 0; i <= len1; ++i) {
            for (int j = 0; j <= len2; ++j) { // f(i,j) 表示 s1 的前 i 个元素和 s2 的前 j 个元素是否能交错组成 s3 的前 i+j 个元素
                int p = i + j - 1;
                if (i > 0) f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                if (j > 0) f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
            }
        }
        return f[len1][len2];

        /*

        char[] c3 = s3.toCharArray();
        List<Character> list3 = new ArrayList<>();
        for(int i=0;i<len3;i++){
            list3.add(c3[i]);
        }
        System.out.println(list3);

        int p1 = 0;
        int p3 = 0;
        while(p3 < list3.size()){
            if(list3.get(p3) == s1.charAt(p1)){
                p1++;
                list3.remove(p3);
                int s = list3.size();
            }
            p3++;
        }
        System.out.println(p1);
        System.out.println(list3);

        if(p1 != (len1-1)) return false;

        int p2 = 0;
        for(int i=0;i<list3.size();i++){
            if(list3.get(i) == s2.charAt(p2)){
                p2++;
                list3.remove(i);
                int s = list3.size();
            }
        }
        return list3.isEmpty();
        */
    }

}
