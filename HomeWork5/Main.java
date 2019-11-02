package lesson5;

public class Main {
    public static void main(String[] args) {

        //       * Создать массив из 5 сотрудников
//
//Пример:
//Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//persArray[1] = new Person(...);
//...
//persArray[4] = new Person(...);
        int size = 5;
        employee[] employeesArray = new employee[size];
        employeesArray[0] = new employee("Ekizyan Artem", "CEO", "a.ekizyan@icloud.com", 89081883100L, 60000, 31);
        employeesArray[1] = new employee("Lihovtsev Roman", "manager", "r.lihovcev@icloud.com", 89505322228L,50000, 43);
        employeesArray[2] = new employee("Gorbatenko Alexander", "senior electrition", "a.gorbatenko@icloud.com", 89505355558L,40000, 45);
        employeesArray[3] = new employee("Gorbatenko Sergey", "electrition", "s.gorbatenko@icloud.com", 89505366668L,35000, 42);
        employeesArray[4] = new employee("Kunik Evgeniy", "junior electrition", "e.kunik@icloud.com", 89505377778L,25000, 23);

        employeesArray[0].info();
        employeesArray[1].info();
        employeesArray[2].info();
        employeesArray[3].info();
        employeesArray[4].info();

//        * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println();
        System.out.println();
        System.out.println("Вывод информации о сотрудниках старше 40лет");

        for (int i = 0; i < size; i++) {
            if(employeesArray[i].getAge() >= 40){
                employeesArray[i].info();
            }

        }

    }
}
