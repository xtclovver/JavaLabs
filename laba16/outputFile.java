import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
public class inputFile { 
    static void main(String[] args) {
            String input = "092.068.001.001 2001:0db8:85a3:0000:0000:8a2e:0370:7334 ::f 127.0.0.1 192.168.1.0";

            String regexIPv4 = "((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}";
            String regexIPv6 = "(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))";

            Pattern patternIPv4 = Pattern.compile(regexIPv4); 
            Matcher matcherIPv4 = patternIPv4.matcher(input); 

            Pattern patternIPv6 = Pattern.compile(regexIPv6);
            Matcher matcherIPv6 = patternIPv6.matcher(input); 


            try {
                FileWriter writer = new FileWriter("Validip.txt");
                while (matcherIPv4.find()) { 
                    writer.write("IPv4: " + matcherIPv4.group() + "\n");
                }
                while (matcherIPv6.find()) { 
                    writer.write("IPv6: " + matcherIPv6.group() + "\n");
                }
                writer.close(); 
            } catch (IOException e) { 
                e.printStackTrace();
            }
        }
    }
}

