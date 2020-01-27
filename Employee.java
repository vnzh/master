

//Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
//        Конструктор класса должен заполнять эти поля при создании объекта;
//        Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
//        Вывести при помощи методов из пункта 3 ФИО и должность.
//        Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
//        * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
//        * Средние арифметические возраста и зарплаты
//        *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный идентификационный порядковый номер




import java.util.Calendar;

public class Employee {
     private static int  ID = 0;

    private  String Name;
    private  String Surname;
    private String position;
    private String telefone;    //в   принципе,  телефон может быть  и int
    private double salary;

    private int birthYear;
    private int id;
//*** Продумать конструктор таким образом, чтобы при создании каждому сотруднику
// присваивался личный уникальный идентификационный порядковый номер
    public Employee() {
        id = ++ID;
    }

    public Employee(int age) {
        this();
        this.birthYear =Calendar.YEAR - age;
    }

    public Employee(String name, String surname, String position, String telefone, double salary, int age) {
        this(age);
        this.Name = name;
        this.Surname = surname;
        this.position = position;
        this.telefone = telefone;
        this.salary = salary;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPosition() {
        return position;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return Calendar.YEAR - birthYear;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Работник " +  Name + " " + Surname + " " + " должность " + position + " телефон " + telefone +
                " salary " + salary + " возраст " + getAge();
    }

   public static  double  averageSalary(Employee[] emp) {
        double res = emp[0].getSalary();
        for (int i = 1; i < emp.length; i++) {
            res = res + emp[i].getSalary();
        }
        return res/emp.length;
    }//avarageSalary

    public static double averageAge (Employee[] emp) {
        double res = emp[0].getAge();
        for (int i = 1; i < emp.length; i++) {
            res = res + emp[i].getAge();
        }
        return res/emp.length;
    }//avarage


}//Employee
