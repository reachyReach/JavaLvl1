package lesson6;
//     1. Создать классы Собака и Кот с наследованием от класса Животное.
public class animal {
//    2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
//    В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
//    или высоту (для прыжков).

    String name;
    int maxRun;
    int maxSwim;
    double maxJump;

    public animal(String name, int maxRun, int maxSwim, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
    }

//      4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
// (Например, dog1.run(150); -> результат: run: true)

    public void run(int runDist) {
        if (runDist > 0 && runDist <= maxRun) {
            System.out.println(name + " пробежал(а) " + runDist + "м.");
        } else {
            System.out.println(name + " не может пробежать " + runDist + "м.");}

    }

    public void swim(int swimDist) {
        if (maxSwim == 0) {
            System.out.println(name + " плавать не умеет.");
            return;
        }
        if (swimDist > 0 && swimDist <= maxSwim){
            System.out.println(name + " проплыл(а) " + swimDist + "м.");
        }
        else {System.out.println(name + " не может проплыть " + swimDist + "м.");}

    }

    public void jump(double jumpHeight) {
        if (jumpHeight >= 0 && jumpHeight <= maxJump) {
            System.out.println(name + " подпрыгнул(а) на " + jumpHeight + "м.");
        }
        else {
            System.out.println(name + " не может подпрыгнуть на " + jumpHeight + "м.");
        }
    }

//    5. * Добавить животным разброс в ограничениях.
//    То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
//    Увидел Ваш вариант и вариант Веры по решению 5го пункта. Копировать не стал(не честно), а на разработку своего варианта времени к сожалению нет.

}
