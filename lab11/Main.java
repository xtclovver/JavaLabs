class Person {
    private int age;
    public String fullName, phoneNumber;
    int getAge()
    {
        return age;
    }
    Person (int age, String Name, String pNumber)
    {
        this.age = age;
        this.fullName = Name;
        this.phoneNumber = pNumber;
    }
}

class Student extends Person {
    public int course;
    public String faculty;
    private String enrollmentDate;

    Student(int age, String fullName, String phoneNumber, int course, String faculty, String enrollmentDate) {
        super(age, fullName, phoneNumber);
        this.course = course;
        this.faculty = faculty;
        this.enrollmentDate = enrollmentDate;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }
}

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        // Инициализация объектов класса Student
        students[0] = new Student(20, "Иванов Иван Иванович","+7 (999) 123-4567", 2, "Информационные технологии", "01.09.2020");
        students[1] = new Student(21, "Петров Петр Петрович", "+7 (999) 765-4321", 3, "Экономика", "01.09.2019");
        students[2] = new Student(19, "Сидорова Анна Ивановна", "+7 (999) 246-1357", 1, "Медицина", "01.09.2021");


        // Вывод информации о студентах
        System.out.println("Информация о студентах:");
        for (Student student : students) {
            System.out.println("ФИО: " + student.fullName + ", Возраст: " + student.getAge());
        }

        // Вывод студентов заданного факультета
        String targetFaculty = "Информационные технологии";
        System.out.println("\nСтуденты факультета " + targetFaculty + ":");
        for (Student student : students) {
            if (student.faculty.equals(targetFaculty)) {
                System.out.println("ФИО: " + student.fullName);
            }
        }

        // Вывод студентов, поступивших после заданного года
        String targetYear = "2020";
        System.out.println("\nСтуденты, поступившие после " + targetYear + " года:");
        for (Student student : students) {
            if (Integer.parseInt(student.getEnrollmentDate().substring(6)) > Integer.parseInt(targetYear)) {
                System.out.println("ФИО: " + student.fullName);
            }
        }
    }
}
