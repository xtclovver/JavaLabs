// Строка в которой любое кол-во чисел. Нужно найти все двузначные и трехзначные числа. Регулярные выражения
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Reader {
    int libraryCardNum = 1, phoneNumber;
    String FullName,faculty, DOB;
    Reader(String FullName, int libraryCardNum, String faculty, String DOB, int phoneNumber) {
        this.FullName = FullName;
        this.libraryCardNum = libraryCardNum;
        this.faculty = faculty;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
    }
    Reader(String FullName) {
        this.FullName = FullName;}
    void takeBook (int n) {
        System.out.printf("%s взял %d книг(и)!", FullName, n);
    }
    void takeBook (String[] booksName) {
        System.out.printf("%s взял %s книги!", FullName, Arrays.toString(booksName));
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Reader> Persons = new ArrayList<>();
        for (int i = 0; true; i++)
        {
            System.out.printf("(0, что бы выйти) Введите имя %d человека: ", i + 1);
            String name = scanner.nextLine();
            if (name.equals("0"))
                break;
            else
                Persons.add(new Reader(name));
        }
        System.out.println("Выберете человека: ");
        int j = scanner.nextInt() - 1;
        System.out.printf("Сколько книг взять %s? \n %s Должен взять: ", Persons.get(j).FullName, Persons.get(j).FullName);
        int n = scanner.nextInt();
        Persons.get(j).takeBook(n);
        String[] books = new String[n];
        Scanner scanner2 = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf("\nВведите %d книгу из %d: ", i, n);
            books[i] = scanner2.nextLine(); }
        Persons.get(j).takeBook(books);
    }
}