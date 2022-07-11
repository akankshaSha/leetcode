class Tweet
{
    int tweetId;
    int userId;
    
    Tweet(int tweetId, int userId)
    {
        this.tweetId=tweetId;
        this.userId=userId;
    }
}

class Twitter {
    
    List<Tweet> tweets;
    HashMap<Integer, HashSet<Integer>> following;
    //<userId, set of ids of users you follow>
    public Twitter() {
        tweets=new ArrayList<>();
        following=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet=new Tweet(tweetId, userId);
        tweets.add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed=new ArrayList<>();
        for(int i=tweets.size()-1; i>=0; i--)
        {
            Tweet tweet=tweets.get(i);
            if(tweet.userId==userId || (following.get(userId)!=null && following.get(userId).contains(tweet.userId)))
                feed.add(tweet.tweetId);
            if(feed.size()>=10) break;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> f=following.getOrDefault(followerId, new HashSet<Integer>());
        f.add(followeeId);
        following.put(followerId,f);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> h=following.get(followerId);
        if(h!=null && h.contains(followeeId))
        {
            h.remove(followeeId);
            following.put(followerId, h);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */