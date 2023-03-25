import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String login;
    static String password;
    static String confirmPassword;
    final static String PATTERN = "[A-z0-9_-]{1,20}";
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
    // 1234567890_asdfghjKG
    public static boolean loginIsCorrect(String login) throws  WrongLoginException {
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(login);
       if  (m.matches()) return true;
       else throw new WrongLoginException();
    }
    public static boolean passwordIsCorrect(String password) throws WrongPasswordException {
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(password);
        if  (m.matches()) return true;
        else throw new WrongPasswordException();
    }

    public static boolean confirmPasswordIsCorrect(String password, String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword)) return true;
        else throw new WrongPasswordException();
    }
}
