import static java.sql.Types.NULL;
interface Product { void setName(String name); String getName();
    void setRate(int rate); int getRate();
    void setCost(int cost); int getCost(); }
abstract class Products implements Product {
    String name; int rate, cost;
    Products(String name, int cost, int rate){ this.name = name; this.cost = cost; this.rate = rate; }
    public void setName(String name) { this.name = name; } public String getName() { return name; }
    public void setRate(int rate) { this.rate = rate; } public int getRate() { return rate; }
    public void setCost(int cost) { this.cost = cost; } public int getCost() { return cost; }
}
interface User { String getLogin(); void setLogin(String login);
    String getPassword(); void setPassword(String pass); }
abstract class AbUsers implements User {
    String FullName, job, login, password; int age;
    AbUsers(String FullName, String job, int age) { this.FullName = FullName; this.age = age; this.job = job; }
    public String getLogin() { return login; } public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; } public void setPassword(String pass) { this.password = pass; }
    public void buyProduct (Products pd){ System.out.printf("%s покупает %s!", this.FullName, pd.getName()); }
}
class Admin extends AbUsers { Admin(String FullName, String job, int age) { super(FullName, job, age); } }
class Users extends AbUsers { Users(String FullName, String job, int age) { super(FullName, job, age); } }
class Accouting extends AbUsers { Accouting(String FullName, String job, int age) { super(FullName, job, age); } }
// products //
class Owoce extends Products { Owoce(String name, int cost, int rate) { super(name, cost, rate); } }
class Suxariki extends Products { Suxariki(String name, int cost, int rate) { super(name, cost, rate); } }
class Dywan extends Products { Dywan(String name, int cost, int rate) { super(name, cost, rate); } }
public class Main {
    public static void main(String[] args) {
        Owoce Ananas = new Owoce("Ананас", 14, 4);
        Dywan Babushkin = new Dywan("бабушкин", 44, 5);
        Suxariki Kirieshki = new Suxariki("Кириешки", 8, 4);
        Accouting Elena = new Accouting("Елена Царевна", "Бухгалтер", 45);
        Admin admin = new Admin("admin", "admin", NULL);
        Users Max = new Users("Макс Максбетов", "Покупатель", 30);
        Max.buyProduct(Ananas);
    }
}