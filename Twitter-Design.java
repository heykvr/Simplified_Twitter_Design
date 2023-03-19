import java.util.*;
class Pair<T1,T2>
{
    private int value1;
    private int value2;
    Pair(int a, int b)
    {
        this.value1=a;
        this.value2=b;
    }
    public int getKey(){
        return value1;
    }
    public  int getValue(){
        return value2;
    }
}
class Twitter {
    Stack<Pair<Integer,Integer>> tweets;
    HashMap<Integer, Set<Integer>> network;

    public Twitter() {
		tweets = new Stack<>();
		network = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.push(new Pair(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Stack<Pair<Integer, Integer>> store = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        Set<Integer> following = network.getOrDefault(userId, new HashSet<>());
        
        while(tweets.size()!=0 && ans.size()!=10){
            Pair<Integer, Integer> curr = tweets.pop();
            if((following.contains(curr.getKey()) || curr.getKey()==user Id)
               && ans.size()!=10) ans.add(curr.getValue());
            store.push(curr);
        }
        while(store.size()!=0) tweets.push(store.pop());
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> following = network.getOrDefault(followerId, new HashSet<>());
        following.add(followeeId);
        network.put(followerId, following);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> following = network.get(followerId);
        if(following == null) return;
        following.remove(followeeId);
        network.put(followerId, following);
    }
}
public class Main
{
	public static void main(String[] args)
	{
	    
	    Scanner sc=new Scanner(System.in);
	    Twitter s=new Twitter();
	    int l;
	    do
	    {
	        System.out.println("press 1 for posttweet");
	        System.out.println("press 2 for getnewsfeed");
	        System.out.println("press 3 for follow");
	        System.out.println("press 4 for unfollow");
	        System.out.println("press 0 for main menu");
	        int d=sc.nextInt();
	        switch(d)
	        {
	            case 1:
	                {
	                    int n=sc.nextInt();
	                    int m=sc.nextInt();
	                    s.postTweet(n,m);
	                    System.out.println("tweet posted for userid : "+n+" with" +" tweetid : "+m);
	                    break;

	                }
	            case 2:
	                {
	                    int u=sc.nextInt();
	                    System.out.println(s.getNewsFeed(u));
	                    
	                    break;
	                }
	            case 3:
	                {
	                    int a=sc.nextInt();
	                    int b=sc.nextInt();
	                    s.follow(a,b);
	                    System.out.println("followed successfully");
	                    break;
	                }
	            case 4:
	                {
	                    int c=sc.nextInt();
	                    int e=sc.nextInt();
	                    s.unfollow(c,e);
	                    System.out.println("unfollowed successfully");
	                    break;
	                }
	        }
	        System.out.println("enter 0 to go back to menu");
	        System.out.println("enter any key(number) to exit");
	        l=sc.nextInt();
	    }
	    while(l==0);
	    System.out.println("Exit Successfully");
    }
}