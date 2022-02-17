package Leetcode.smart;


import java.util.*;

/**
 * LeetCode0382 链表随机节点
 */
public class work0382 {
    public static void main(String[] args) {
        work0382 w = new work0382();
        Solution obj = new Solution(new ListNode(1, 2, 3));
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }

    private static class Solution {
        private List<ListNode> list;
        private Random random = new Random();

        public Solution(ListNode head) {
            list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size())).val;
        }
    }

    class Solution2 { // 每次查询时去遍历,但还是要把整个链表遍历一遍获得size
        // 空间复杂度O(1)
        private int size;
        private Random random = new Random();
        private ListNode node;

        public Solution2(ListNode head) {
            node = head;
            while (head != null) {
                size++;
                head = head.next;
            }
        }

        public int getRandom() {
            int i = random.nextInt(size);
            ListNode p = node;
            while (i-- > 0) {
                p = p.next;
            }
            return p.val;
        }
    }

    class Solution3 { // 荷塘算法,我们不需要每次都把链表遍历完
        private Random random = new Random();
        private ListNode head;

        public Solution3(ListNode head) {
            head = head;
        }

        public int getRandom() {
            int i = 1, ans = 0;
            for (ListNode node = head; node != null; node = node.next) {
                if (random.nextInt(i) == 0) { // 1/i 的概率选中（替换为答案）
                    ans = node.val;
                }
                ++i;
            }
            return ans;
        }
    }
}