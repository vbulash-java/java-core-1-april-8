package ru.bulash;

import ru.bulash.animals.*;

/*
1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[10];    // Далее подсчитаем количество реально созданных животных, не просто длину массива

        Cat.setPlate(new Plate(1000));  // Одна тарелка на всех котов с 1 килограммом еды

        Cat cat = new Cat("Барсик", 200);
//        cat.run(100);
//        cat.swim(50);
        animals[0] = cat;

        cat = new Cat("Маруся", 200);
//        cat.run(300);    // Здесь будет отсечка = превышение максимума
//        cat.swim(20);
        animals[1] = cat;

        cat = new Cat("Петрович", 700);
//        cat.run(50);
//        cat.swim(30);
        animals[2] = cat;

        cat = new Cat("Василий", 2800);
//        cat.run(83);
//        cat.swim(22);
        animals[3] = cat;

        System.out.println();

        System.out.println("Кормим котов:");
        boolean satied = true;
//        int[] count = new int[2];    // Количество котов и вообще животных
        for (Animal animal : animals) {
            if(animal != null) {	// Без этого животных будет 10, что неверно
//                count[1]++;
            }
            if (animal instanceof Cat) {
//                count[0]++;
                satied = ((Cat) animal).eat() && satied;
            }
        }

//        System.out.printf(
//                """
//                        Всего животных:
//                        \t- Котов: %d
//                        \t- Всего: %d\n\n""",
//                count[0], count[1]);

        System.out.println();
        if(!satied) {   // Кто-то из котов не наелся, пробуем заново покормить всех
            System.out.println("Не все коты наелись, пробуем дать им еще еды:");
            Cat.plate.addFood(1000);    // Добавим еще еды в тарелку
            // Снова попробуем покормить всех котов
            satied = true;
            for (Animal animal : animals) {
                if (animal instanceof Cat) {
                    satied = ((Cat) animal).eat() && satied;
                }
            }
        }

        System.out.println();
        if(satied) {
            System.out.println("Наконец-то накормили всех котов!");
        } else {
            System.out.println("Ненасытные твари, всё равно хотят жрать!");
        }

        System.out.println("\nВ итоге:");
        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                cat = (Cat) animal;
                System.out.printf("%s %s\n", cat.getName(), cat.satied ? "сыт(а)" : "голоден (голодна)");
            }
        }
    }
}
