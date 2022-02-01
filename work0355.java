package Leetcode.smart;

//355 设计推特

import java.util.*;

public class work0355 {

    public static void main(String[] args) throws AlreadyTakenException, GameEndException {
        Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        System.out.println(obj.getNewsFeed(1));
        obj.follow(1, 2);
        obj.postTweet(2, 6);
        System.out.println(obj.getNewsFeed(1));
        obj.unfollow(1, 2);
        System.out.println(obj.getNewsFeed(5));
    }

    private static class Twitter {

        private Map<Integer, LinkedList<Integer>> map;

        private Map<Integer, Set<Integer>> follow;

        private Map<Integer, Integer> tweetTime;

        private int time = 1;

        public Twitter() {
            map = new HashMap<>();
            follow = new HashMap<>();
            tweetTime = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            map.putIfAbsent(userId, new LinkedList());
            LinkedList<Integer> list = map.get(userId);
            list.addFirst(tweetId);
            if (list.size() > 10) list.removeLast();
            tweetTime.put(tweetId, time++);
        }

        public List<Integer> getNewsFeed(int userId) {
            // 优先队列
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> tweetTime.getOrDefault(o2, 0) - tweetTime.getOrDefault(o1, 0));
            Set<Integer> users = follow.getOrDefault(userId,new HashSet<>());
            users.add(userId);
            for (Integer user : users) {
                LinkedList<Integer> list = map.get(user);
                if (list == null || list.isEmpty()) continue;
                queue.addAll(list);
            }
            List<Integer> res = new ArrayList<>();
            while (!queue.isEmpty() && res.size() < 10) {
                res.add(queue.poll());
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
//            follow.computeIfAbsent(followerId,v->new HashSet<>()).add(followeeId);
            follow.putIfAbsent(followerId, new HashSet<>());
            Set<Integer> set = follow.get(followerId);
            set.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> set = follow.get(followerId);
            if (set == null) return;
            set.remove(followeeId);
            if (set.isEmpty()) follow.remove(followerId);
        }
    }
}