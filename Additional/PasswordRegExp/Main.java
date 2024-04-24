import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите пароль:");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        Pattern p = Pattern.compile("((?:\\D*\\d{1,})(?:\\D*\\d{1,})(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])).{8,}");
        Matcher m = p.matcher(password);
        String s = m.matches() ? "Пароль сильный" : "Пароль слабый";
        System.out.println(s);
    }
}