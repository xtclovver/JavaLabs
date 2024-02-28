import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        double x, sum = 0;
        Scanner scanner = new Scanner(System.in);
       do {
           System.out.print("Введите аргумент x (|x| ≤ 1) = ");
           x = Math.abs(scanner.nextDouble());
       } while (Math.abs(x) > 1);
        System.out.print("Введите аргумент n = ");
        n = scanner.nextInt();
        for (double i = 0; i < n; i++)
            sum += Math.pow(-1, i + 1) * (Math.pow(x, 2 * i + 1)) / (2 * i + 1);
        System.out.printf("arcctg x = %f", sum + Math.PI / 2);
    }
}
