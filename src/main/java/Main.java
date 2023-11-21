/*
    Введение в коллекции данных в Java.

    Необходимо описать класс зоопарк. Предполагается, что в зоопарке расположено произвольное
    число клеток. В зоопарке клетки могут докупаться. Каждая клетка может быть пустой или
    содержать не более четырех животных. При попытке посадить в клетку с животным новое животное
    должна возникать исключительная ситуация, если в клетке был хищник другого класса.
    Каждое животное может быть либо хищником, либо травоядным. У каждого животного можно
    узнать имя, тип животного, класс животного, а так же услышать голос. При прогулке
    по зоопарку посетитель должен услышать голоса всех животных зоопарка или понять, что некоторые
    из клеток пустые.
    Зоопарк должен позволять выполнять следующие операции:
    1. Отображать все клетки в зоопарке. При наличии животного в клетке, животное подает голос.
    2. Выводить информацию о том, какие уникальные типы животных живут в зоопарке.
    3. Узнавать количество хищников и травоядных в зоопарке.
    4. Вывести всех уникальных животных в порядке уменьшения численности.
*/

public class Main {
    public static void main(String[] args) {
        Predator tiger = new Predator("Максим", "Тигр", "Рр-р-р");
        Predator bear = new Predator("Мишка", "Медведь", "Роар");
        Herbivore cow = new Herbivore("Мурка", "Корова", "Му-у-у");

        System.out.println("Тип " + tiger.getAnimalName() + ": " + tiger.getAnimalType());
        System.out.println("Класс " + cow.getAnimalName() + ": " + cow.getAnimalClass());
        System.out.println("----------------------");

        Zoo zoo = new Zoo(1);
        try {
            zoo.addAnimal(tiger, 0);
            zoo.addAnimal(tiger, 0);
            zoo.addAnimal(tiger, 0);
            //zoo.addAnimal(bear, 0);
            zoo.addCages(2);
            zoo.addAnimal(cow, 1);
            zoo.addAnimal(bear, 2);
            zoo.addAnimal(bear, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        zoo.walk();
        System.out.println(zoo.getUniqueAnimalClasses());
        System.out.println(zoo.countAnimalTypes());
        System.out.println(zoo.getAnimalsByCount());
    }
}