import java.util.concurrent.TransferQueue;

public class SocialNetwork {
    private String name;
    Account[] accounts;
    int accountCount = 0;

    public SocialNetwork(String name) {
        this.accountCount=0;
        this.accounts = new Account[100]; // Here, new Account[100] means 100 accounts will be added to the accounts array.
        this.name = name;
    }
    // This method creates an account. Enters username, username and password.
    public void createAccount(String name, String userName, String password) {
        String result = "";
        if (isPasswordValid(password)) {
            result += "\nPassword is valid ";
            if (isUserNameExist(userName)) {
                result += "for " + userName;
                System.out.println(result);
                // Adding account their ınformation to the accounts array. " name,userName,password "
                this.accounts[accountCount] = new Account();
                this.accounts[accountCount].setName(name);
                this.accounts[accountCount].setUserName(userName);
                this.accounts[accountCount].setPassword(password);
                this.accountCount++;
            } else {
                System.out.println(result);
                System.out.println("This username is taken " + userName);
            }
        } else {
            System.out.println("\nPassword does not contain both characters and digits and\n" +
                    "Password is not valid for " + userName);
        }
    }
        // Checking if the password is valid. To be valid,
        // the password must be longer than 6 and contain both characters and numbers.
    public boolean isPasswordValid(String password) {
        boolean hasLetter = false;
        boolean hasDigit = false;
        if (password.length()<6){
            System.out.println("Password length should be longer than 6 characters!");
            return false;
        }else {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    hasDigit = true;
                }
                if (Character.isLetter(password.charAt(i))) {
                    hasLetter = true;
                }
                if (hasDigit && hasLetter) {
                    return true;
                }
            }
        }
        return false;
    }

    // checks if this username has been taken before
    public boolean isUserNameExist(String userName) {
        for (int i = 0; i < this.accountCount; i++) {
            if (userName.equals(accounts[i].getUserName())) {
                return false;
            }
        }
        return true;
    }

    // this method is used to change the user's activity
    public static void changeStatusOfActiveness(Account account) {
        if (account.isActive()){
            account.setActive(false);
        }else {
            account.setActive(true);
        }
    }
    // This method returns how many user accounts there are in any social media account.
    // For example, there are 3 accounts in this question for facebook
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < accountCount; i++) {
            if (i == 0) {
                result.append(this.name + " has " + accountCount + " accounts which are:\n");
            }
            result.append(accounts[i].getUserName() + "\n");
        }
        return result.toString();
    }
}
