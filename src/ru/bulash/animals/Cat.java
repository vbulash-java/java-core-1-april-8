package ru.bulash.animals;

/*
1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */
public class Cat extends Animal {
	protected final int maxRun = 200;
	protected final int maxSwim = 0;

	public boolean satied = false;
	private int stomachVolume = 0;
	public static Plate plate = null;

	public Cat(String name, int stomachVolume) {
		super(name);
		this.stomachVolume = stomachVolume;
	}

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

	// +Еда
	public static void setPlate(Plate plate) { Cat.plate = plate; }

	public boolean eat() {
		if(this.satied) {
			System.out.printf("%s сыт(а), можно не кормить\n", this.getName());
		} else {
			this.satied = plate.eatFrom(this.stomachVolume);
			if(this.satied) {
				System.out.printf("%s наелся / наелась\n", this.getName());
			} else {
				System.out.printf("Для %s не хватило еды :-(\n", this.getName());
			}
		}
		return this.satied;
	}
}
