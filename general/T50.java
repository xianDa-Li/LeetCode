package com.company.leetcode.general;

public class T50 {
	public static void main(String[] args) {

	}
	public double myPow(double x, int n) {
		if (n == 0) return 1;
		if (n == 1) return x;
		if (n == -1) return 1 / x;
		if (n % 2 == 0) {
			double ans = myPow(x, n / 2);
			return ans * ans;
		} else {
			double ans = myPow(x, n / 2);
			if (n < 0) x = (1 / x);
			return ans * ans * x;
		}
	}

	public double myPow2(double x,int n){
		if(x == 0) return 0;
		long b = n;
		double ans = 1;
		if(b<0){
			x = 1/x;
			b = -b;
		}
		while (b>0){
			if((b&1)==1) ans *= x;
			x *= x;
			b >>= 1;
		}
		return ans;
	}

}
