//Дан файл с програмным кодом, содержащие комментарии - одностррочные и многострочные. Необходимо програмно удалить коментариии переписать програмный код в другой файл
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("inputFile.java"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("outputFile.java"))) {
            String line;
            boolean inComment = false;
            while ((line = reader.readLine()) != null) {
                if (!inComment) {
                    line = line.replaceAll("//.*|/\\*(.|\\R)*?\\*/", "");
                    if (line.contains("/*")) {
                        inComment = true;
                        line = line.replaceAll("/\\*.*", ""); } }
                else {
                    if (line.contains("*/")) {
                        inComment = false;
                        line = line.replaceFirst(".*\\*/", ""); }
                    else
                        continue;
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}