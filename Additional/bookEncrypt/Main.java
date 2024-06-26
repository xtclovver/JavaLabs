import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BookCipher {
    private final Map<Character, String> charToCoords = new HashMap<>();
    private final Map<String, Character> coordsToChar = new HashMap<>();
    public BookCipher(String keyFilePath) throws Exception { loadKey(keyFilePath);}
    private void loadKey(String keyFilePath) throws Exception {
        try (BufferedReader rd = new BufferedReader(new FileReader(keyFilePath))) {
            int stanza = 1;
            int line = 1;
            for (String stanzaText : rd.lines().toArray(String[]::new)) {
                for (String lineText : stanzaText.split(";")) {
                    for (int i = 0; i < lineText.length(); i++) {
                        char ch = lineText.charAt(i);
                        if (Character.isLetter(ch)) {
                            String coords = String.format("%d-%d-%d", stanza, line, i + 1);
                            charToCoords.put(Character.toLowerCase(ch), coords);
                            coordsToChar.put(coords, Character.toLowerCase(ch));
                        }
                    }
                    line++;
                }
                stanza++;
            }
        } catch (Exception ex) {System.err.println("Не удалось загрузить ключ" + ex.getMessage()); }
    }

    public String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (charToCoords.containsKey(Character.toLowerCase(ch)))
                encryptedText.append(charToCoords.get(Character.toLowerCase(ch))).append(" ");
            else
                encryptedText.append(ch);
        }
        return encryptedText.toString().trim();
    }

    public String decrypt(String encryptedText) {
        StringBuilder decryptedText = new StringBuilder();
        for (String coords : encryptedText.split(" ")) {
            if (coordsToChar.containsKey(coords))
                decryptedText.append(coordsToChar.get(coords));
            else
                decryptedText.append(coords);
        }
        return decryptedText.toString();
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String keyFilePath = "key.txt";
        BookCipher key = new BookCipher(keyFilePath);
        System.out.print("Введите текст для шифрования: ");
        String text = sc.nextLine();
        String encryptedText = key.encrypt(text);
        System.out.println("Зашифрованный текст: " + encryptedText);
        String decryptedText = key.decrypt(encryptedText);
        System.out.println("Расшифрованный текст: " + decryptedText);
    }
}
