package Leetcode.smart;


public class work0088 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(nums2.length<1) return;
		if(m==0) {
			System.arraycopy(nums2, 0, nums1, 0, n);
			return;
		} 
		int[] n1 = new int[m];
		System.arraycopy(nums1, 0, n1, 0, m);
		int p1 = 0;
		int p2 = 0;
		int i = 0;
		while (i<m+n&&p1<=m&&p2<=n) {
			if(p1==m&&p2==n) break;
			if(p2==n||(p1!=m&&n1[p1]<nums2[p2])) {
				nums1[i] = n1[p1];
				p1++;
			}else{
				nums1[i] = nums2[p2];
				p2++;
			}
			i++;
		}
    }
	public static void main(String[] args) {
		work0088 w= new work0088();
		int[] nums1 = new int[] {1,0,0,0,0,0};
		int[] nums2 = new int[] {2,3,4,5,6};
		w.merge(nums1, 1, nums2, 5);
		LecoUtil.LecoPrint(nums1);
	}
}
