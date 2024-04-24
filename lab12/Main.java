interface User {
    String getLogin ();
    void setLogin (String login);
    String getPassword ();
    void setPassword (String pass);
}
abstract class People implements User {
    String FullName, job, login, password;
    int age;
    People (String FullName, String job, int age)
    {
        this.FullName = FullName;
        this.age = age;
        this.job = job;
    }
}
class Student extends People {
    Student (String FullName, String job, int age) { super(FullName, job, age); }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String pass) { this.password = pass; }
}
class Teacher extends People {
    Teacher (String FullName, String job, int age) { super(FullName, job, age); }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String pass) { this.password = pass; }
}
public class Main {
    public static void main(String[] args) {
    Teacher Alexander = new Teacher("Puzrenkov Alexander Nikolaevich", "Java teacher", 36);
    Teacher Maxim = new Teacher("Kholuev Maxim  Alexandrovich", "C#/Assembler teacher", 41);
    Student Stepan = new Student("Fetisov Stepan Olegovich", "Student", 17);
    Student Leha = new Student("Nikulkin Alexsey Vladimirovich", "Student", 17);
    Alexander.setLogin("admin");
    Alexander.setPassword("admin");
    System.out.printf(" %s login: %s \n %s password: %s", Alexander.FullName, Alexander.getLogin(), Alexander.FullName, Alexander.getPassword());
    }
}