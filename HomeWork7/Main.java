package lesson7;


public class Main {


    public static void main(String[] args) {
//        5. Создать массив котов и тарелку с едой,
//        попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
        Cats cat[] = {
                new Cats("Barsik"),
                new Cats("Pashka"),
                new Cats("Mefik"),
                new Cats("Nils")};

        Plate plate = new Plate(300);

        System.out.println(plate);

        for (int i = 0; i < cat.length; i++) {
            int foodVolume = (int) (Math.random() * 70);

            cat[i].eat(plate, foodVolume);

        }
        for (int i = 0; i < cat.length; i++) {
            System.out.println(cat[i].name + " satiety level:" + cat[i].satiety);

        }
        System.out.println(plate);

//        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
        plate.increaseFood(300);
        System.out.println(plate);


    }
}
