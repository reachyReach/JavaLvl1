package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Pasha");
        Dog dog1 = new Dog("Kabul");


        cat1.run(300);
        cat1.run(150);
        cat1.swim(1);
        cat1.swim(0);
        cat1.jump(5);
        cat1.jump(2);
        dog1.run(600);
        dog1.run(400);
        dog1.swim(15);
        dog1.swim(8);
        dog1.jump(2);
        dog1.jump(.3);


    }


}
