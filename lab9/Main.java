import java.util.Scanner;

class Human {
    private String FullName, address, course, edu, phoneNum, admissionDate;
    Human(String FullName, String address, String course, String edu, String phoneNum, String admissionDate) {
        this.FullName = FullName;
        this.address = address;
        this.course = course;
        this.edu = edu;
        this.phoneNum = phoneNum;
        this.admissionDate = admissionDate;
    }
    public String getFullName() { return FullName; }
    public void setFullName(String fullName) { FullName = fullName; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }
    public String getAddress() { return address; }
    public String getPhoneNum() { return phoneNum; }
    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }
    public void setCourse(String course) { this.course = course; }
    public String getEdu() { return edu; }
    public String getAdmissionDate() { return admissionDate; }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Human[] Student = new Human[3];
        Student[0] = new Human("Artem", "St. Pushkina 43", "2", "IT", "+79934638412","01/09/2020" );
        Student[1] = new Human("Pasha", "St. Pushkina 42", "3", "IT", "+79544816212","01/09/2019" );
        Student[2] = new Human("Nikita", "St. Pushkina 45", "4", "PT", "+79835463412","01/09/2018" );
        System.out.println("Фио всех стундентов: \n");
        for (int i = 0; i < 3; i++)
            System.out.printf("Имя %d стундента: %s\n", i + 1, Student[i].getFullName());
        System.out.println("Введите факультет (IT или PT): ");
        String input = sc.nextLine();
        System.out.printf("Список студентов %s отделения:\n", input);
        for (int i = 0; i < 3; i++)
            if (Student[i].getEdu().equals(input))
                System.out.printf("Имя стундента: %s\n", Student[i].getFullName());
        System.out.println("Введите год поступления:\n");
        int date = sc.nextInt();
        for (int i = 0; i < 3; i++)
            if (Integer.parseInt(Student[i].getAdmissionDate().substring(Student[i].getAdmissionDate().lastIndexOf("/") + 1)) > date)
                System.out.printf("Имя стундента: %s\n", Student[i].getFullName());
    }
}