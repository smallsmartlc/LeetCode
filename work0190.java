package Leetcode.smart;

import java.util.Arrays;

public class work0190{
	public static void main(String[] args) {
		work0190 w = new work0190();
		System.out.println(w.reverseBits(43261596));
	}

	public int reverseBits(int n) {
		int res = 0;
		int count = 0;
		while (count < 32) {
			res <<= 1; // res 左移一位空出位置
			res |= (n & 1); // 得到的最低位加过来
			n >>= 1;// 原数字右移一位去掉已经处理过的最低位
			count++;
		}
		return res;
	}
}