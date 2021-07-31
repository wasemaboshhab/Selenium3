import java.util.Scanner;

public class Account {
    private String username;
    private String userPassword;

    public void initUsernameAndPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("username:\n> ");
        setUsername(scanner.next());
        System.out.print("Password:\n> ");
        setUserPassword(scanner.next());
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
