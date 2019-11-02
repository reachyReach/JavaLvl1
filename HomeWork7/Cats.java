package lesson7;




//      1. Расширить задачу про котов и тарелки с едой
public class Cats {
    String name;
//    3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
//    Если коту удалось покушать (хватило еды), сытость = true
    int satiety = 0;

    public Cats(String name)
    {
        this.name = name;
    }



    public void eat(Plate plate, int foodVolume){
//       4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает,
//       то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
       if(plate.getFood() < foodVolume){
           System.out.println("Too little food in plate.");
           return;
       }
        System.out.println(name +" eat");
        plate.decreaseFood(foodVolume);
//        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
//        Если коту удалось покушать (хватило еды), сытость = true
    satiety += foodVolume;
        if (satiety == 0){
            System.out.println(name + " is hungry.");
        } if (satiety < 50 && satiety > 0){
            System.out.println(name + " still hungry.");
        } if (satiety >= 50){
            System.out.println(name + " is full.");
        }
    }



}
