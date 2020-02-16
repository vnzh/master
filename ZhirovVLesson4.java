

//Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
//        Конструктор класса должен заполнять эти поля при создании объекта;
//        Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
//        Вывести при помощи методов из пункта 3 ФИО и должность.
//        Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
//        * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
//        * Средние арифметические возраста и зарплаты
//        *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный идентификационный порядковый номер

public class ZhirovVLesson4 {
        static Employee[] employees;
    public static void main(String[] args) {
//        Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        employees = new Employee[5];
        employees[0] = new Employee("Tanya", "Kasatonova" , "operator  naliva",
                "+7922", 20000.5,31);
        employees[1] = new Employee("Petr", "Ivanov", "operator naliva",
                "+75246", 20000.5, 25);
        employees[2] = new Employee("Kirill", "Petrov", "master uchastka",
                "+96523", 25000, 48);
        employees[3]  = new Employee("Ivan", "Bodrov", "operator tovarniy",
                "+79052314", 20000.5,50);
        employees[4] = new Employee("Elvira", "Demaeva", "operator tovarniy",
                "+736214", 20000.5, 47);
//         С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) System.out.println(employees[i].toString());
        }

        //Вывести при помощи методов из пункта 3 ФИО и должность.
        for (int i = 1; i < 4; i++) {
//            System.out.println(employees[i].getId() +  "  " + Employee.ID + "Работник  " +  employees[i].getName() + " " + employees[i].getSurname()
//                    + " " + " должность  " + employees[i].getPosition());
             System.out.println("Работник  " +  employees[i].getName() + " " + employees[i].getSurname()
                    + " " + " должность  " + employees[i].getPosition());
        }
        //        * Средние арифметические возраста и зарплаты
        System.out.println("Средняя заплата =   " + Employee.averageSalary(employees));
        System.out.println("Средний возраст =   " + Employee.averageAge(employees));

        salaryUp(45, 5000);
        System.out.println(employees[4].toString());
    }//main

    //* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    static void salaryUp(int age, double up){
        for (int i = 0; i <employees.length ; i++) {
            if (employees[i].getAge() > 45 ) {
                employees[i].setSalary(employees[i].getSalary() + up);
            }
        }
    }//salaryUp

//    static double averageSalary(Employee[] emp) {
//        double res = emp[0].getSalary();
//        for (int i = 1; i < emp.length; i++) {
//            res = res + emp[i].getSalary();
//        }
//        return res/emp.length;
//    }//avarageSalary

//    static double averageAge (Employee[] emp) {
//        double res = emp[0].getAge();
//        for (int i = 1; i < emp.length; i++) {
//            res = res + emp[i].getAge();
//        }
//        return res/emp.length;
//    }//avarage

//        * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.

}//ZhirovVLesson4
