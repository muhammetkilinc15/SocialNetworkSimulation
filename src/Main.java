import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        SocialNetwork facebook = new SocialNetwork("facebook");
        SocialNetwork instagram = new SocialNetwork("instagram");

        facebook.createAccount("Albert Einstein", "atomBomb", "einstein1879");
        facebook.createAccount("Isaac Newton", "gravityBoy", "newton1643");
        facebook.createAccount("Marie Curie", "radioGirl", "curie1867");

        instagram.createAccount("Stephen Hawking", "quantumKid", "hawking");
        instagram.createAccount("Max Plank", "quantumKid", "plank1858");
        instagram.createAccount("Niels Bohr", "quantumKid", "bohr1885");

        System.out.println("\nNumber of accounts on facebook: " + facebook.accountCount);
        System.out.println("\nNumber of accounts on instagram: " + instagram.accountCount);

        instagram.createAccount("Nikola Tesla", "electricMan", "tesla1856");
        instagram.createAccount("Thomas Edison", "electricKid", "edison1847");

        System.out.println("\nNumber of accounts on facebook: " + facebook.accountCount);
        System.out.println("\nNumber of accounts on instagram: " + instagram.accountCount);

        facebook.accounts[0].addFriend("electricMan");
        facebook.accounts[0].addFriend("electricKid");
        facebook.accounts[0].addFriend("electricMan");

        Post post1 = facebook.accounts[0].createPost("I love vaccines!");
        Post post2 = facebook.accounts[0].createPost("Get vaccinated!");
        post1.increaseLike();
        post2.increaseLike();
        post2.increaseLike();

        SocialNetwork.changeStatusOfActiveness(facebook.accounts[0]);
        Post post3 = facebook.accounts[0].createPost("Vaccine rocks!");
        facebook.accounts[0].addFriend("quantumKid");
        System.out.println(facebook.accounts[0].toString());



        SocialNetwork.changeStatusOfActiveness(facebook.accounts[0]);
        Post post4 = facebook.accounts[0].createPost("Vaccine rocks!");
        facebook.accounts[0].addFriend("quantumKid");
        System.out.println(facebook.accounts[0].toString());


        System.out.println(facebook.toString());
        System.out.println(instagram.toString());


    }
}