package Leetcode.smart;

public class work0125 {
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j) {
            // ��i��jָ���һ������ĸ�����ֵ�λ��
            while (!Character.isLetterOrDigit(charArray[i]) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(charArray[j]) && i < j) {
                j--;
            }

            // �������ȣ��ͷ���false
            if ((int) Character.toLowerCase(charArray[i]) != (int) Character.toLowerCase(charArray[j])) {
                return false;
            }

            // ��i��j���м��ƶ�
            i++; j--;
        }
        return true;
	}
	public static void main(String[] args) {
		work0125 w= new work0125();
		System.out.println(w.isPalindrome("."));
	}
}
