package com.company.leetcode.general;

public class T5 {
    /*
        暴力破解优化:
            时间：O(n^2)
            空间：O(n)
     */
    public String longestPalindrome7(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /*
        中心扩散:
        时间:O(n^2)
        空间:O(1)

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    */

    /*
    public static void main(String[] args) {
        T5 t5 = new T5();
        String s = "aaca";
        System.out.println(t5.longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        StringBuffer sb = new StringBuffer(s);
        StringBuffer rsb = new StringBuffer(s);
        rsb.reverse();
        String ans = "";
        int len = s.length();
        if(len<3) {
            String sa1 = sb.toString();
            String sa2 = rsb.toString();
            if(sa1.equals(sa2)) return sa1;
            return sa1.substring(0,1);
        }

        int size = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                String s1 = sb.substring(i,j);
                String s2 = rsb.substring(i,j);
                System.out.println("s1= "+s1);
                System.out.println("s2= "+s2);
                if(s1.equals(s2) && s1.length()>size){
                    size = s1.length();
                    ans = s1;
                }
            }
        }
        return ans;
    }
    */

    /*
    暴力解法：
        时间:O(n^3)
        空间:O(1)
    public static void main(String[] args) {
        T5 t5 = new T5();
        String rs = "abba";
        System.out.println(t5.reveser(rs));
        System.out.println(t5.longestPalindrome(rs));
    }
    public boolean reveser(String rs){
        int i = 0;
        int j = rs.length()-1;
        while(i<j){
            if(rs.charAt(i)!=rs.charAt(j)){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (reveser(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }
     */
}
