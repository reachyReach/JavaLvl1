package lesson7;

import java.util.Random;

//      1. Расширить задачу про котов и тарелки с едой
public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public int getFood() {
        return food;
    }

//    2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
//    (например, в миске 10 еды, а кот пытается покушать 15-20)

    public void decreaseFood(int foodVolume) {
        if ( food - foodVolume < 0){
            System.out.println("Too few food in plate.");
        } else {
        food -= foodVolume;}
    }
// 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void increaseFood(int amount) {
        food += amount;
        System.out.println(food);}



}
