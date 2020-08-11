package com.company.leetcode.common;

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

}
