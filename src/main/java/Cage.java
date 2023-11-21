import java.util.ArrayList;
import java.util.List;

class Cage {
    private List<Animal> animals;

    public Cage() {
        animals = new ArrayList<>();
    }

    public void add(Animal animal) throws Exception {
        if (animals.size() >= 4) {
            throw new Exception("Клетка уже заполнена!");
        }
        for (Animal existingAnimal : animals) {
            if (!isCompatible(animal, existingAnimal)) {
                throw new Exception("Животные несовместимы!");
            }
        }
        animals.add(animal);
    }

    private boolean isCompatible(Animal animal1, Animal animal2) {
        if (animal1.getAnimalType().equals("Хищник") && animal2.getAnimalType().equals("Хищник")
                && !animal1.getAnimalClass().equals(animal2.getAnimalClass())) {
            return false;
        }
        if (!animal1.getAnimalType().equals(animal2.getAnimalType())) {
            return false;
        }
        return true;
    }

    public List<Animal> getAnimals() {
        return animals;
    }


}