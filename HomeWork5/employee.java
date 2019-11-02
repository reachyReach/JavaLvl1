package lesson5;
// * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
public class employee {
    private String fullName;
    private String position;
    private String eMail;
    private long phoneNumber;
    private int salary;
    private int age;
// * Конструктор класса должен заполнять эти поля при создании объекта;
    public employee(String fullName, String position, String eMail, long phoneNumber, int salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
//   * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void info() {
        System.out.println(fullName + "\t\t" + position + "\t\t" + eMail + "\t\t" + phoneNumber + "\t\t" + salary + "\t\t" + age);
    }

    public int getAge(){
        return age;
    }
}
