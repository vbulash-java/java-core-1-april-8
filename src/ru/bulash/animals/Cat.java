package ru.bulash.animals;

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.
 */
public class Cat extends Animal {
	protected final int maxRun = 200;
	protected final int maxSwim = 0;

	public Cat(String name) { super(name); }

	@Override
	public int getMaxRun() {
		return maxRun;
	}

	@Override
	public int getMaxSwim() {
		return maxSwim;
	}

	@Override
	public void swim(int distance) {
		System.out.println("Коты не умеют плавать!");
	}
}
