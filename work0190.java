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
			res <<= 1; // res ����һλ�ճ�λ��
			res |= (n & 1); // �õ������λ�ӹ���
			n >>= 1;// ԭ��������һλȥ���Ѿ�����������λ
			count++;
		}
		return res;
	}
}