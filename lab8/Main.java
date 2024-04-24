class Human {
    String FirstName, LastName, DOB;
    Human (String FirstName, String LastName, String DOB) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DOB = DOB;
    }
    public void displayInfo() {
        System.out.println(FirstName + "\t" + LastName + "\t" + DOB);
    }
}
class Auto {
    String Model, Date, motorValue;
    Auto (String Model, String Date, String motorValue) {
        this.Date = Date;
        this.Model = Model;
        this.motorValue = motorValue;
    }
    public void displayInfo() {
        System.out.println(Model + "\t" + Date + "\t" + motorValue);
    }
}
class Book {
    String Name, Author, Date;
    Book (String Name, String Author, String Date) {
        this.Date = Date;
        this.Author = Author;
        this.Name = Name;
    }
    public void displayInfo(){
        System.out.println(Name + "\t" + Author + "\t" + Date);
    }
    public void readBook (Human human, Auto auto){
        System.out.printf("%s читает книгу %s про машину %s", human.FirstName, Name, auto.Model);
    }
}
public class Main {
    public static void main(String[] args) {
        Human Artem = new Human("Артём", "Каркаров", "01/02/2005");
        Auto Audi = new Auto("Audi RX", "02/10/2020", "2");
        Book AutoLife = new Book("Резюме машин компании Audi за последние 5 лет", "Audi", "01/12/2025");
        AutoLife.readBook(Artem, Audi);
    }
}