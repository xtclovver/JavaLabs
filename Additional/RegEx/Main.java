import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([1-9]|[1-9][0-9]|100)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("Найдено числа: " + matcher.group());
            boolean isValid = input.matches("([1-9]|[1-9][0-9]|100)"); // Проверка на соответствие регулярному выражению
            System.out.println(!isValid); // Выводим результат проверки
        }
    }
}
// от 0 до 100 = false
// от 101 до inf = true