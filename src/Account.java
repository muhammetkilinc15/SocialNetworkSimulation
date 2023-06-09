import java.util.*;

public class Account {
    private String name;
    private String userName;
    private String password;
    private boolean isActive;
    private Post posts[];
    private String[] friends;
    private int numberOfFriends;
    private int numberOfPosts;
    private int numberOfAccounts;
    public Account() {
        this.friends = new String[100];
        this.posts = new Post[100];
        this.isActive = true;
        this.numberOfPosts=0;
        this.numberOfFriends=0;
        this.numberOfAccounts++;
    }

    // This method is used for posting. If the account is active, you can post.
    public Post createPost(String content) {
        if (!this.isActive) {
            System.out.println("\nYour account is not active to create post!");
            return null;
        }else {
            posts[numberOfPosts] = new Post(content, new Date());
            numberOfPosts++;
            return posts[numberOfPosts - 1];
        }
    }

    // This method allows the user to add friends and
    // if the user has added a friend before, he/she cannot add them again.
    public int addFriend(String userName) {
        if (!this.isActive) {
            System.out.println("\nYour account is not active to add friend!");
            return -1;
        }
        // Check friend list
        for (int i = 0; i < numberOfFriends; i++) {
            if (userName.equals(friends[i])) {
                System.out.println(userName + " is already in your friend list!");
                return -1;
            }
        }
        friends[numberOfFriends] = userName;
        numberOfFriends++;
        return this.numberOfFriends;
    }

    // This method returns the user's name, username, activeness,
    // number of posts and friends, and information about them.
    public String toString() {
        StringBuilder postInformation = new StringBuilder("Posts are:\n");
        for (int i = 0; i < numberOfPosts; i++) {
            postInformation.append(posts[i].toStings());
        }
        StringBuilder friendsInformation = new StringBuilder("Friends are:\n");
        for (int i = 0; i < numberOfFriends; i++) {
            friendsInformation.append(friends[i]).append("\n");
        }
        return "\nName: " + getName() +
                "\nUsername: " + getUserName() +
                "\nActiveness: " + isActive() +
                "\nNumber of posts: " + getNumberOfPosts() +
                "\nNumber of friends: " + getNumberOfFriends() +
                "\n" + postInformation +
                "\n" + friendsInformation;
    }

    // Getter and Setter Methods...
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public int getNumberOfFriends() {
        return numberOfFriends;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }
    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }
    public void setNumberOfAccounts(int numberOfAccounts) {
        this.numberOfAccounts = numberOfAccounts;
    }
}
