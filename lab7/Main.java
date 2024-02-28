import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class People {
    String FirstName, LastName, MiddleName, address, edu, DOB;
    People(String FirstName,String LastName, String MiddleName, String address, String edu, String DOB){
        this.FirstName = FirstName; // Ф
        this.LastName = LastName; // И
        this.MiddleName = MiddleName; // О
        this.address = address;
        this.edu = edu;
        this.DOB = DOB;
    }
    public static int calculateAge(String DOB) {
        return Year.now().getValue() - Integer.parseInt(DOB.substring(DOB.lastIndexOf("/") + 1));
    }
    public String getFirstName() {return FirstName;}
    public String getLastName() {return LastName;}
    public String getMiddleName() {return MiddleName;}
    public String getDOB() {return DOB;}
    public String getEdu() {return edu;}
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<People> Person = new ArrayList<>();
        int i = 0;
        for (;;)
        {
            System.out.printf("(0, что бы выйти) Введите имя %d человека: ", i + 1);
            String firstname = scanner.nextLine();
            if (firstname.equals("0"))
                break;
            System.out.printf("Введите фамилию %d человека: ", i + 1);
            String lastname = scanner.nextLine();
            System.out.printf("Введите отчество %d человека: ", i + 1);
            String middlename = scanner.nextLine();
            System.out.printf("Введите адрес %d человека: ", i + 1);
            String address = scanner.nextLine();
            System.out.printf("Введите уровень образования %d человека (Выш. или Сред.): ", i + 1);
            String edu = scanner.nextLine();
            System.out.printf("Введите дату рождения %d человека (в формате DD/MM/YYYY): ", i + 1);
            String DOB = scanner.nextLine();
            Person.add(new People(firstname,lastname,middlename,address,edu,DOB));
            i++;
        }
        System.out.println("Введите возраст, по этому возросту будет выводится люди старше этого возраста");
        int ageLimit = scanner.nextInt();
        System.out.println("Люди, с высшим образованием: \n");
        System.out.println("|Имя|\t|Фамилия|\t|Отчество|\t|Дата Рождения|\t|Образование|\n");
        for(int j = 0; j < i; j++) {
            if (Person.get(j).edu.matches("Выш.")) {
                System.out.println("|" + Person.get(j).getFirstName() + "|\t|" + Person.get(j).getLastName() + "|\t|" + Person.get(j).getMiddleName() + "|\t|" + Person.get(j).getDOB() + "|\t|"  + Person.get(j).getEdu() + "|\n");
            }
        }
        System.out.printf("Люди, с возрастом старше %d лет\n", ageLimit);
        System.out.println("|Имя|\t|Фамилия|\t|Отчество|\t|Дата Рождения|\t|Образование|\n");
        for(int j = 0; j < i; j++) {
            if (People.calculateAge(Person.get(j).getDOB()) > ageLimit) {
                System.out.println("|" + Person.get(j).getFirstName() + "|\t|" + Person.get(j).getLastName() + "|\t|" + Person.get(j).getMiddleName() + "|\t|" + Person.get(j).getDOB() + "|\t|" + Person.get(j).getEdu() + "|\n");
            }
        }

    }
}