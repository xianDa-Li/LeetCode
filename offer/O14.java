package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/12 8:22
 * Remark:
 */
public class O14 {
	/*
	此题O14两道题相同 就直接给O14-2的题解了
	方法一：数学方法
		思路：
			主要还是不太容易想的到，反正记住2*3>2+3。尽量把结果划分成3，划分到不能划分为止，
			但是等于4的时候划分为3的话，3*1<3+1,这样就不行了，
			这种情况就不划分了,n就每次都减3，返回的值就每次乘3，
			最后n的值小于等于4的时候就不用再化分了，直接乘上剩下的n和之前得到的ans
		时间O(n)
		空间O(1)
	 */
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

	/*
	方法二：数学方法 + 贪心
		思路：
			方法一的优化，反正都是做一样的乘以3，可以用3的x次方来得到，但是要处理一些情况，不让最后剩下的n等于1
		时间O(1)
		空间O(1)
		*/
	public static int integerBreak(int n) {
		int a = n / 3;
		int b = n % 3;
		if(b == 0) return (int)Math.pow(3,a);
		if(b == 1) return (int)Math.pow(3,a-1)*4;
		return (int)Math.pow(3,a)*2;
	}




}
