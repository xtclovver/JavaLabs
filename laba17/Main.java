import java.io.*;
import java.util.Scanner;

class Piwo {
    double x, y;
    Piwo(double x) { this.x = x; this.y = calculateY(); }
    private double calculateY() { return x - Math.sin(x); }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(filename))) {
            wr.write("Исходное значение x: " + x);
            wr.newLine();
            wr.write("Результат y: " + y);
        }
        catch (Exception ex) { System.err.println("Не могу сохранить в файл" + ex.getMessage()); }
    }

    public void loadFromFile(String filename) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(filename))) {
            String line = r.readLine();
            if (line.startsWith("Исходное значение x: "))
                x = Double.parseDouble(line.substring(21));
            line = r.readLine();
            if (line.startsWith("Результат y: "))
                y = Double.parseDouble(line.substring(13));
        }
        catch (Exception ex) { System.err.println("Не могу прочитать файл" + ex.getMessage()); }
    }
}
    public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите значение x: ");
            double x = sc.nextDouble();
            Piwo piwo = new Piwo(x);
            System.out.println("y = " + piwo.y);

            while (true) {
                System.out.print("Введите команду (save, upload, exit): ");
                String command = sc.next();
                sc.nextLine();
                if (command.equals("exit")){
                    System.out.println("Пока");
                    return;}
                String filename = "result";
                System.out.print("Введите имя файла (Enter для result): ");
                String inputFilename = sc.nextLine();
                if (!inputFilename.isEmpty())
                    filename = inputFilename;
                switch (command) {
                    case "save":
                        try {
                            piwo.saveToFile(filename);
                            System.out.println("Данные успешно сохранены в файл " + filename);
                        } catch (IOException e) {
                            System.err.println("Ошибка сохранения: " + e.getMessage());
                        }
                        break;
                    case "upload":
                        try { piwo.loadFromFile(filename);
                            System.out.println("Данные успешно загружены из файла " + filename);
                            System.out.println("y = " + piwo.y);}
                        catch (IOException e) { System.err.println("Ошибка загрузки: " + e.getMessage()); }
                        break;
                    default:
                        System.out.println("Неизвестная команда.");
                }
            }
        }
    }