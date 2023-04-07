import java.util.concurrent.TransferQueue;

public class SocialNetwork {
    private String name;
    Account[] accounts;
    int accountCount = 0;


    public SocialNetwork(String name) {
        this.accounts = new Account[100];
        this.name = name;
    }

    public void createAccount(String name, String userName, String password) {
        String result = "";
        if (isPasswordValid(password)) {
            result += "\nPassword is valid ";
            if (isUserNameExist(userName)) {
                result += "for " + userName;

                this.accounts[accountCount] = new Account();
                accounts[accountCount].setName(name);
                accounts[accountCount].setUserName(userName);
                accounts[accountCount].setPassword(password);
                accountCount++;
                System.out.println(result);

            } else {
                System.out.println(result);
                System.out.println("This username is taken " + userName);
            }
        } else {
            System.out.println("\nPassword does not contain both characters and digits and\n" +
                    "Password is not valid for " + userName);
        }
    }

    public boolean isPasswordValid(String password) {
        boolean hasLetter = false;
        boolean hasDigit = false;
        if (password.length()<6){
            System.out.println("Password length should be longer than 6 characters!");
            return false;
        }
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
        return false;
    }

    public boolean isUserNameExist(String userName) {
        for (int i = 0; i < this.accountCount; i++) {
            if (userName.equals(accounts[i].getUserName())) {
                return false;
            }
        }
        return true;
    }

    public static void changeStatusOfActiveness(Account account) {
        if (account.isActive()){
            account.setActive(false);
        }else {
            account.setActive(true);
        }
    }

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
