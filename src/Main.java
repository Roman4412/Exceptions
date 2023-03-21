import java.util.Scanner;

public class Main {
    static String login;
    static String password;
    static String confirmPassword;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        login = scanner.nextLine();
        password = scanner.nextLine();
        confirmPassword = scanner.nextLine();
        System.out.println(registrationIsCorrect(login, password, confirmPassword));
        System.out.println("Work");
    }

    public static boolean registrationIsCorrect(String login, String password, String confirmPassword) {
        try {
            loginIsCorrect(login);
            passwordIsCorrect(password);
            confirmPasswordIsCorrect(password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException l) {
            l.printStackTrace();
            System.out.println(l.getMessage());
            return false;
        }
    }

    public static boolean loginIsCorrect(String login) throws  WrongLoginException {
       if  (login.length() <= 20) return true;
       else throw new WrongLoginException();
    }
    public static boolean passwordIsCorrect(String password) throws WrongPasswordException {
        if  (password.length() <= 20) return true;
        else throw new WrongPasswordException();
    }

    public static boolean confirmPasswordIsCorrect(String password, String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword)) return true;
        else throw new WrongPasswordException();
    }
}
