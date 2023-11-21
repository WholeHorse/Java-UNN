import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Zoo implements Iterable<Animal> {
    private final List<Cage> cages;

    public Zoo(int cageCount) {
        cages = new ArrayList<>();
        for (int i = 0; i < cageCount; i++) {
            cages.add(new Cage());
        }
    }

    public Set<String> getUniqueAnimalClasses() {
        Set<String> uniqueAnimalClasses = new HashSet<>();
        for (Cage cage : cages) {
            for (Animal animal : cage.getAnimals()) {
                uniqueAnimalClasses.add(animal.getAnimalClass());
            }
        }
        return uniqueAnimalClasses;
    }

    public Set<String> getUniqueAnimalTypes() {
        Set<String> uniqueAnimalTypes = new HashSet<>();
        for (Cage cage : cages) {
            for (Animal animal : cage.getAnimals()) {
                uniqueAnimalTypes.add(animal.getAnimalType());
            }
        }
        return uniqueAnimalTypes;
    }

    public Map<String, Integer> countAnimalClasses() {
        Map<String, Integer> animalCounts = new HashMap<>();
        for (Cage cage : cages) {
            for (Animal animal : cage.getAnimals()) {
                String animalClass = animal.getAnimalClass();
                if (animalCounts.containsKey(animalClass)) {
                    animalCounts.put(animalClass, animalCounts.get(animalClass) + 1);
                } else {
                    animalCounts.put(animalClass, 1);
                }
            }
        }
        return animalCounts;
    }

    public Map<String, Integer> countAnimalTypes() {
        Map<String, Integer> animalCounts = new HashMap<>();
        for (Cage cage : cages) {
            for (Animal animal : cage.getAnimals()) {
                String animalType = animal.getAnimalType();
                if (animalCounts.containsKey(animalType)) {
                    animalCounts.put(animalType, animalCounts.get(animalType) + 1);
                } else {
                    animalCounts.put(animalType, 1);
                }
            }
        }
        return animalCounts;
    }

    public List<String> getAnimalsByCount() {
        Map<String, Integer> animalCounts = countAnimalClasses();
        List<String> animalsByCount = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : animalCounts.entrySet()) {
            animalsByCount.add(entry.getKey() + ": " + entry.getValue());
        }
        Collections.sort(animalsByCount, Collections.reverseOrder());
        return animalsByCount;
    }

    public void addAnimal(Animal animal, int cageIndex) throws Exception {
        cages.get(cageIndex).add(animal);
    }

    public void addCages(int additionalCageCount) {
        for (int i = 0; i < additionalCageCount; i++) {
            cages.add(new Cage());
        }
    }

    @Override
    public Iterator<Animal> iterator() {
        return new Iterator<Animal>() {
            private int cageIndex = 0;
            private int animalIndex = 0;

            @Override
            public boolean hasNext() {
                while (cageIndex < cages.size() && (cages.get(cageIndex).getAnimals() == null
                        || animalIndex >= cages.get(cageIndex).getAnimals().size())) {
                    cageIndex++;
                    animalIndex = 0;
                }
                return cageIndex < cages.size();
            }

            @Override
            public Animal next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return cages.get(cageIndex).getAnimals().get(animalIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }

    public void walk() {
        int i = 1;
        for (Cage cage : cages) {
            List<Animal> animals = cage.getAnimals();
            if (animals.isEmpty()) {
                System.out.println("Клетка " + i + " пуста.");
            } else {
                for (Animal animal : animals) {
                    System.out.println("Клетка " + i + ": " + animal.getAnimalSound());
                }
            }
            i++;
        }
    }
}
