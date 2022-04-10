package ru.bulash;

import ru.bulash.animals.*;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[10];    // Далее подсчитаем количество реально созданных животных, не просто длину массива
        Cat cat = new Cat("Барсик");
        cat.run(100);
        cat.swim(50);
        animals[0] = cat;

        animals[1] = new Cat("Маруся");
        animals[1].run(300);    // Здесь будет отсечка = превышение максимума
        animals[1].swim(20);
        animals[2] = new Cat("Петрович");
        animals[2].run(50);
        animals[2].swim(30);
        animals[3] = new Cat("Василий");
        animals[3].run(83);
        animals[3].swim(22);

        System.out.println();

        int[] count = new int[2];    // Количество котов и вообще животных
        for (Animal animal : animals) {
            if(animal != null) {	// Без этого животных будет 10, что неверно
                count[1]++;
            }
            if (animal instanceof Cat) {
                count[0]++;
            }
        }

        System.out.printf(
                """
                        Всего животных:
                        \t- Котов: %d
                        \t- Всего: %d""",
                count[0], count[1]);
    }
}
