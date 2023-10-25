/*
 Необходимо описать класс зоопарк. Предполагается, что в зоопарке расположено 4 клетки. Животных сделать интерфейсом.
 Каждая клетка может быть пустой или содержать ровно одно животное. При попытке посадить в клетку с животным
 новое животное должна возникать исключительная ситуация. Каждое животное может быть либо хищником, либо травоядным.
 У каждого животного можно узнать имя, тип животного, класс животного, а так же услышать голос.
 При "прогулке" по зоопарку посетитель должен услышать голоса всех животных зоопарка или понять, что некоторые из клеток пустые.

 Итерируемый зоопарк, для метода walk, что бы что-то вынести куда-то
*/

public class Main {
    public static void main(String[] args) {
        Predator tiger = new Predator("Максим", "Тигр", "Рр-р-р");
        Herbivore cow = new Herbivore("Мурка", "Корова", "Му-у-у");

        System.out.println("Тип " + tiger.getAnimalName() + ": " + tiger.getAnimalType());
        System.out.println("Класс " + cow.getAnimalName() + ": " + cow.getAnimalClass());
        System.out.println("----------------------");

        Zoo zoo = new Zoo(4);
        try {
            zoo.addAnimal(tiger, 0);
            zoo.addAnimal(cow, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        zoo.walkThroughZoo();
    }
}