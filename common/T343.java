package com.company.leetcode.common;

public class T343 {
	public static void main(String[] args) {
		int n = 120;
//		System.out.println(cuttingRope(n));
		System.out.println(integerBreak(8));
	}

	//方法1
	public static int cuttingRope(int n) {
		int mod = 1000000007;
		if(n<4) return n-1;
		if(n==4) return n;
		long ans = 1;
		while(n>4){
			System.out.println("取模前ans = "+ans);
			n = n-3;
			ans = ans*3;
			ans = ans % mod;
		}
		ans = (ans * n )% mod;
		return (int)ans;
	}

	//方法2
	public static int integerBreak(int n) {
		int a = n / 3;
		int b = n % 3;
		if(b == 0) return (int)Math.pow(3,a);
		if(b == 1) return (int)Math.pow(3,a-1)*4;
		return (int)Math.pow(3,a)*2;
	}
}
