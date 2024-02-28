import java.util.Scanner;
class MyMath {
    double a;
    double b;
    double x;
    public MyMath(double a, double b, double x)
    {
        this.a = a;
        this.b = b;
        this.x = x;
    }
    public MyMath(double a, double b)
    {
        this.a = a;
        this.b = b;
    }
    public MyMath(double x)
    {
        this.x = x;
    }
    public static double plus(double x)
    {
        return 3 * x + 5;
    }
    public static double divide(double a, double b)
    {
        return (a + b) / (a - b);
    }
    public static int factorial(int a, int b, int x)
    {
        int temp = a * x / b;
        int temp2 = 1;
        for (int i = 1; i <= temp; i++)
        {
            temp2 *= i;
        }
        return temp2;
    }
    public double getA()
    {
        return a;
    }
    public double getB()
    {
        return b;
    }
    public double getX()
    {
        return x;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите a:");
        double a = scanner.nextDouble();
        System.out.println("Введите b:");
        double b = scanner.nextDouble();
        System.out.println("Введите x:");
        double x = scanner.nextDouble();
        MyMath test = new MyMath(a,b,x);
        MyMath test2 = new MyMath(a,b);
        MyMath test3 = new MyMath(x);
        System.out.printf("y = 3 * %f + 5 \t\t y = %f\n", test3.getX(), MyMath.plus(test3.getX()));
        if (test2.getA() - test2.getB() == 0) { System.out.printf("y = (%f + %f) / (%f - %f) \t\t Деление на ноль невозможно\n", test2.getA(),test2.getB(),test2.getA(),test2.getB());}
        else { System.out.printf("y = (%f + %f) / (%f - %f) \t\t y = %f\n", test2.getA(),test2.getB(),test2.getA(),test2.getB(), MyMath.divide(test2.getA(), test2.getB())); }
        if (test.getB() == 0) { System.out.printf("y = (%d * %d / %d)! \t\t Деление на ноль невозможно\n", (int)test.getA(),(int)test.getX(),(int)test.getB());}
        else { System.out.printf("y = (%d * %d / %d)! \t\t y = %d\n", (int)test.getA(),(int)test.getX(),(int)test.getB(), MyMath.factorial((int)test.getA(), (int)test.getB(), (int)test.getX())); }
    }
}