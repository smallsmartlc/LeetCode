package Leetcode.smart;


public class work0088 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (nums2.length < 1) return;
		if (m == 0) {
			System.arraycopy(nums2, 0, nums1, 0, n);
		}
		int[] n1 = new int[m];
		System.arraycopy(nums1, 0, n1, 0, m);
		int pn = 0;
		int pm = 0;
		while(pn<=n&&pm<=m) {
			if(pn==n&&pm==m) break;
			if(pn==n||(pm<m&&n1[pm]<nums2[pn])) {
				nums1[pn+pm] = n1[pm];
				pm++;
			}else {
				nums1[pn+pm] = nums2[pn];
				pn++;
			}
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
