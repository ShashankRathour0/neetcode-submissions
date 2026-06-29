class Twitter {

     private static int timestamp = 0; // Global timestamp for ordering tweets
    private final Map<Integer, Set<Integer>> followers; // Maps a user to the users they follow
    private final Map<Integer, List<Tweet>> tweets; // Maps a user to their tweets

    // Helper class for tweets
    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }

    // Post a tweet
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    // Get news feed
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add the user's own tweets
        if (tweets.containsKey(userId)) {
            maxHeap.addAll(tweets.get(userId));
        }

        // Add tweets of followed users
        Set<Integer> followees = followers.getOrDefault(userId, new HashSet<>());
        for (int followeeId : followees) {
            if (tweets.containsKey(followeeId)) {
                maxHeap.addAll(tweets.get(followeeId));
            }
        }

        // Fetch the 10 most recent tweets
        List<Integer> newsFeed = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            newsFeed.add(maxHeap.poll().tweetId);
            count++;
        }
        return newsFeed;
    }

    // Follow a user
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // Can't follow oneself
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    // Unfollow a user
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}
