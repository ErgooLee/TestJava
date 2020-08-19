package com.xiaowuzei.test.algr.leet;

import java.util.*;

public class N355_DesignTwitter {
    public static void main(String[] args) {
//        Twitter twitter = new Twitter();
//        twitter.postTweet(1,3);
//        twitter.postTweet(1,5);
//        System.out.println(twitter.getNewsFeed(1));

//        Twitter twitter2 = new Twitter();
//        twitter2.postTweet(1,5);
//        twitter2.unfollow(1,1);
//        System.out.println(twitter2.getNewsFeed(1));

        Twitter twitter3 = new Twitter();
        twitter3.postTweet(1,4);
        twitter3.postTweet(2,5);
        twitter3.unfollow(1,2);
        twitter3.follow(1,2);
        System.out.println(twitter3.getNewsFeed(1));
    }

}


class Twitter {

    Map<Integer, User> users;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        users = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        User user = getOrCreateUser(userId);
        user.postTweet(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        User user = getOrCreateUser(userId);
        Set<Integer> followees = user.followees;
        Tweet tmp;
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.timeStamp - o1.timeStamp);
        if (followees != null) {
            for (Integer followee : followees) {
                tmp = getOrCreateUser(followee).head;
                while (tmp != null) {
                    priorityQueue.add(tmp);
                    tmp = tmp.next;
                }
            }
        }
        int count = 0;
        List<Integer> ret = new ArrayList<>();
        while (!priorityQueue.isEmpty() && count < 10) {
            ret.add(priorityQueue.poll().id);
            count++;
        }
        return ret;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        getOrCreateUser(followeeId);
        getOrCreateUser(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        getOrCreateUser(followeeId);
        getOrCreateUser(followerId).unfollow(followeeId);
    }

    private User getOrCreateUser(int userId) {
        User user = users.get(userId);
        if (user == null) {
            user = new User(userId);
            users.put(userId, user);
        }
        return user;
    }
}


class Tweet {
    static int time = 0;
    int id;
    int timeStamp;
    Tweet next;
    public Tweet(int id, Tweet next) {
        this.id = id;
        this.timeStamp = buildTimeStamp();
        this.next = next;
    }

    private int buildTimeStamp() {
        return time++;
    }
}

class User {
    int id;
    Set<Integer> followees = null;
    Tweet head = null;

    public User(int id) {
        this.id = id;
        //关注自己
        follow(id);
    }

    public void postTweet(int tweetId) {
        if (head == null) {
            head = new Tweet(tweetId, null);
        } else {
            head = new Tweet(tweetId, head);
        }
    }

    public void follow(int followeeId) {
        if (followees == null) {
            followees = new HashSet<>();
        }
        followees.add(followeeId);
    }

    public void unfollow(int followeeId) {
        if (followees == null || followeeId == id) {
            return;
        }
        followees.remove(followeeId);
        if (followees.isEmpty()) {
            followees = null;
        }
    }
}

